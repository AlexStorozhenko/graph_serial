package com.ptoop.graph.command;

import com.ptoop.graph.model.base.BaseFigure;

/**
 * @author: Alexey Storozhenko
 * @since: 13.03.2018
 */
public interface ICommand<T extends BaseFigure> {
    void execute(T figure);
}
