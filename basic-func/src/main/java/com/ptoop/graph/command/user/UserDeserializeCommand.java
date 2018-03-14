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
public class UserDeserializeCommand extends AbstractUserCommand {

    private SerializationService serializationService;

    public UserDeserializeCommand(Scanner sc, SerializationService serializationService) {
        super(sc);
        this.serializationService = serializationService;
    }

    @Override
    public void execute(List<BaseFigure> figureList, Map<String, AbstractFactory> factoryMap) throws IOException {
        figureList.clear();
        figureList.addAll(serializationService.deserializeFiguresYaml(serialPath));
    }
}
