package com.ptoop.graph.command.user;

import com.ptoop.graph.command.user.AbstractUserCommand;
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
public class UserRemoveCommand extends AbstractUserCommand {

    public UserRemoveCommand(Map<String, AbstractFactory> factoryMap, Scanner sc) {
        super(factoryMap, sc);
    }

    @Override
    public void execute(List<BaseFigure> figureList) throws IOException {
        System.out.print("Type figure number: ");
        int figNum = sc.nextInt();
        if (figNum <= figureList.size()) {
            figureList.remove(figNum - 1);
            System.out.println("Figure #" + figNum + " deleted.");
        } else {
            System.out.println("Figure list size is " + figureList.size());
        }
    }
}
