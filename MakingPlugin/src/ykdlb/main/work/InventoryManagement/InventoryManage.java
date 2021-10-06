package ykdlb.main.work.InventoryManagement;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;
import ykdlb.main.work.inventories.BagSelection;
import ykdlb.main.work.inventories.armorInventory;
import ykdlb.main.work.inventories.buildInventory;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class InventoryManage {

    private InventoryGroup Group;
    private Player p;
    private List<InventoryGroup> groups;
    private ItemStack []Items;
    public InventoryManage(Player player){

        p = player;
        Group = new InventoryGroup();
        //reloadItems(Group);

    }

   /* private ItemStack []reloadItems(InventoryGroup InvGroup){

            try{
            Path currentRelativePath = Paths.get("");
            File file = new File(currentRelativePath.toAbsolutePath().toString() + "\\plugins\\PlayerData" + "\\" + p.getUniqueId().toString() + ".json");
            if(!(file.exists())){
                p.sendMessage("Can not find Json file");

            }
            Gson gson = new Gson();
            Reader reader = new FileReader(file);

            InventoryGroup newInventoryGroup = gson.fromJson(reader,InventoryGroup.class);
                ArrayList<String> ItemCodes = newInventoryGroup.getArmClass().getItemCodes();
                Items = new ItemStack[ItemCodes.size()];
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
                arm.setInventory(Items);
                return Items;

            }catch (IOException ex){
                System.out.print(ex);
            }
        return Items;
    }
*/

    public boolean giveItemto(String s,ItemStack item){

        String encodedObject;

        try{
            //Serialize the item(turn it into byte stream)
            ByteArrayOutputStream io = new ByteArrayOutputStream();
            BukkitObjectOutputStream os = new BukkitObjectOutputStream(io);
            os.writeObject(item);
            os.flush();

            byte[] serializedObject = io.toByteArray();

            //Encode the serialized object into to the base64 format
            encodedObject = new String(Base64.getEncoder().encode(serializedObject));

            //Now we are going to do the reverse: decode the string back into raw bytes
            //and then deserialize the byte array into an object

            //decode string into raw bytes
           // serializedObject = Base64.getDecoder().decode(encodedObject);

            //Input stream to read the byte array
           // ByteArrayInputStream in = new ByteArrayInputStream(serializedObject);
            //object input stream to serialize bytes into objects
           // BukkitObjectInputStream is = new BukkitObjectInputStream(in);

            //Use the object input stream to deserialize an object from the raw bytes
            //ItemStack newItem = (ItemStack) is.readObject();

            //p.getInventory().setItemInMainHand(newItem);
            boolean addresult;


               Path currentRelativePath = Paths.get("");
               File file = new File(currentRelativePath.toAbsolutePath().toString() + "\\plugins\\PlayerData" + "\\" + p.getUniqueId().toString() + ".json");
               Gson gson = new Gson();
               Reader reader = new FileReader(file);
               InventoryGroup gp = gson.fromJson(reader,InventoryGroup.class);


                if(gp == null){
                    Writer writer = new FileWriter(file, false);
                    addresult = Group.addItemCode(s,encodedObject);
                    gson.toJson(Group, writer);
                    p.sendMessage("gp is null");
                    writer.flush();
                    writer.close();
                }else{

                    Writer writer = new FileWriter(file, false);
                    p.sendMessage("yesss");
                    addresult = gp.addItemCode(s,encodedObject);
                    gson.toJson(gp, writer);
                    writer.flush();
                    writer.close();
                }


            if(addresult == false){
                    p.sendMessage("拾取物品失败！您的此类背包已满，请及时清理！");
                    return false;
                }






// "{"theTeam":[{"teamId":"1","status":"pending"},{"teamId":"2","status":"member"},{"teamId":"3","status":"member"},{"teamId":"4","status":"pending"}]}"

                /*Path currentRelativePath = Paths.get("");
                File file = new File(currentRelativePath.toAbsolutePath().toString() + "\\plugins\\PlayerData" + "\\" + p.getUniqueId().toString() + ".json");
                file.getParentFile().mkdir();
                file.createNewFile();
                Gson gson = new Gson();
                Writer writer = new FileWriter(file, false);
                gson.toJson(armGroup, writer);
                writer.flush();
                writer.close();*/


        }catch (IOException ex){
            System.out.println(ex);
        }

        return true;
    }




}
