package ykdlb.main.work.inventories;

import com.google.gson.Gson;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.io.BukkitObjectInputStream;
import ykdlb.main.work.InventoryManagement.InventoryGroup;
import ykdlb.main.work.InventoryManagement.InventoryManage;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

public class armorInventory implements InventoryHolder {

    private Inventory inv;
    private ItemStack[] Items;

    public armorInventory(Player p){
        inv = Bukkit.createInventory(this,27,"§4§l战斗套组");
        init(p);

    }

    public void init(Player p){

        try{
            Path currentRelativePath = Paths.get("");
            File file = new File(currentRelativePath.toAbsolutePath().toString() + "\\plugins\\PlayerData" + "\\" + p.getUniqueId().toString() + ".json");
            if(!(file.exists())){
                p.sendMessage("Can not find Json file");
                return;
            }
            Gson gson = new Gson();
            Reader reader = new FileReader(file);

            InventoryGroup newInventoryGroup = gson.fromJson(reader,InventoryGroup.class);
            if(newInventoryGroup == null){
                return;
            }
            ArrayList<String> ItemCodes = newInventoryGroup.getArmClass().getItemCodes();
            Items = new ItemStack[ItemCodes.size()];
            if(ItemCodes.size()<1){
                return;
            }
            for(int i =0;i<ItemCodes.size();i++){
                try {
                    ByteArrayOutputStream io = new ByteArrayOutputStream();

                    byte[] serializedObject = Base64.getDecoder().decode(ItemCodes.get(i));

                    //Input stream to read the byte array
                    ByteArrayInputStream in = new ByteArrayInputStream(serializedObject);
                    //object input stream to serialize bytes into objects
                    BukkitObjectInputStream is = new BukkitObjectInputStream(in);

                    //Use the object input stream to deserialize an object from the raw bytes
                    ItemStack newItem = (ItemStack) is.readObject();

                    Items[i] = newItem;


                }catch (ClassNotFoundException ex){
                    System.out.print(ex);
                }

            }
            inv.setContents(Items);


        }catch (IOException ex){
            System.out.print(ex);
        }


    }


    public void setInventory(ItemStack[] items){
        inv.setContents(items);
    }
    @Override
    public Inventory getInventory() {

        return inv;
    }
}
