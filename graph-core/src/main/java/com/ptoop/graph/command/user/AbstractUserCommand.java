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
    protected static final String serialPath = prepareSerialPath();

    private static String prepareSerialPath() {
        String serialPath = System.getProperty("user.dir") + separator + "serialized";
        if (!serialPath.endsWith(separator)) {
            serialPath = serialPath.concat(separator);
        }
        final File directory = new File(serialPath);
        if (!directory.exists()) {
            directory.mkdir();
        }
        return serialPath + "figures.yml";
    }

    public AbstractUserCommand(Map<String, AbstractFactory> factoryMap, Scanner sc) {
        this.factoryMap = factoryMap;
        this.sc = sc;
    }

    abstract public void execute(List<BaseFigure> figureList) throws IOException;
}
