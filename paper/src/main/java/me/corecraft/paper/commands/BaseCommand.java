package me.corecraft.paper.commands;

import com.mojang.brigadier.tree.LiteralCommandNode;
import com.ryderbelserion.vital.paper.api.commands.Command;
import com.ryderbelserion.vital.paper.api.commands.CommandData;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import me.corecraft.paper.CoreCraft;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import org.jetbrains.annotations.NotNull;

public class BaseCommand extends Command {

    private final CoreCraft plugin = CoreCraft.getPlugin();

    @Override
    public void execute(final CommandData commandData) {

    }

    @Override
    public @NotNull final String getPermission() {
        return "corecraft.base";
    }

    @Override
    public @NotNull LiteralCommandNode<CommandSourceStack> literal() {
        return Commands.literal("corecraft")
                .requires(source -> source.getSender().hasPermission(getPermission()))
                .executes(context -> {
                    execute(new CommandData(context));

                    return com.mojang.brigadier.Command.SINGLE_SUCCESS;
                }).build();
    }

    @Override
    public @NotNull final Command registerPermission() {
        final Permission permission = this.plugin.getServer().getPluginManager().getPermission(getPermission());

        if (permission == null) {
            this.plugin.getServer().getPluginManager().addPermission(new Permission(getPermission(), PermissionDefault.OP));
        }

        return this;
    }
}