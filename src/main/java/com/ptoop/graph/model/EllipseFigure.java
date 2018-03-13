package com.ptoop.graph.model;

import com.ptoop.graph.dto.CoordinateDTO;
import com.ptoop.graph.model.base.FormulaFigure;

import java.util.Map;

/**
 * @author: Alexey Storozhenko
 * @since: 09.03.2018
 */
public class EllipseFigure extends FormulaFigure {
    private static final String ellipseFormula = "EllipseFormula";

    public EllipseFigure(CoordinateDTO center, Map<String, Integer> data) {
        super(FigureName.ELLIPSE, ellipseFormula, center, data);
    }
}
