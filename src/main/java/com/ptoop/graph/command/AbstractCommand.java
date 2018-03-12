package com.ptoop.graph.command;

import com.ptoop.graph.model.BaseFigure;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author: Alexey Storozhenko
 * @since: 11.03.2018
 */
public abstract class AbstractCommand<T extends BaseFigure> {
    protected BufferedReader br;
    public AbstractCommand(BufferedReader br) {
        this.br = br;
    }
    abstract public T execute() throws IOException;
}
