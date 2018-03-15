package com.ptoop.graph.model.base;

import com.ptoop.graph.dto.CoordinateDTO;
import com.ptoop.graph.model.NewFigureName;

import java.util.Map;

import static com.ptoop.graph.model.NewFigureType.COMPLEX;

/**
 * @author: Alexey Storozhenko
 * @since: 10.03.2018
 */
public abstract class ComplexFigure extends BaseFigure {

    private String formula;
    private String rule;
    private CoordinateDTO center;
    private Map<String, Integer> valuesMap;

    protected ComplexFigure() {
        super();
    }

    //data for formula-based figures
    protected ComplexFigure(NewFigureName name, String formula, String rule, CoordinateDTO center, Map<String, Integer> valuesMap) {
        super(name.name(), COMPLEX.name());
        this.center = center;
        this.valuesMap = valuesMap;
        this.formula = formula;
        this.rule = rule;
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

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }
}
