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
    private String formula;
    private CoordinateDTO center;
    private Map<String, Integer> valuesMap;


    protected FormulaFigure() {
        super();
    }

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

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public void setCenter(CoordinateDTO center) {
        this.center = center;
    }

    public void setValuesMap(Map<String, Integer> valuesMap) {
        this.valuesMap = valuesMap;
    }
}
