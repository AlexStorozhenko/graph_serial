package com.ptoop.graph.command.user;

import com.ptoop.graph.factory.AbstractFactory;
import com.ptoop.graph.model.base.BaseFigure;
import com.ptoop.graph.service.SerializationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.ptoop.graph.service.DrawFigureService.drawFigure;

/**
 * @author: Alexey Storozhenko
 * @since: 13.03.2018
 */
public class UserDrawCommand extends AbstractUserCommand {

    public UserDrawCommand(Map<String, AbstractFactory> factoryMap, Scanner sc) {
        super(factoryMap, sc);
    }

    @Override
    public void execute(List<BaseFigure> figureList) throws IOException {
        if (figureList.size() > 0) {
            for (BaseFigure figure : figureList) {
                drawFigure(figure);
            }
        } else {
            System.out.println("Figure list is empty");
        }
    }
}
