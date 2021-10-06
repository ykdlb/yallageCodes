package ykdlb.main.work.inventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class missionInventory implements InventoryHolder {

    private Inventory inv;

    public missionInventory(){
        inv = Bukkit.createInventory(this,45,"§4§l任务笔记");
        init();

    }

    public void init(){

    }



    @Override
    public Inventory getInventory() {

        return inv;
    }
}
