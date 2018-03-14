package com.ptoop.graph.command.user;

import com.ptoop.graph.factory.AbstractFactory;
import com.ptoop.graph.model.base.BaseFigure;
import com.ptoop.graph.service.SerializationService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: Alexey Storozhenko
 * @since: 13.03.2018
 */
public class UserSerializeCommand extends AbstractUserCommand {

    private SerializationService serializationService;

    public UserSerializeCommand(Map<String, AbstractFactory> factoryMap, Scanner sc, SerializationService serializationService) {
        super(factoryMap, sc);
        this.serializationService = serializationService;
    }

    @Override
    public void execute(List<BaseFigure> figureList) throws IOException {
        if (figureList.size() > 0) {
            serializationService.serializeFiguresYaml(figureList, serialPath);
        } else {
            System.out.println("Figure list is empty");
        }
    }
}
