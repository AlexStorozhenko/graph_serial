package com.ptoop.graph.model;

/**
 * @author: Alexey Storozhenko
 * @since: 09.03.2018
 */
public abstract class BaseFigure {
    protected final FigureName name;

    protected BaseFigure(FigureName name) {
        this.name = name;
    }

    public FigureName getName() {
        return name;
    }
}
