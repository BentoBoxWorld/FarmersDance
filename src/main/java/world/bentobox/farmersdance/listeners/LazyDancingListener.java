//
// Created by BONNe
// Copyright - 2022
//


package world.bentobox.farmersdance.listeners;


import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.scheduler.BukkitTask;

import org.jetbrains.annotations.NotNull;
import world.bentobox.bentobox.util.Util;
import world.bentobox.farmersdance.FarmersDanceAddon;


/**
 * This class manages player lazy dancing. Lazy dancing means player just need to hold
 * shift and not actively dance.
 */
public class LazyDancingListener extends DancingHandler implements Listener
{
    /**
     * The constructor.
     * @param addon Instance of Farmers Dance addon.
     */
    public LazyDancingListener(FarmersDanceAddon addon)
    {
        super(addon);
    }


    /**
     * The main dancing handler.
     * @param event Player Toggle Sneak Event.
     */
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onDancing(@NotNull PlayerToggleSneakEvent event)
    {
        Player player = event.getPlayer();
        World world = player.getWorld();

        if (!this.addon.getPlugin().getIWM().inWorld(Util.getWorld(world)))
        {
            // Not in a BentoBox world.
            return;
        }

        if (player.isFlying() || player.isClimbing() || player.isInsideVehicle())
        {
            // Flying, climbing and riding vehicle are not dancing
            return;
        }

        if (!event.isSneaking())
        {
            BukkitTask remove = this.twerkingTasks.remove(player.getUniqueId());

            if (remove != null)
            {
                remove.cancel();
            }

            // This is unshifting.
            return;
        }

        if (!player.hasPermission(this.addon.getPlugin().getIWM().getPermissionPrefix(world) + "farmersdance"))
        {
            // Player does not have permission to dance.
            return;
        }

        if (!this.checkIsland(event, player, player.getLocation(), FarmersDanceAddon.FARMER_DANCE, false))
        {
            // Player is not allowed to dance on this island.
            return;
        }

        if (this.twerkingTasks.containsKey(player.getUniqueId()))
        {
            // Task is already running.
            return;
        }

        BukkitTask bukkitTask = Bukkit.getScheduler().runTaskTimer(
            this.addon.getPlugin(),
            () -> this.buildTask(world, player),
            0,
            1);

        this.twerkingTasks.put(player.getUniqueId(), bukkitTask);
    }
}
