package com.ptoop.graph.command.user;

import com.ptoop.graph.factory.AbstractFactory;
import com.ptoop.graph.model.base.BaseFigure;
import com.ptoop.graph.service.CoreDrawFigureService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: Alexey Storozhenko
 * @since: 13.03.2018
 */
public class UserDrawCommand extends AbstractUserCommand {

    private CoreDrawFigureService drawFigureService;

    public UserDrawCommand(Map<String, AbstractFactory> factoryMap, Scanner sc, CoreDrawFigureService drawFigureService) {
        super(factoryMap, sc);
        this.drawFigureService = drawFigureService;
    }

    @Override
    public void execute(List<BaseFigure> figureList) throws IOException {
        if (figureList.size() > 0) {
            for (BaseFigure figure : figureList) {
                drawFigureService.drawFigure(figure);
            }
        } else {
            System.out.println("Figure list is empty");
        }
    }
}
