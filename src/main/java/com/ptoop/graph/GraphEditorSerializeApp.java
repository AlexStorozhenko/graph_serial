package com.ptoop.graph;

import com.ptoop.graph.model.base.BaseFigure;
import com.ptoop.graph.service.InitializationService;
import com.ptoop.graph.util.CommandName;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: Alexey Storozhenko
 * @since: 09.03.2018
 */
@SpringBootApplication
public class GraphEditorSerializeApp implements CommandLineRunner {

    private static Scanner sc = null;

    @Autowired
    InitializationService initService;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(GraphEditorSerializeApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<BaseFigure> figureList = new ArrayList<>();
        sc = initService.getScanner();

        System.out.println("  -----  Graphic editor  -----  ");
        System.out.println("");
        try {
            String command = "";
            while (!command.equals("EXIT")) {
                System.out.print("Type command: ");
                command = sc.nextLine().toUpperCase();
                if (EnumUtils.isValidEnum(CommandName.class, command)) {
                    initService.getUserCommandMap().get(command).execute(figureList);
                } else {
                    if (!command.equals("EXIT")) {
                        System.out.println("Command " + command + " not found.");
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
        System.out.println("");
        System.out.println("  -------  END  -------  ");
    }
}
