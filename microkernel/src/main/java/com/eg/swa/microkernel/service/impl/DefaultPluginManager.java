package com.eg.swa.microkernel.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.eg.swa.microkernel.adapters.Plugin;
import com.eg.swa.microkernel.service.PluginManager;

@Service
public class DefaultPluginManager implements PluginManager {

    private Map<String, Plugin> plugins = new HashMap<>();

    @Override
    public void loadPlugin(String pluginName) {
        try {
            Class<?> pluginClass = Class.forName(pluginName);
            Plugin plugin = (Plugin) pluginClass.newInstance();
            plugins.put(pluginName, plugin);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void runPlugin(String pluginName) {
        Plugin plugin = plugins.get(pluginName);
        if (plugin != null) {
            plugin.run();
        }
    }

    @Override
    public void stopPlugin(String pluginName) {
        plugins.remove(pluginName);
    }
}
