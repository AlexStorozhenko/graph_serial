package com.ptoop.graph.service;

import com.ptoop.graph.command.draw.DrawCoordFigureCommand;
import com.ptoop.graph.command.draw.DrawFormulaFigureCommand;
import com.ptoop.graph.command.draw.IDrawCommand;
import com.ptoop.graph.model.FigureType;
import com.ptoop.graph.model.base.BaseFigure;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import static com.ptoop.graph.model.FigureType.COORDINATE;
import static com.ptoop.graph.model.FigureType.FORMULA;

/**
 * @author: Alexey Storozhenko
 * @since: 10.03.2018
 */
@Service
public class BasicDrawFigureService extends CoreDrawFigureService {

    //map of draw commands
    @Override
    @PostConstruct
    protected void createCommandMap()
    {
        commandMap = new HashMap<FigureType, IDrawCommand>();
        commandMap.put(COORDINATE, new DrawCoordFigureCommand());
        commandMap.put(FORMULA, new DrawFormulaFigureCommand());
    }
}
