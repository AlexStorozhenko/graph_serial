package com.ptoop.graph.service;

import com.ptoop.graph.factory.AbstractFactory;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.ServiceLoader;

/**
 * @author: Alexey Storozhenko
 * @since: 13.03.2018
 */
@Service
public class PluginInitService {

    //lookup for inherited class definitions in META-INF folder in app extension jars
    public static Map<String, AbstractFactory> loadPlugins(CoreInitializationService service) {
        CoreDrawFigureService coreDrawService = new CoreDrawFigureService();
        for (final CoreDrawFigureService drawService : ServiceLoader.load(CoreDrawFigureService.class)) {
            drawService.createCommandMap();
            coreDrawService.getCommandMap().putAll(drawService.getCommandMap());
        }
        for (final CoreInitializationService initService : ServiceLoader.load(CoreInitializationService.class)) {
            initService.setDrawFigureService(coreDrawService);
            initService.initializeFactories();
            initService.initializeCommands();
            service.getFactoryMap().putAll(initService.getFactoryMap());
            service.getUserCommandMap().putAll(initService.getUserCommandMap());
        }
        return service.getFactoryMap();
    }
}
