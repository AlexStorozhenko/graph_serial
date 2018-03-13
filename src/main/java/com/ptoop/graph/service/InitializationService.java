package com.ptoop.graph.service;

import com.ptoop.graph.command.user.*;
import com.ptoop.graph.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.ptoop.graph.model.FigureName.*;
import static com.ptoop.graph.model.FigureName.CIRCLE;
import static com.ptoop.graph.model.FigureName.ELLIPSE;
import static com.ptoop.graph.util.CommandName.*;
import static com.ptoop.graph.util.CommandName.ADD;
import static com.ptoop.graph.util.CommandName.UPDATE;

/**
 * @author: Alexey Storozhenko
 * @since: 13.03.2018
 */
@Service
public class InitializationService {
    private Map<String, AbstractFactory> factoryMap;
    private Map<String, AbstractUserCommand> userCommandMap;
    private Scanner scanner;

    @Autowired
    SerializationService serializationService;

    //maps of factories
    @PostConstruct
    public void initializeFactories()
    {
        scanner = new Scanner(System.in);
        factoryMap = new HashMap<String, AbstractFactory>();
        factoryMap.put(LINE.name(), new CreateLineFactory(scanner));
        factoryMap.put(TRIANGLE.name(), new CreateTriangleFactory(scanner));
        factoryMap.put(RECTANGLE.name(), new CreateRectangleFactory(scanner));
        factoryMap.put(TETRAGON.name(), new CreateTetragonFactory(scanner));
        factoryMap.put(CIRCLE.name(), new CreateCircleFactory(scanner));
        factoryMap.put(ELLIPSE.name(), new CreateEllipseFactory(scanner));

        userCommandMap = new HashMap<String, AbstractUserCommand>();
        userCommandMap.put(ADD.name(), new UserAddCommand(factoryMap, scanner));
        userCommandMap.put(UPDATE.name(), new UserEditCommand(factoryMap, scanner));
        userCommandMap.put(REMOVE.name(), new UserRemoveCommand(factoryMap, scanner));
        userCommandMap.put(PRINT.name(), new UserPrintCommand(factoryMap, scanner));
        userCommandMap.put(DRAW.name(), new UserDrawCommand(factoryMap, scanner));
        userCommandMap.put(SERIAL.name(), new UserSerializeCommand(factoryMap, scanner, serializationService));
        userCommandMap.put(DESERIAL.name(), new UserDeserializeCommand(factoryMap, scanner, serializationService));
    }

    public Map<String, AbstractFactory> getFactoryMap() {
        return factoryMap;
    }

    public Map<String, AbstractUserCommand> getUserCommandMap() {
        return userCommandMap;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
