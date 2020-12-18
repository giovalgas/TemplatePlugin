package me.giodev.templatePlugin.commands;

import me.giodev.multiversion.MultiVersionSound;
import me.giodev.templatePlugin.TemplatePlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TemplatePluginCommand implements CommandExecutor {

    TemplatePlugin plugin;

    public TemplatePluginCommand(TemplatePlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command c, String s, String[] args) {

        if(sender instanceof Player){

            Bukkit.getConsoleSender().sendMessage(plugin.getConfigManager().getConsolePrefix() + " It's working!!!");

            Player player = (Player) sender;

            player.sendMessage(plugin.getLanguageManager().getChatPrefix() + plugin.getLanguageManager().getHelloWorld());
            plugin.getLanguageManager().getTestSound().playSound(player);

        }

        return true;
    }
}
