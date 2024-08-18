package me.corecraft.velocity;

import com.google.inject.Inject;
import com.ryderbelserion.velocity.Vital;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import net.kyori.adventure.text.logger.slf4j.ComponentLogger;
import java.nio.file.Path;

@Plugin(id = "corecraft", name = "CoreCraft", version = "0.0.1", description = "the core plugin for play.corecraft.me!", authors = {"ryderbelserion", "svenjareissaus"})
public class CoreCraft extends Vital {

    private static CoreCraft plugin;

    private final ProxyServer server;

    @Inject
    public CoreCraft(final ProxyServer server, final ComponentLogger logger, final @DataDirectory Path directory) {
        super(server, logger, directory, "corecraft");

        this.server = server;

        plugin = this;
    }

    @Subscribe
    public void onInitialize(ProxyInitializeEvent event) {

    }

    public static CoreCraft getPlugin() {
        return plugin;
    }

    public final ProxyServer getServer() {
        return this.server;
    }
}