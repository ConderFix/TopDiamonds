package ru.quizie.topdiamonds.command;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.ImmutableClassToInstanceMap;
import org.bukkit.plugin.Plugin;
import ru.quizie.topdiamonds.command.list.AddItemComamnd;
import ru.quizie.topdiamonds.command.list.TopCommand;

import javax.annotation.Nullable;
import java.util.Collection;

public class SubCommands {
    private final ClassToInstanceMap<SubCommand> commands;

    public SubCommands(Plugin plugin) {
        commands = new ImmutableClassToInstanceMap.Builder<SubCommand>()
                .put(AddItemComamnd.class, new AddItemComamnd())
                .put(TopCommand.class, new TopCommand())
                .build();
    }

    @Nullable
    public SubCommand getCommand(Class<? extends SubCommand> clazz) {
        return commands.get(clazz);
    }

    public Collection<SubCommand> getCommands() {
        return commands.values();
    }
}
