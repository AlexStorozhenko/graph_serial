package com.ptoop.graph.command.user;

import com.ptoop.graph.factory.AbstractFactory;
import com.ptoop.graph.model.base.BaseFigure;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: Alexey Storozhenko
 * @since: 13.03.2018
 */
public class UserAddCommand extends AbstractUserCommand {

    public UserAddCommand(Map<String, AbstractFactory> factoryMap, Scanner sc) {
        super(factoryMap, sc);
    }

    @Override
    public void execute(List<BaseFigure> figureList) throws IOException {
        String figureName = sc.nextLine().toUpperCase();
        if (factoryMap.get(figureName) != null) {
            BaseFigure figure = factoryMap.get(figureName).create();
            figureList.add(figure);
            System.out.println("Figure " + figureName + " added.");
        } else {
            System.out.println("Figure " + figureName + " not found.");
        }
    }
}
