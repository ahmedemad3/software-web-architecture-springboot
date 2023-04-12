package com.eg.swa.microkernel.adapters;

import org.springframework.stereotype.Component;

@Component
public class PluginOne implements Plugin {

    @Override
    public void run() {
        System.out.println("Plugin One is running.");
    }
}

