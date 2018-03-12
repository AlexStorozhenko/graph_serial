package com.ptoop.graph.util;

/**
 * @author: Alexey Storozhenko
 * @since: 10.03.2018
 */
public enum FigureFormula {
    CIRCLE ("Circle formula"),
    ELLIPSE ("Ellipse formula");


    private String formula;

    FigureFormula(String formula) {
        this.formula = formula;
    }

    public String formula() {
        return formula;
    }
}
