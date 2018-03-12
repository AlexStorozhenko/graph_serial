package com.ptoop.graph.model;

import com.ptoop.graph.dto.CoordinateDTO;

import java.util.List;
import java.util.Map;

/**
 * @author: Alexey Storozhenko
 * @since: 10.03.2018
 */
public abstract class FormulaFigure extends BaseFigure{
    final private String formula;
    final private CoordinateDTO center;
    final private Map<String, Integer> valuesMap;

    protected FormulaFigure(FigureName name, String formula, CoordinateDTO center, Map<String, Integer> valuesMap) {
        super(name);
        this.center = center;
        this.valuesMap = valuesMap;
        this.formula = formula;
    }

    public String getFormula() {
        return formula;
    }

    public CoordinateDTO getCenter() {
        return center;
    }

    public Map<String, Integer> getValuesMap() {
        return valuesMap;
    }
}
