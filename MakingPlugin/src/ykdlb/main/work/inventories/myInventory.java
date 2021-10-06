package ykdlb.main.work.inventories;

import com.google.gson.Gson;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import javax.xml.stream.events.StartDocument;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class myInventory implements InventoryHolder {
    private Player p;
    private Inventory inv;

    public myInventory(Player player) throws IOException {
        p = player;
        inv = player.getInventory();
        init();
    }
    public void init() throws IOException {
        ItemStack Sword;
        ItemStack Edge;
        ItemStack Star;
        ItemStack Map;
        ItemStack Book;
        ItemStack Table;
        ItemStack Egg;
        ItemStack Tag;


        List<String> lore = new ArrayList<>();
        List<String> lore2 = new ArrayList<>();
        List<String> lore3 = new ArrayList<>();
        List<String> lore4 = new ArrayList<>();
        List<String> lore5 = new ArrayList<>();
        List<String> lore6 = new ArrayList<>();
        List<String> lore7 = new ArrayList<>();


        lore.add("§o这是你的作战系统");
        lore.add("§o你可以从中选取趁手的兵器");
        lore.add("§o无坚不摧的铠甲");
        lore.add("§o战术消耗品");
        lore.add("§o以及各种小道具");
        lore2.add("§o社交系统为您提供更多的人脉");
        lore2.add("§o所属协会与好友列表请在这里查看");
        lore3.add("是时候遛一遛小宠物了");
        lore3.add("让萌宠跟随你可以让你在犽谷变得更威风哦");
        lore4.add("犽谷的活动或奖励物品都在这里");
        lore5.add("您可以尽情装饰自己的家");
        lore5.add("或者在领地内建造独一无二的建筑");
        lore6.add("您还有未完成的使命");
        lore6.add("加油，冒险者！");
        lore7.add("犽谷地图为您全程导航~");


        Edge = createItem("§a§lSomething",Material.BLACK_STAINED_GLASS_PANE);
        Book = createItem("§b§l任务笔记",Material.WRITABLE_BOOK,lore6);
        Sword = createItem("§b§l战斗套组",Material.NETHERITE_SWORD,lore);
        Star = createItem("§b§l社交",Material.NETHER_STAR,lore2);
        Map = createItem("§b§l地图",Material.MAP,lore7);
        Table = createItem("§b§l建筑物品",Material.CRAFTING_TABLE,lore5);
        Egg = createItem("萌宠",Material.TURTLE_EGG,lore3);
        Tag = createItem("杂项",Material.NAME_TAG,lore4);

        inv.setItem(20,Star);
        inv.setItem(19,Book);
        inv.setItem(21,Egg);
        inv.setItem(22,Sword);
        inv.setItem(25,Map);
        inv.setItem(24,Tag);
        inv.setItem(23,Table);

        for(int i = 9; i<19;i++){
            inv.setItem(i,Edge);

        }
        for(int j = 26; j<36;j++){
            inv.setItem(j,Edge);
        }

    }

    private ItemStack createItem(String name, Material mat, List<String> lore){
        ItemStack item = new ItemStack(mat,1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(name);

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(meta);
        return item;
    }
    private ItemStack createItem(String name, Material mat){
        ItemStack item = new ItemStack(mat,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RESET + "");
        item.setItemMeta(meta);
        return item;
    }


    @Override
    public Inventory getInventory() {
        return inv;
    }
}

