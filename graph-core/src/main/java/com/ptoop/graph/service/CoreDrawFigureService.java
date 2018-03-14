package com.ptoop.graph.service;

import com.ptoop.graph.command.draw.IDrawCommand;
import com.ptoop.graph.model.FigureType;
import com.ptoop.graph.model.base.BaseFigure;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Alexey Storozhenko
 * @since: 10.03.2018
 */
public class CoreDrawFigureService {

    protected Map<FigureType, IDrawCommand> commandMap;

    //map of draw commands
    @PostConstruct
    protected void createCommandMap()
    {
        commandMap = new HashMap<FigureType, IDrawCommand>();
        //commandMap.put(COORDINATE, new DrawCoordFigureCommand());
        //commandMap.put(FORMULA, new DrawFormulaFigureCommand());
    }

    public void drawFigure (BaseFigure figure) {
        System.out.println("Drawing figure...");
        System.out.println(figure.getName());
        if (commandMap.get(figure.getType()) != null) {
            commandMap.get(figure.getType()).execute(figure);
        }
    }

    public Map<FigureType, IDrawCommand> getCommandMap() {
        return commandMap;
    }
}
