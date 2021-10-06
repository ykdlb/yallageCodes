package ykdlb.main.work.Events;

import com.google.gson.Gson;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import ykdlb.main.work.BagPlugin;
import ykdlb.main.work.inventories.BagSelection;
import ykdlb.main.work.inventories.myInventory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        boolean hasJoined = player.hasPlayedBefore();
        try{
            Path currentRelativePath = Paths.get("");
            File file = new File(currentRelativePath.toAbsolutePath().toString()+"\\plugins\\PlayerData"+"\\"+player.getUniqueId().toString()+".json");
            file.getParentFile().mkdir();
            file.createNewFile();
            myInventory PI = new myInventory(player);
        }
        catch (IOException ex){
            System.out.print(ex);
        }



/*
        Gson gson = new Gson();

        Writer writer = new FileWriter(file,false);
        gson.toJson(player.,writer);
        writer.flush();
        writer.close();*/

    }




}
