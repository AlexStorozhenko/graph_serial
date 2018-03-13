package com.ptoop.graph.command.user;

import com.ptoop.graph.factory.AbstractFactory;
import com.ptoop.graph.model.base.BaseFigure;
import com.ptoop.graph.service.SerializationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: Alexey Storozhenko
 * @since: 13.03.2018
 */
public class UserPrintCommand extends AbstractUserCommand {

    public UserPrintCommand(Map<String, AbstractFactory> factoryMap, Scanner sc) {
        super(factoryMap, sc);
    }

    @Override
    public void execute(List<BaseFigure> figureList) throws IOException {
        if (figureList.size() > 0) {
            int i = 0;
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
    }
}
