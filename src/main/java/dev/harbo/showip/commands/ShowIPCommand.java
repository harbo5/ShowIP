package dev.harbo.showip.commands;

import dev.harbo.showip.ShowIP;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.title.TitlePart;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ShowIPCommand implements CommandExecutor {

    final ShowIP plugin;


    public ShowIPCommand(ShowIP plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        if (args.length != 1) {
            sender.sendMessage(
                    Component.text("Usage: /showip <username> - Shows the user their IP in an on screen message"));
        } else {
            try {
                Player p = Bukkit.getPlayer(args[0]);
                assert p != null;
                p.sendTitlePart(TitlePart.TITLE, Component.text(p.getName() + ": " +
                        p.getAddress().toString().split(":")[0].replaceAll("/",""), TextColor.color(0xFFFF55)));
            } catch(Exception ex) {
                sender.sendMessage(Component.text("Player not found."));
            }
        }
        return true;
    }
}
