package com.ptoop.graph.command.draw;

import com.ptoop.graph.model.base.ComplexFigure;

/**
 * @author: Alexey Storozhenko
 * @since: 13.03.2018
 */
public class DrawComplexFigureCommand implements IDrawCommand<ComplexFigure> {

    @Override
    public void execute(ComplexFigure figure) {
        System.out.println("Center: " + figure.getCenter().getAxisX() + ", " + figure.getCenter().getAxisY() + ";");
        System.out.println("Formula: " + figure.getFormula());
        System.out.println("Rule: " + figure.getRule());
        for (String valueKey : figure.getValuesMap().keySet()) {
            System.out.println(valueKey + ": " + figure.getValuesMap().get(valueKey));
        }
    }
}
