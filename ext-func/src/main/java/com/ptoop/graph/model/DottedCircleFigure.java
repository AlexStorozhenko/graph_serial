package com.ptoop.graph.model;

import com.ptoop.graph.dto.CoordinateDTO;
import com.ptoop.graph.model.base.ComplexFigure;

import java.util.Map;

import static com.ptoop.graph.model.NewFigureName.DCIRCLE;

/**
 * @author: Alexey Storozhenko
 * @since: 09.03.2018
 */
public class DottedCircleFigure extends ComplexFigure {
    private static final String circleFormula = "DottedCircleFormula";
    private static final String dottedRule = "DottedRule";

    public DottedCircleFigure() {
        super();
    }
    public DottedCircleFigure(CoordinateDTO center, Map<String, Integer> data) {
       super(DCIRCLE, circleFormula, dottedRule, center, data);
   }
}
