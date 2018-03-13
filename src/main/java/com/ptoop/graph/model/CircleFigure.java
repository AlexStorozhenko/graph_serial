package com.ptoop.graph.model;

import com.ptoop.graph.dto.CoordinateDTO;
import com.ptoop.graph.model.base.FormulaFigure;

import java.util.Map;

/**
 * @author: Alexey Storozhenko
 * @since: 09.03.2018
 */
public class CircleFigure extends FormulaFigure {
    private static final String circleFormula = "CircleFormula";

    public CircleFigure() {
        super();
    }
    public CircleFigure(CoordinateDTO center, Map<String, Integer> data) {
       super(FigureName.CIRCLE, circleFormula, center, data);
   }
}
