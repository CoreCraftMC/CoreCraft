package me.corecraft.velocity;

import com.google.inject.Inject;
import com.ryderbelserion.velocity.Vital;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import net.kyori.adventure.text.logger.slf4j.ComponentLogger;
import java.nio.file.Path;

@Plugin(id = "corecraft", name = "CoreCraft", version = "0.0.1", description = "The core plugin for play.corecraft.me!", authors = {"SvenjaReissaus", "RyderBelserion"})
public class CoreCraft extends Vital {

    private static CoreCraft plugin;

    @Inject
    public CoreCraft(final ProxyServer server, final ComponentLogger logger, final @DataDirectory Path directory) {
        super(server, logger, directory);

        plugin = this;
    }

    @Override
    public final boolean isLegacy() {
        return false;
    }

    @Override
    public final boolean isVerbose() {
        return true;
    }

    public static CoreCraft getPlugin() {
        return plugin;
    }
}