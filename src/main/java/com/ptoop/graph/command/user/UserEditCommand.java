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
public class UserEditCommand extends AbstractUserCommand {

    public UserEditCommand(Map<String, AbstractFactory> factoryMap, Scanner sc) {
        super(factoryMap, sc);
    }

    @Override
    public void execute(List<BaseFigure> figureList) throws IOException {
        System.out.print("Type figure number: ");
        int figNum = sc.nextInt();
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
    }
}
