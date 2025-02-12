package ru.quizie.topdiamonds;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import ru.quizie.topdiamonds.command.TestCommand;
import ru.quizie.topdiamonds.top.TopManager;

public final class TopDiamonds extends JavaPlugin {

    @Getter
    private static TopManager topManager = new TopManager();

    @Override
    public void onEnable() {
        super.getCommand("test").setExecutor(new TestCommand(this));
    }
}
