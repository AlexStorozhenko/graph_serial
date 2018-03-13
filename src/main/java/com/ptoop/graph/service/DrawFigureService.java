package com.ptoop.graph.service;

import com.ptoop.graph.command.draw.DrawCoordFigureCommand;
import com.ptoop.graph.command.draw.DrawFormulaFigureCommand;
import com.ptoop.graph.command.draw.IDrawCommand;
import com.ptoop.graph.model.FigureType;
import com.ptoop.graph.model.base.BaseFigure;

import java.util.HashMap;
import java.util.Map;

import static com.ptoop.graph.model.FigureType.COORDINATE;
import static com.ptoop.graph.model.FigureType.FORMULA;

/**
 * @author: Alexey Storozhenko
 * @since: 10.03.2018
 */
public class DrawFigureService {

    private static final Map<FigureType, IDrawCommand> commandMap = createCommandMap();

    //map of draw commands
    private static Map<FigureType, IDrawCommand> createCommandMap()
    {
        Map<FigureType, IDrawCommand> commandMap = new HashMap<FigureType, IDrawCommand>();
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
