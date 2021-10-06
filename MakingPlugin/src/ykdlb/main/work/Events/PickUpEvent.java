package ykdlb.main.work.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PickUpEvent implements Listener {
    @EventHandler
    public void PlayerPicking(EntityPickupItemEvent e){
        e.setCancelled(true);
    }


}
