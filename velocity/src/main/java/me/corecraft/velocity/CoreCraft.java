package me.corecraft.velocity;

import com.google.inject.Inject;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import me.corecraft.common.AbstractPlugin;
import net.kyori.adventure.text.logger.slf4j.ComponentLogger;

@Plugin(id = "corecraft", name = "CoreCraft", version = "0.0.1", description = "The core plugin for play.corecraft.me!", authors = {"SvenjaReissaus", "RyderBelserion"})
public class CoreCraft extends AbstractPlugin {

    private final ProxyServer server;
    private final ComponentLogger logger;

    private static CoreCraft plugin;

    @Inject
    public CoreCraft(final ProxyServer server, final ComponentLogger logger) {
        this.server = server;
        this.logger = logger;

        plugin = this;
    }

    public static CoreCraft getPlugin() {
        return plugin;
    }

    public final ProxyServer getServer() {
        return this.server;
    }

    @Override
    public final ComponentLogger getLogger() {
        return this.logger;
    }
}