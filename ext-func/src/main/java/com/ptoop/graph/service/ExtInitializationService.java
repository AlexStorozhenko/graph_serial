package com.ptoop.graph.service;

import com.ptoop.graph.command.user.AbstractUserCommand;
import com.ptoop.graph.factory.AbstractFactory;
import com.ptoop.graph.factory.CreateDottedCircleFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.ptoop.graph.model.NewFigureName.DCIRCLE;

/**
 * @author: Alexey Storozhenko
 * @since: 13.03.2018
 */
@Service
public class ExtInitializationService extends CoreInitializationService{

    //maps of factories
    @PostConstruct
    @Override
    public void initializeFactories()
    {
        scanner = new Scanner(System.in);
        factoryMap = new HashMap<String, AbstractFactory>();
        factoryMap.put(DCIRCLE.name(), new CreateDottedCircleFactory(scanner));
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
