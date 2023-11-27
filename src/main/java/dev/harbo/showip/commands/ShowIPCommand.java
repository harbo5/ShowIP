package dev.harbo.showip.commands;

import dev.harbo.showip.ShowIP;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShowIPCommand implements CommandExecutor {

    final ShowIP plugin;


    public ShowIPCommand(ShowIP plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length != 1) {
            sender.sendMessage("Usage: /showip <username> - Shows the user their IP in an on screen message");
        } else {
            try {
                Player p = Bukkit.getPlayer(args[0]);
                assert p != null;
                p.sendTitle(ChatColor.YELLOW + p.getName() + ": " +
                        p.getAddress().toString().split(":")[0].replaceAll("/",""),null, 20, 200, 20);

            } catch(Exception ex) {
                sender.sendMessage(ChatColor.DARK_RED + "[ShowIP]: " + ChatColor.RED + "Player not found.");
            }
        }
        return true;
    }
}
