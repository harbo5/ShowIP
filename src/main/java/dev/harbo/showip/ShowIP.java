package dev.harbo.showip;

import dev.harbo.showip.commands.ShowIPCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class ShowIP extends JavaPlugin {

    public void onEnable() {
        Objects.requireNonNull(getCommand("showip"))
                .setExecutor(new ShowIPCommand(this));
    }

}
