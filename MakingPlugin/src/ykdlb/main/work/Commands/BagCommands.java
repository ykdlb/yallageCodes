package ykdlb.main.work.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ykdlb.main.work.inventories.BagSelection;

import java.nio.file.Path;
import java.nio.file.Paths;

public class BagCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(!(commandSender instanceof Player)){

            commandSender.sendMessage("只有玩家才能使用此指令嗷~");
            return true;

        }
        Player player = (Player)commandSender;

        if(command.getName().equalsIgnoreCase("Bag")){

            BagSelection gui = new BagSelection();
            player.openInventory(gui.getInventory());

        }



        return true;
    }
}
