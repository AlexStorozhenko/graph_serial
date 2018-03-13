package com.ptoop.graph.command.user;

import com.ptoop.graph.factory.AbstractFactory;
import com.ptoop.graph.model.base.BaseFigure;
import com.ptoop.graph.service.SerializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public UserDeserializeCommand(Map<String, AbstractFactory> factoryMap, Scanner sc, SerializationService serializationService) {
        super(factoryMap, sc);
        this.serializationService = serializationService;
    }

    @Override
    public void execute(List<BaseFigure> figureList) throws IOException {
        figureList.clear();
        figureList.addAll(serializationService.deserializeFiguresYaml(serialPath));
    }
}
