package ru.quizie.topdiamonds.command.list;

import lombok.Getter;
import lombok.NonNull;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;
import ru.quizie.topdiamonds.TopDiamonds;
import ru.quizie.topdiamonds.top.TopPlayer;
import ru.quizie.topdiamonds.command.SubCommand;

import java.util.Collections;
import java.util.List;

public class AddItemComamnd implements SubCommand {

    @Getter
    private final List<String> aliases = List.of("additem");

    @Getter
    private final Permission permission = new Permission("additem.use");

    @Override
    public void onCommand(@NonNull CommandSender sender, @NotNull @NonNull String[] args) {
        if (!(sender instanceof Player)) return;
        final Player player = (Player) sender;

        final ItemStack stack = player.getInventory().getItemInMainHand();
        final int amount = stack.getAmount();

        if (stack == null || stack.getType() != Material.DIAMOND) return;

        stack.setAmount(0);
        sender.sendMessage(ChatColor.GREEN+"Done!");

        TopDiamonds.getTopManager().addTopPlayer(new TopPlayer(amount, player.getName()));
    }

    @Override
    public List<String> onTabComplete(@NonNull CommandSender sender, @NotNull @NonNull String[] args) {
        return Collections.emptyList();
    }

}