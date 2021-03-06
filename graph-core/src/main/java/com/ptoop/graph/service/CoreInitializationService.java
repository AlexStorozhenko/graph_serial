package com.ptoop.graph.service;

import com.ptoop.graph.command.user.AbstractUserCommand;
import com.ptoop.graph.factory.AbstractFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: Alexey Storozhenko
 * @since: 13.03.2018
 */
@Service
public class CoreInitializationService {
    protected Map<String, AbstractFactory> factoryMap;
    protected Map<String, AbstractUserCommand> userCommandMap;
    protected Scanner scanner;

    protected SerializationService serializationService = new SerializationService();
    protected CoreDrawFigureService drawFigureService = new CoreDrawFigureService();

    //maps of factories
    @PostConstruct
    public void initializeFactories()
    {
        scanner = new Scanner(System.in);
        factoryMap = new HashMap<String, AbstractFactory>();

    }

    @PostConstruct
    public void initializeCommands() {
        userCommandMap = new HashMap<String, AbstractUserCommand>();
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

    public CoreDrawFigureService getDrawFigureService() {
        return drawFigureService;
    }

    public void setDrawFigureService(CoreDrawFigureService drawFigureService) {
        this.drawFigureService = drawFigureService;
    }
}
