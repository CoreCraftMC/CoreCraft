package me.corecraft.paper;

import com.ryderbelserion.vital.paper.Vital;
import org.bukkit.plugin.java.JavaPlugin;

public class CoreCraft extends JavaPlugin {

    public static CoreCraft getPlugin() {
        return JavaPlugin.getPlugin(CoreCraft.class);
    }

    @Override
    public void onEnable() {
        final Initializer initializer = new Initializer(this);
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public static class Initializer extends Vital {

        public Initializer(final CoreCraft plugin) {
            super(plugin);
        }

        @Override
        public final boolean isLegacy() {
            return false;
        }

        @Override
        public final boolean isVerbose() {
            return true;
        }
    }
}