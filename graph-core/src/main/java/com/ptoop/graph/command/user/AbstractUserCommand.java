package com.ptoop.graph.command.user;

import com.ptoop.graph.factory.AbstractFactory;
import com.ptoop.graph.model.base.BaseFigure;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.io.File.separator;

/**
 * @author: Alexey Storozhenko
 * @since: 13.03.2018
 */
public abstract class AbstractUserCommand {
    protected Map<String, AbstractFactory> factoryMap;
    protected Scanner sc;

    public AbstractUserCommand(Scanner sc) {
        this.sc = sc;
    }

    abstract public void execute(List<BaseFigure> figureList, Map<String, AbstractFactory> factoryMap) throws IOException;
}
