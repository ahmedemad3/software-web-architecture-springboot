package com.eg.swa.microkernel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eg.swa.microkernel.service.PluginManager;

@RestController
@RequestMapping("/plugins")
public class PluginController {

    @Autowired
    private PluginManager pluginManager;

    @PostMapping("/{pluginName}")
    public void loadPlugin(@PathVariable String pluginName) {
        pluginManager.loadPlugin(pluginName);
    }

    @PostMapping("/{pluginName}/run")
    public void runPlugin(@PathVariable String pluginName) {
        pluginManager.runPlugin(pluginName);
    }

    @PostMapping("/{pluginName}/stop")
    public void stopPlugin(@PathVariable String pluginName) {
        pluginManager.stopPlugin(pluginName);
    }
}

