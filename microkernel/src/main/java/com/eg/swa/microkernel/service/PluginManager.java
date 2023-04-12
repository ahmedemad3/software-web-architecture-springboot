package com.eg.swa.microkernel.service;

public interface PluginManager {
	void loadPlugin(String pluginName);
    void runPlugin(String pluginName);
    void stopPlugin(String pluginName);
}
