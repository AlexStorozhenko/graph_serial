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

    protected Map<String, IDrawCommand> commandMap = new HashMap<String, IDrawCommand>();

    //map of draw commands
    @PostConstruct
    protected void createCommandMap()
    {
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

    public Map<String, IDrawCommand> getCommandMap() {
        return commandMap;
    }
}
