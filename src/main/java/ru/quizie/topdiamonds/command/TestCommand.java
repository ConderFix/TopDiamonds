package ru.quizie.topdiamonds.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCommand implements TabExecutor {

    private final SubCommands subCommands;

    public TestCommand(Plugin plugin) {
        this.subCommands = new SubCommands(plugin);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (args.length < 1) {
            return true;
        }
        final String first_argument = args[0].toLowerCase();
        for (final SubCommand sub : subCommands.getCommands()) {
            for (final String crateArgs : sub.getAliases()) {
                if (crateArgs.equalsIgnoreCase(first_argument)) {
                    if (sub.getPermission() == null || sender.hasPermission(sub.getPermission())){
                        sub.onCommand(sender,args);
                    }
                    return true;
                }
            }
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (args.length == 1) {
            ArrayList<String> tabs = new ArrayList<>();
            for (SubCommand cmd : subCommands.getCommands()) {
                if (cmd.getPermission() == null || sender.hasPermission(cmd.getPermission()))
                    tabs.add(cmd.getAliases().get(0));
            }
            return tabs;
        } else {
            final String first_argument = args[0].toLowerCase();
            for (final SubCommand sub : subCommands.getCommands()) {
                for (final String crateArgs : sub.getAliases()) {
                    if (crateArgs.equalsIgnoreCase(first_argument)
                            && (sub.getPermission() == null || sender.hasPermission(sub.getPermission()))){
                        return sub.onTabComplete(sender,args);
                    }

                }
            }
        }
        return Collections.emptyList();
    }
}
