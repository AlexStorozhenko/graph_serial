package com.ptoop.graph.service;

import com.ptoop.graph.command.user.*;
import com.ptoop.graph.factory.AbstractFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.ptoop.graph.model.FigureName.*;
import static com.ptoop.graph.util.CommandName.*;
import static com.ptoop.graph.util.CryptoCommandName.CDESERIAL;
import static com.ptoop.graph.util.CryptoCommandName.CSERIAL;

/**
 * @author: Alexey Storozhenko
 * @since: 13.03.2018
 */
public class CryptoInitializationService extends CoreInitializationService{

    private CryptoService cryptoService = new CryptoService();

    //crypto commands
    @PostConstruct
    public void initializeCommands() {
        userCommandMap = new HashMap<String, AbstractUserCommand>();
        userCommandMap.put(CSERIAL.name(), new UserCryptoSerializeCommand(scanner, cryptoService));
        userCommandMap.put(CDESERIAL.name(), new UserCryptoDeserializeCommand(scanner, cryptoService));
    }

    public Map<String, AbstractFactory> getFactoryMap() {
        return factoryMap;
    }

    public Map<String, AbstractUserCommand> getUserCommandMap() {
        return userCommandMap;
    }

    public Scanner getScanner() {
        return scanner;
    }

}
