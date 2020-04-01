package com.ptoop.graph;

import com.ptoop.graph.factory.AbstractFactory;
import com.ptoop.graph.model.base.BaseFigure;
import com.ptoop.graph.service.CoreInitializationService;
import com.ptoop.graph.service.PluginInitService;
import com.ptoop.graph.util.CommandName;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: Alexey Storozhenko
 * @since: 09.03.2018
 */
@SpringBootApplication
public class GraphEditorSerializeApp implements CommandLineRunner {

    private static Scanner sc = null;
    private static final String EXIT_COMM = "EXIT";
    private static final String HELP_COMM = "HELP";

    @Qualifier("coreInitializationService")
    @Autowired
    CoreInitializationService initService;

    @Autowired
    PluginInitService pluginInitService;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(GraphEditorSerializeApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<BaseFigure> figureList = new ArrayList<>();
        sc = initService.getScanner();

        Map<String, AbstractFactory> allFactories = pluginInitService.loadPlugins(initService);

        System.out.println("  -----  Graphic editor  -----  ");
        System.out.println();
        try {
            String command = "";
            while (!command.equals(EXIT_COMM)) {
                System.out.print("Type command: ");
                command = sc.nextLine().toUpperCase();
                if (initService.getUserCommandMap().get(command) != null) {
                    initService.getUserCommandMap().get(command).execute(figureList, allFactories);
                } else {
                    switch (command) {
                        case EXIT_COMM:
                            break;
                        case HELP_COMM:
                            System.out.println("Command list:");
                            for (String comm : initService.getUserCommandMap().keySet()) {
                                System.out.println(comm);
                            }
                            break;
                        default:
                            System.out.println("Command " + command + " not found.");
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
        System.out.println();
        System.out.println("  -------  END  -------  ");
    }
}
