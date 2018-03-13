package com.ptoop.graph.command;

import com.ptoop.graph.dto.CoordinateDTO;
import com.ptoop.graph.model.base.CoordinateFigure;

/**
 * @author: Alexey Storozhenko
 * @since: 13.03.2018
 */
public class DrawCoordFigureCommand implements ICommand<CoordinateFigure> {

    @Override
    public void execute(CoordinateFigure figure) {
        for (CoordinateDTO dto : figure.getCoordinateList()) {
            System.out.print(dto.getAxisX() + ", " + dto.getAxisY() + "; ");
            System.out.println();
        }
    }
}
