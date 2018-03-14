package com.ptoop.graph.service;

import org.springframework.stereotype.Service;

import java.util.ServiceLoader;

/**
 * @author: Alexey Storozhenko
 * @since: 13.03.2018
 */
@Service
public class PluginInitService {

    //lookup for inherited class definitions in META-INF folder in app extension jars
    public static void loadPlugins(CoreInitializationService service) {
        for (final CoreInitializationService initService : ServiceLoader.load(CoreInitializationService.class)) {
            initService.initializeFactories();
            service.getFactoryMap().putAll(initService.getFactoryMap());
            service.getUserCommandMap().putAll(initService.getUserCommandMap());
        }
//        for (final CoreDrawFigureService drawService : ServiceLoader.load(CoreDrawFigureService.class)) {
//            drawService.createCommandMap();
//            drawFigureService.getCommandMap().putAll(drawService.getCommandMap());
//        }
    }
}
