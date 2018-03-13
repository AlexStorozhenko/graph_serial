package com.ptoop.graph.command.draw;

import com.ptoop.graph.model.base.BaseFigure;

/**
 * @author: Alexey Storozhenko
 * @since: 13.03.2018
 */
public interface IDrawCommand<T extends BaseFigure> {
    void execute(T figure);
}
