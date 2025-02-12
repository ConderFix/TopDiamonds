package ru.quizie.topdiamonds.command.list;

import lombok.Getter;
import lombok.NonNull;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;
import ru.quizie.topdiamonds.TopDiamonds;
import ru.quizie.topdiamonds.command.SubCommand;

import java.util.Collections;
import java.util.List;

public class TopCommand implements SubCommand {

    @Getter
    private final List<String> aliases = List.of("top");

    @Getter
    private final Permission permission = new Permission("top.use");


    @Override
    public void onCommand(@NonNull CommandSender sender, @NotNull @NonNull String[] args) {
        if (!(sender instanceof Player)) return;

        TopDiamonds.getTopManager().sort();
        sender.sendMessage(TopDiamonds.getTopManager().getTopPlayers(10));

    }

    @Override
    public List<String> onTabComplete(@NonNull CommandSender sender, @NotNull @NonNull String[] args) {
        return Collections.emptyList();
    }
}