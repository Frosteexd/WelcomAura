package org.Froseex.welcomAura;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class WelcomAuraEvent implements Listener {
    private final JavaPlugin plugin;
    public WelcomAuraEvent(JavaPlugin plugin) {
        this.plugin = plugin;
    }


    @EventHandler


   public void onJoin(PlayerJoinEvent event) {
       Player player = event.getPlayer();
       String playerName = player.getName();
       World world = player.getWorld();
        if (!(plugin.getConfig().isSet("welcome-message"))) {
            Bukkit.getLogger().info("Не удалось найти config.yml");
            return;
        }
            for (Player target : world.getPlayers()) {
           if (target.equals(player)) {
               continue;
           }
           double distance = player.getLocation().distanceSquared(target.getLocation());
           if (distance <= 100) {
               String welcomeMessage = plugin.getConfig().getString("welcome-message", "Возле вас игрок ");
               target.sendMessage(welcomeMessage + playerName);
           }
       }

   }
}
