package ykdlb.main.work;

import org.bukkit.plugin.java.JavaPlugin;
import ykdlb.main.work.Commands.BagCommands;
import ykdlb.main.work.Commands.addItems;
import ykdlb.main.work.Events.PickUpEvent;
import ykdlb.main.work.Events.PlayerInventoryClickEvent;
import ykdlb.main.work.Events.PlayerJoin;

public class BagPlugin extends JavaPlugin {

    private static BagPlugin plugin;


    public static BagPlugin getPlugin() {

        return plugin;
    }

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage("背包插件启动");
        getCommand("Bag").setExecutor(new BagCommands());
        getCommand("get").setExecutor(new addItems());
        getServer().getPluginManager().registerEvents(new PlayerJoin(),this);
        getServer().getPluginManager().registerEvents(new PlayerInventoryClickEvent(),this);
        getServer().getPluginManager().registerEvents(new PickUpEvent(),this);
    }

    @Override
    public void onDisable() {

        getServer().getConsoleSender().sendMessage("背包插件关闭");
    }
}