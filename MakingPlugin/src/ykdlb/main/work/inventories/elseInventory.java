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

public class elseInventory implements InventoryHolder {

    private Inventory inv;

    public elseInventory(){
        inv = Bukkit.createInventory(this,27,"§4§l杂项");
        init();

    }

    public void init(){

    }



    @Override
    public Inventory getInventory() {

        return inv;
    }
}
