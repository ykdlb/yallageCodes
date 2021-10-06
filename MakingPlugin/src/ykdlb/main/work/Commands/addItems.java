package ykdlb.main.work.Commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import ykdlb.main.work.InventoryManagement.InventoryManage;
import ykdlb.main.work.inventories.BagSelection;

public class addItems implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(!(commandSender instanceof Player)){

            commandSender.sendMessage("只有玩家才能使用此指令嗷~");
            return true;

        }
        Player player = (Player)commandSender;

        if(command.getName().equalsIgnoreCase("get")){

            ItemStack item1 = new ItemStack(Material.BROWN_STAINED_GLASS, 2);
            ItemStack item2 = new ItemStack(Material.CRAFTING_TABLE, 1);
            ItemStack item3 = new ItemStack(Material.SALMON_BUCKET,3);
            ItemStack item4 = new ItemStack(Material.SALMON_BUCKET,5);
            InventoryManage mag = new InventoryManage(player);
            mag.giveItemto("arm",item1);
            mag.giveItemto("arm",item2);
            mag.giveItemto("build",item3);
            mag.giveItemto("build",item4);

        }



        return true;
    }
}
