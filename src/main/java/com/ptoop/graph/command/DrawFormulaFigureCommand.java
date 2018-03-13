package com.ptoop.graph.command;

import com.ptoop.graph.model.base.FormulaFigure;

/**
 * @author: Alexey Storozhenko
 * @since: 13.03.2018
 */
public class DrawFormulaFigureCommand implements ICommand<FormulaFigure> {

    @Override
    public void execute(FormulaFigure figure) {
        System.out.println("Center: " + figure.getCenter().getAxisX() + ", " + figure.getCenter().getAxisY() + ";");
        System.out.println("Formula: " + figure.getFormula());
        for (String valueKey : figure.getValuesMap().keySet()) {
            System.out.println(valueKey + ": " + figure.getValuesMap().get(valueKey));
        }
    }
}
