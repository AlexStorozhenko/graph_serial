package com.ptoop.graph.service;

import com.ptoop.graph.dto.CoordinateDTO;
import com.ptoop.graph.model.BaseFigure;
import com.ptoop.graph.model.CoordinateFigure;
import com.ptoop.graph.model.FormulaFigure;

/**
 * @author: Alexey Storozhenko
 * @since: 10.03.2018
 */
public class DrawFigureService {
    public static void drawFigure (BaseFigure figure) {
        System.out.println("Drawing figure...");
        System.out.println(figure.getName());
        if (figure instanceof CoordinateFigure) {
            drawCoordFigure((CoordinateFigure) figure);
        } else if (figure instanceof FormulaFigure) {
            drawFormulaFigure((FormulaFigure) figure);
        }
    }

    private static void drawCoordFigure(CoordinateFigure figure) {
        for (CoordinateDTO dto : figure.getCoordinateList()) {
            System.out.print(dto.getAxisX() + ", " + dto.getAxisY() + "; ");
            System.out.println();
        }
    }

    private static void drawFormulaFigure(FormulaFigure figure) {
        System.out.println("Center: " + figure.getCenter().getAxisX() + ", " + figure.getCenter().getAxisY() + ";");
        System.out.println("Formula: " + figure.getFormula());
        for (String valueKey : figure.getValuesMap().keySet()) {
            System.out.println(valueKey + ": " + figure.getValuesMap().get(valueKey));
        }
    }
}
