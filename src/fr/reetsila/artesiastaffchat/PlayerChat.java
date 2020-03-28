package fr.reetsila.artesiastaffchat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        Player player = e.getPlayer();
        if (e.getMessage().startsWith("$") && player.hasPermission("staffchat")){
            e.setCancelled(true);
            for (Player players : Bukkit.getOnlinePlayers()){
                if (players.hasPermission("staffchat")){
                    players.sendMessage("§7(§4Staff§7) §c" + player.getName() + "§f:§b" + e.getMessage().substring(1));
                }
            }
        }
    }
}
