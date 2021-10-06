package ykdlb.main.work.InventoryManagement;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Bukkit.getServer;

public class InventoryGroup {

    private inventoryArmClass Arm;
    private inventoryBuildClass Build;


    public InventoryGroup(){

        Arm = new inventoryArmClass();
        Build = new inventoryBuildClass();

    }

    public boolean addItemCode(String type, String code){
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN+"Counter");
        if(type.equalsIgnoreCase("arm")){

            if(Arm.getItemCodes().size()>=27){
                return false;
            }
            Arm.addItemCode(code);
            return true;

        }else if(type.equalsIgnoreCase("build")){

            if(Arm.getItemCodes().size()>=27){
                return false;
            }
            Build.addItemCode(code);

        }
        return true;
    }
    public inventoryArmClass getArmClass(){
        return Arm;
    }


    public inventoryBuildClass getBuildClass(){

        return Build;

    }





}
