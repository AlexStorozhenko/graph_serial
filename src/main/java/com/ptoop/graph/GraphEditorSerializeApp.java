package com.ptoop.graph;

import com.ptoop.graph.command.DrawCoordFigureCommand;
import com.ptoop.graph.command.DrawFormulaFigureCommand;
import com.ptoop.graph.command.ICommand;
import com.ptoop.graph.factory.*;
import com.ptoop.graph.model.FigureType;
import com.ptoop.graph.model.base.BaseFigure;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static com.ptoop.graph.model.FigureName.*;
import static com.ptoop.graph.model.FigureType.COORDINATE;
import static com.ptoop.graph.model.FigureType.FORMULA;
import static com.ptoop.graph.service.DrawFigureService.drawFigure;
import static com.ptoop.graph.service.SerializationService.deserializeFigures;
import static com.ptoop.graph.service.SerializationService.serializeFigures;
import static java.io.File.separator;

/**
 * @author: Alexey Storozhenko
 * @since: 09.03.2018
 */
@SpringBootApplication
public class GraphEditorSerializeApp implements CommandLineRunner {

    private static final String addComm = "ADD";
    private static final String editComm = "UPDATE";
    private static final String removeComm = "REMOVE";
    private static final String exitComm = "EXIT";
    private static final String serialComm = "SERIAL";
    private static final String deserialComm = "DESERIAL";
    private static final String printComm = "PRINT";
    private static final String drawComm = "DRAW";
    private static String serialPath = System.getProperty("user.dir") + "/serialized/";

    private static Scanner sc = null;
    private static final Map<String, AbstractFactory> factoryMap = createFactoryMap();

    //map of factories
    private static Map<String, AbstractFactory> createFactoryMap()
    {
        sc = new Scanner(System.in);
        Map<String, AbstractFactory> factoryMap = new HashMap<String, AbstractFactory>();
        factoryMap.put(LINE.name(), new CreateLineFactory(sc));
        factoryMap.put(TRIANGLE.name(), new CreateTriangleFactory(sc));
        factoryMap.put(RECTANGLE.name(), new CreateRectangleFactory(sc));
        factoryMap.put(TETRAGON.name(), new CreateTetragonFactory(sc));
        factoryMap.put(CIRCLE.name(), new CreateCircleFactory(sc));
        factoryMap.put(ELLIPSE.name(), new CreateEllipseFactory(sc));
        return factoryMap;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(GraphEditorSerializeApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //folder preparing
        List<BaseFigure> figureList = new ArrayList<>();
        if (!serialPath.endsWith(separator)) {
            serialPath = serialPath.concat(separator);
        }
        final File directory = new File(serialPath);
        if (!directory.exists()) {
            directory.mkdir();
        }

        System.out.println("  -----  Graphic editor  -----  ");
        System.out.println("");
        try {
            String command = "";
            String figureName;
            Integer figNum;
            int i;
            while (!command.equals(exitComm)) {
                figureName = null;
                figNum = null;
                System.out.print("Type command: ");
                command = sc.nextLine().toUpperCase();

                //user command interface
                switch (command) {
                    //figure creation
                    case addComm:
                        System.out.print("Type figure name: ");
                        figureName = sc.nextLine().toUpperCase();
                        if (factoryMap.get(figureName) != null) {
                            BaseFigure figure = factoryMap.get(figureName).create();
                            figureList.add(figure);
                            System.out.println("Figure " + figureName + " added.");
                        } else {
                            System.out.println("Figure " + figureName + " not found.");
                        }
                        break;
                    //figure update
                    case editComm:
                        System.out.print("Type figure number: ");
                        figNum = sc.nextInt();
                        sc.nextLine();
                        if (figNum <= figureList.size()) {
                            BaseFigure figure = figureList.get(figNum - 1);
                            if (figure != null) {
                                factoryMap.get(figure.getName().name()).update(figure);
                                System.out.println("Figure #" + figNum + " updated.");
                            }
                        } else {
                            System.out.println("Figure list size is " + figureList.size());
                        }
                        break;
                    //figure delete
                    case removeComm:
                        System.out.print("Type figure number: ");
                        figNum = sc.nextInt();
                        if (figNum <= figureList.size()) {
                            figureList.remove(figNum - 1);
                            System.out.println("Figure #" + figNum + " deleted.");
                        } else {
                            System.out.println("Figure list size is " + figureList.size());
                        }
                        break;
                    //figure list serialization
                    case serialComm:
                        if (figureList.size() > 0) {
                            serializeFigures(figureList, serialPath);
                        } else {
                            System.out.println("Figure list is empty");
                        }
                        break;
                    //figure list deserialization
                    case deserialComm:
                        figureList = deserializeFigures(serialPath);
                        break;
                    //figure list print
                    case printComm:
                        if (figureList.size() > 0) {
                            i = 0;
                            for (BaseFigure figure : figureList) {
                                i++;
                                System.out.println("# " + i);
                                System.out.println("Name: " + figure.getName());
                                System.out.println("Descr.: " + figure.getDescription());
                                System.out.println("Date: " + figure.getCreationDate().toString());
                                System.out.println("---");
                            }
                        } else {
                            System.out.println("Figure list is empty");
                        }
                        break;
                    //figure list drawing
                    case drawComm:
                        if (figureList.size() > 0) {
                            for (BaseFigure figure : figureList) {
                                drawFigure(figure);
                            }
                        } else {
                            System.out.println("Figure list is empty");
                        }
                        break;
                    case exitComm:
                        break;
                    default:
                        System.out.println("Unsupported command: " + command);
                        break;
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
