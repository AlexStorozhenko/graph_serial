package com.ptoop.graph.service;

import com.ptoop.graph.command.DrawCoordFigureCommand;
import com.ptoop.graph.command.DrawFormulaFigureCommand;
import com.ptoop.graph.command.ICommand;
import com.ptoop.graph.dto.CoordinateDTO;
import com.ptoop.graph.model.FigureType;
import com.ptoop.graph.model.base.BaseFigure;
import com.ptoop.graph.model.base.CoordinateFigure;
import com.ptoop.graph.model.base.FormulaFigure;

import java.util.HashMap;
import java.util.Map;

import static com.ptoop.graph.model.FigureType.COORDINATE;
import static com.ptoop.graph.model.FigureType.FORMULA;

/**
 * @author: Alexey Storozhenko
 * @since: 10.03.2018
 */
public class DrawFigureService {

    private static final Map<FigureType, ICommand> commandMap = createCommandMap();

    //map of draw commands
    private static Map<FigureType, ICommand> createCommandMap()
    {
        Map<FigureType, ICommand> commandMap = new HashMap<FigureType, ICommand>();
        commandMap.put(COORDINATE, new DrawCoordFigureCommand());
        commandMap.put(FORMULA, new DrawFormulaFigureCommand());
        return commandMap;
    }

    public static void drawFigure (BaseFigure figure) {
        System.out.println("Drawing figure...");
        System.out.println(figure.getName());
        commandMap.get(figure.getType()).execute(figure);
    }
}
