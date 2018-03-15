package com.ptoop.graph.command.user;

import com.ptoop.graph.factory.AbstractFactory;
import com.ptoop.graph.model.base.BaseFigure;
import com.ptoop.graph.service.CryptoService;
import com.ptoop.graph.service.SerializationService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: Alexey Storozhenko
 * @since: 13.03.2018
 */
public class UserCryptoSerializeCommand extends AbstractUserCommand {

    private CryptoService cryptoService;

    public UserCryptoSerializeCommand(Scanner sc, CryptoService cryptoService) {
        super(sc);
        this.cryptoService = cryptoService;
    }

    @Override
    public void execute(List<BaseFigure> figureList, Map<String, AbstractFactory> factoryMap) throws IOException {
        if (figureList.size() > 0) {
            cryptoService.encryptAndSerializeFigures(figureList);
        } else {
            System.out.println("Figure list is empty");
        }
    }
}
