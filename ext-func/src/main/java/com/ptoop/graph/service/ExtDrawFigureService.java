package com.ptoop.graph.service;

import com.ptoop.graph.command.draw.IDrawCommand;
import com.ptoop.graph.command.draw.DrawComplexFigureCommand;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;

import static com.ptoop.graph.model.NewFigureType.COMPLEX;

/**
 * @author: Alexey Storozhenko
 * @since: 10.03.2018
 */
@Service
public class ExtDrawFigureService extends CoreDrawFigureService {

    //map of draw commands
    @Override
    @PostConstruct
    protected void createCommandMap()
    {
        commandMap = new HashMap<String, IDrawCommand>();
        commandMap.put(COMPLEX.name(), new DrawComplexFigureCommand());
    }
}
