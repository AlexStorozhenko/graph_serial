package com.ptoop.graph.model.base;

import com.ptoop.graph.dto.CoordinateDTO;
import com.ptoop.graph.model.FigureName;

import java.util.Map;

import static com.ptoop.graph.model.FigureType.FORMULA;

/**
 * @author: Alexey Storozhenko
 * @since: 10.03.2018
 */
public abstract class FormulaFigure extends BaseFigure{
    private final String formula;
    private final CoordinateDTO center;
    private final Map<String, Integer> valuesMap;

    //data for formula-based figures
    protected FormulaFigure(FigureName name, String formula, CoordinateDTO center, Map<String, Integer> valuesMap) {
        super(name, FORMULA);
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
