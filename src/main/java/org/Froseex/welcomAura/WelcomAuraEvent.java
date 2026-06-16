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
        String msg = plugin.getConfig().getString("welcome-message", "fallback");
        double radius = plugin.getConfig().getDouble("radius", 10.0 );
        double radiusSquared = radius * radius;

            for (Player target : world.getPlayers()) {
           if (target.equals(player)) {
               continue;
           }
           double distance = player.getLocation().distanceSquared(target.getLocation());
           if (distance <= radiusSquared) {
               target.sendMessage(msg + playerName);
           }
       }

   }
}
