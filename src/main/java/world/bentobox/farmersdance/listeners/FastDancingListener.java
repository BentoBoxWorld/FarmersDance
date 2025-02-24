//
// Created by BONNe
// Copyright - 2022
//


package world.bentobox.farmersdance.listeners;


import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import world.bentobox.bentobox.util.Util;
import world.bentobox.farmersdance.FarmersDanceAddon;


/**
 * This class manages player dancing. Dancing means player just need to press and release
 * shift.
 */
public class FastDancingListener extends DancingHandler implements Listener
{
    /**
     * The constructor.
     * @param addon Instance of Farmers Dance addon.
     */
    public FastDancingListener(FarmersDanceAddon addon)
    {
        super(addon);
        this.dancingCounter = new HashMap<>();

        this.clearerTask = Bukkit.getScheduler().runTaskTimerAsynchronously(this.addon.getPlugin(),
            this::clearDanceMoves,
            100L,
            40L);
    }


    /**
     * This method cancels currently running task.
     */
    @Override
    public void stopTasks()
    {
        super.stopTasks();
        this.clearerTask.cancel();
        this.dancingCounter.clear();
    }


    /**
     * The main dancing handler.
     * @param event Player Toggle Sneak Event.
     */
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onDancing(PlayerToggleSneakEvent event)
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

        if (!player.hasPermission(this.addon.getPlugin().getIWM().getPermissionPrefix(world) + "farmersdance"))
        {
            // Player does not have permission to twerk.
            return;
        }

        if (!this.checkIsland(event, player, player.getLocation(), FarmersDanceAddon.FARMER_DANCE, true))
        {
            // Player is not allowed to dance on this island, but do not cancel the event
            event.setCancelled(false);
            return;
        }

        AtomicInteger danceMoves = this.dancingCounter.computeIfAbsent(player,
            uuid -> new AtomicInteger(1));

        if (danceMoves.get() <= this.addon.getSettings().getMaximalDanceMoves())
        {
            danceMoves.incrementAndGet();
        }
    }


    /**
     *  This method clears and reduces dance moves for players who dance.
     */
    private void clearDanceMoves()
    {
        final int minimalDanceMoves = this.addon.getSettings().getMinimalDanceMoves();

        if (this.dancingCounter.isEmpty())
        {
            // Nothing to do.
            return;
        }

        Iterator<Map.Entry<Player, AtomicInteger>> dancingIterator = this.dancingCounter.entrySet().iterator();

        while (dancingIterator.hasNext())
        {
            Map.Entry<Player, AtomicInteger> entry = dancingIterator.next();

            if (entry.getValue().decrementAndGet() <= 0)
            {
                dancingIterator.remove();
            }
            else if (entry.getValue().decrementAndGet() <= minimalDanceMoves)
            {
                BukkitTask danceTask = this.twerkingTasks.remove(entry.getKey().getUniqueId());

                if (danceTask != null)
                {
                    danceTask.cancel();
                }
            }
            else
            {
                if (!this.twerkingTasks.containsKey(entry.getKey().getUniqueId()))
                {
                    BukkitTask bukkitTask = Bukkit.getScheduler().runTaskTimer(
                        this.addon.getPlugin(),
                        () -> this.buildTask(entry.getKey().getWorld(), entry.getKey()),
                        0,
                        1);

                    this.twerkingTasks.put(entry.getKey().getUniqueId(), bukkitTask);
                }
            }
        }
    }



    // ---------------------------------------------------------------------
    // Section: Variables
    // ---------------------------------------------------------------------


    /**
     * This map stores how many dance moves player has performed in few seconds.
     */
    private final Map<Player, AtomicInteger> dancingCounter;

    /**
     * This bukkit task reduces dancing moves for players every X seconds.
     */
    private final BukkitTask clearerTask;
}
