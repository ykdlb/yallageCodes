package ykdlb.main.work.InventoryManagement;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class inventoryArmClass {

    private ArrayList<String> itemCodes;

    public inventoryArmClass(){

        itemCodes = new ArrayList<String>();

    }

    public void addItemCode(String code){
        itemCodes.add(code);

    }

    public ArrayList<String> getItemCodes(){
        return itemCodes;

    }




}
