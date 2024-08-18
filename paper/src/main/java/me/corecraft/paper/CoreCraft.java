package me.corecraft.paper;

import com.ryderbelserion.vital.paper.Vital;
import org.bukkit.plugin.java.JavaPlugin;

public class CoreCraft extends Vital {

    public static CoreCraft getPlugin() {
        return JavaPlugin.getPlugin(CoreCraft.class);
    }

    @Override
    public void onEnable() {
        super.start();
    }

    @Override
    public void onDisable() {

    }
}