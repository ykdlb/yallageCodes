package ykdlb.main.work.inventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BagSelection implements InventoryHolder {

    private Inventory inv;

    public BagSelection(){
        inv = Bukkit.createInventory(this,54,"犽谷背包");
        init();

    }

    public void init(){
        //Edge
        ItemStack item;
        ItemStack Sword;
        item = createItem("§a§lSomething",Material.BLACK_STAINED_GLASS_PANE, Collections.singletonList("§7Put something"));
        for(int i = 0; i<10;i++){
            inv.setItem(i, item);
        }
        inv.setItem(17,item);
        inv.setItem(18,item);
        inv.setItem(26,item);
        inv.setItem(27,item);
        inv.setItem(35,item);
        inv.setItem(36,item);
        inv.setItem(44,item);
        for(int i = 44; i<54;i++){
            inv.setItem(i, item);
        }

        //Sword

        List<String> lore = new ArrayList<>();
        lore.add("这是你的武器库");
        lore.add("你可以从中选取趁手的兵器");
        Sword = createItem("§b§l武器",Material.IRON_SWORD,lore);
        inv.setItem(10,Sword);

    }

    private ItemStack createItem(String name, Material mat, List<String> lore){
        ItemStack item = new ItemStack(mat,1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(name);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public Inventory getInventory() {

        return inv;
    }
}
