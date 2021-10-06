package ykdlb.main.work.Events;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import ykdlb.main.work.InventoryManagement.InventoryManage;
import ykdlb.main.work.inventories.*;

import java.io.FileNotFoundException;

public class PlayerInventoryClickEvent implements Listener {
    @EventHandler
    public void clickPlayerInventory(InventoryClickEvent e){
        if(e.getClickedInventory()==null){
            return;
        }
        if(e.getClickedInventory().getHolder().getInventory() instanceof PlayerInventory){
            Player player = (Player) e.getWhoClicked();
            if(!(player.getGameMode() == GameMode.CREATIVE)){
                e.setCancelled(true);
            }

            if (e.isLeftClick()) {
                if (e.getCurrentItem() == null) {
                    return;
                }

                InventoryManage mag = new InventoryManage(player);
                if (e.getCurrentItem().getType() == Material.NETHERITE_SWORD) {

                    armorInventory gui = new armorInventory(player);

                    player.openInventory(gui.getInventory());


                } else if (e.getCurrentItem().getType() == Material.WRITABLE_BOOK) {
                    missionInventory gui = new missionInventory();
                    player.openInventory(gui.getInventory());

                } else if (e.getCurrentItem().getType() == Material.CRAFTING_TABLE) {
                    buildInventory gui = new buildInventory(player);

                    player.openInventory(gui.getInventory());
                } else if (e.getCurrentItem().getType() == Material.TURTLE_EGG) {
                    petInventory gui = new petInventory();
                    player.openInventory(gui.getInventory());


                } else if (e.getCurrentItem().getType() == Material.MAP) {
                    mapInventory gui = new mapInventory();
                    player.openInventory(gui.getInventory());


                }else if (e.getCurrentItem().getType() == Material.NAME_TAG) {
                    elseInventory gui = new elseInventory();
                    player.openInventory(gui.getInventory());


                } else if (e.getCurrentItem().getType() == Material.NETHER_STAR) {

                    socialInventory gui = new socialInventory();
                    player.openInventory(gui.getInventory());


            }

            }

        }

    }




}
