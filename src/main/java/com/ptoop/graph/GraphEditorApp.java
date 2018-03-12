package com.ptoop.graph;

import com.ptoop.graph.command.*;
import com.ptoop.graph.model.BaseFigure;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static com.ptoop.graph.model.FigureName.*;
import static com.ptoop.graph.service.DrawFigureService.drawFigure;

/**
 * @author: Alexey Storozhenko
 * @since: 09.03.2018
 */
@SpringBootApplication
public class GraphEditorApp implements CommandLineRunner {

    private static BufferedReader br = null;
    private static final Map<String, AbstractCommand> commandMap = createMap();

    private static Map<String, AbstractCommand> createMap()
    {
        br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, AbstractCommand> commandMap = new HashMap<String, AbstractCommand>();
        commandMap.put(LINE.name(), new CreateLineCommand(br));
        commandMap.put(TRIANGLE.name(), new CreateTriangleCommand(br));
        commandMap.put(RECTANGLE.name(), new CreateRectangleCommand(br));
        commandMap.put(TETRAGON.name(), new CreateTetragonCommand(br));
        commandMap.put(CIRCLE.name(), new CreateCircleCommand(br));
        commandMap.put(ELLIPSE.name(), new CreateEllipseCommand(br));
        return commandMap;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(GraphEditorApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("  -----  Graphical editor  -----  ");
        System.out.println("");
        try {
            String figureName = "";
            while (!figureName.equals("EXIT")) {
                System.out.print("Type figure name: ");
                figureName = br.readLine().toUpperCase();
                if (commandMap.get(figureName) != null) {
                    BaseFigure figure = commandMap.get(figureName).execute();
                    drawFigure(figure);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("");
        System.out.println("  -------  END  -------  ");
    }
}
