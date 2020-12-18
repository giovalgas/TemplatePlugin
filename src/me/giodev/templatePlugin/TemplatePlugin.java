package me.giodev.templatePlugin;

import me.giodev.templatePlugin.commands.TemplatePluginCommand;
import me.giodev.templatePlugin.config.ConfigManager;
import me.giodev.templatePlugin.language.LanguageManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.java.JavaPlugin;

public class TemplatePlugin extends JavaPlugin {

    private ConfigManager configManager;
    private LanguageManager languageManager;

    @Override
    public void onEnable(){

        //Load config & language
        loadConfig();
        loadLang();

        //Commands & Events
        getCommand("tpcommand").setExecutor(new TemplatePluginCommand(this));

        Bukkit.getConsoleSender().sendMessage(configManager.getConsolePrefix() + "Plugin fully started");
    }

    private void loadConfig(){
        try {
            this.configManager = new ConfigManager(this);
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    private void loadLang(){
        try {
            this.languageManager = new LanguageManager(this);
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public LanguageManager getLanguageManager() {
        return languageManager;
    }
}