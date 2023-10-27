package myplugin.wikiplugin;

import myplugin.wikiplugin.commands.Menu;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public final class WikiPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        PluginManager manager = Bukkit.getServer().getPluginManager();

        Bukkit.getLogger().info("FermiumMC Wiki Plugin started successfully.");

        getCommand("menu").setExecutor(new Menu());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
