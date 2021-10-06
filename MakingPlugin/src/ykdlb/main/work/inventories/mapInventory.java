package ykdlb.main.work.inventories;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class mapInventory implements InventoryHolder {

    private Inventory inv;

    public mapInventory(){
        inv = Bukkit.createInventory(this,54,"§4§l犽谷地图");
        init();
    }

    public void init(){

    }



    @Override
    public Inventory getInventory() {

        return inv;
    }
}
