//
// Created by BONNe
// Copyright - 2022
//


package world.bentobox.farmersdance.listeners;


import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.Waterlogged;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;
import java.util.*;
import java.util.function.Predicate;

import world.bentobox.bentobox.api.flags.FlagListener;
import world.bentobox.farmersdance.FarmersDanceAddon;


/**
 * This is main class that will process dancing.
 */
public abstract class DancingHandler extends FlagListener
{
    /**
     * Instantiates a new Dancing handler.
     *
     * @param addon the addon
     */
    public DancingHandler(FarmersDanceAddon addon)
    {
        this.addon = addon;
        this.random = new Random(0);
        this.twerkingTasks = new HashMap<>();
    }


    /**
     * This method cancels all running tasks.
     */
    public void stopTasks()
    {
        this.twerkingTasks.values().forEach(BukkitTask::cancel);
        this.twerkingTasks.clear();
    }


    /**
     * This is a method that will bone meal and extend plants.
     * @param world World where dancing happens.
     * @param player The player who triggers dancing.
     */
    protected void buildTask(final World world, final Player player)
    {
        boolean growSaplings = this.addon.getSettings().isGrowSaplings();
        boolean growCrops = this.addon.getSettings().isGrowCrops();
        boolean growPumpkinAndMelon = this.addon.getSettings().isGrowPumpkinAndMelon();
        boolean growCactusAndSugarcane = this.addon.getSettings().isGrowCactusAndSugarcane();
        boolean growMushrooms = this.addon.getSettings().isGrowMushrooms();
        boolean growFungus = this.addon.getSettings().isGrowFungus();
        boolean growNetherVines = this.addon.getSettings().isGrowNetherVines();
        boolean growVines = this.addon.getSettings().isGrowVines();
        boolean growTallFlowers = this.addon.getSettings().isGrowTallFlowers();
        boolean growSeaPickles = this.addon.getSettings().isGrowSeaPickles();
        boolean growKelpAndDripLeaf = this.addon.getSettings().isGrowKelpAndDripLeaf();
        boolean growChorusFlower = this.addon.getSettings().isGrowChorusFlower();
        boolean growBerries = this.addon.getSettings().isGrowBerries();
        boolean growSporeBlossom = this.addon.getSettings().isGrowSporeBlossom();

        final int xRange = this.addon.getSettings().getAffectRadius();
        final int zRange = this.addon.getSettings().getAffectRadius();
        final int yRange = this.addon.getSettings().getAffectHeight();

        int numberOfRandomGens = this.addon.getSettings().getAffectedBlockCount();

        // Get the location of player.
        Location location = player.getLocation();

        for (int i = 0; i < numberOfRandomGens; i++)
        {
            Block block = world.getBlockAt(
                location.getBlockX() + this.random.nextInt(xRange * 2 + 1) - xRange,
                (int) Math.round(location.getY()) + this.random.nextInt(yRange * 2 + 1) - yRange,
                location.getBlockZ() + this.random.nextInt(zRange * 2 + 1) - zRange);

            if (Tag.SAPLINGS.isTagged(block.getType()) ||
                Material.BAMBOO_SAPLING.equals(block.getType()) ||
                Material.BAMBOO.equals(block.getType()))
            {
                if (growSaplings)
                {
                    // Apply bone meal to the sapling.
                    block.applyBoneMeal(BlockFace.UP);
                    this.spawnParticle(block.getLocation());
                }
            }
            else if (Material.PUMPKIN_STEM.equals(block.getType()) || Material.MELON_STEM.equals(block.getType()))
            {
                if (growPumpkinAndMelon)
                {
                    Ageable ageable = (Ageable) block.getBlockData();

                    if (ageable.getAge() < ageable.getMaximumAge())
                    {
                        // Plant is not fully grown. Apply bone meal to it.
                        block.applyBoneMeal(BlockFace.UP);
                        this.spawnParticle(block.getLocation());
                    }
                    else
                    {
                        // Replace AIR blocks with corresponding plant if block bellow air is:
                        // dirt, grass block, farmland, podzol, coarse dirt or moss block

                        List<Block> blockList = new ArrayList<>();
                        blockList.add(block.getRelative(BlockFace.SOUTH));
                        blockList.add(block.getRelative(BlockFace.NORTH));
                        blockList.add(block.getRelative(BlockFace.EAST));
                        blockList.add(block.getRelative(BlockFace.WEST));
                        Collections.shuffle(blockList);

                        Predicate<Block> removal = newSpot ->
                        {
                            if (!Material.AIR.equals(newSpot.getType()))
                            {
                                return true;
                            }
                            else
                            {
                                return switch (newSpot.getRelative(BlockFace.DOWN).getType())
                                    {
                                        case DIRT, GRASS_BLOCK, FARMLAND, PODZOL, COARSE_DIRT, MOSS_BLOCK -> false;
                                        default -> true;
                                    };
                            }
                        };

                        blockList.removeIf(removal);

                        if (!blockList.isEmpty())
                        {
                            Block newPlant = blockList.iterator().next();

                            if (Material.PUMPKIN_STEM.equals(block.getType()))
                            {
                                newPlant.setBlockData(Material.PUMPKIN.createBlockData(), true);
                            }
                            else
                            {
                                newPlant.setBlockData(Material.MELON.createBlockData(), true);
                            }

                            this.spawnParticle(newPlant.getLocation());
                        }
                    }
                }
            }
            else if (Tag.CROPS.isTagged(block.getType()))
            {
                if (growCrops)
                {
                    // Apply bone meal to the crops.
                    block.applyBoneMeal(BlockFace.UP);
                    this.spawnParticle(block.getLocation());
                }
            }
            else if (Tag.TALL_FLOWERS.isTagged(block.getType()))
            {
                if (growTallFlowers)
                {
                    // Apply bone meal to the tall flowers.
                    block.applyBoneMeal(BlockFace.UP);
                    this.spawnParticle(block.getLocation());
                }
            }
            else if (Material.RED_MUSHROOM.equals(block.getType()) || Material.BROWN_MUSHROOM.equals(block.getType()))
            {
                if (growMushrooms)
                {
                    switch (block.getRelative(BlockFace.DOWN).getType())
                    {
                        // On dirt, coarse dirt, grass block, rooted dirt and moss blocks mushrooms can grow only if light
                        // level is smaller than 12.
                        case DIRT, COARSE_DIRT, GRASS_BLOCK, ROOTED_DIRT, MOSS_BLOCK ->
                        {
                            if (block.getLightFromSky() < 12)
                            {
                                block.applyBoneMeal(BlockFace.UP);
                                this.spawnParticle(block.getLocation());
                            }
                        }
                        // On podzol, mycelium and nylium mushrooms can grow at any light level.
                        case PODZOL, MYCELIUM, CRIMSON_NYLIUM, WARPED_NYLIUM ->
                        {
                            block.applyBoneMeal(BlockFace.UP);
                            this.spawnParticle(block.getLocation());
                        }
                    }
                }
            }
            else if (Material.CRIMSON_FUNGUS.equals(block.getType()) || Material.WARPED_FUNGUS.equals(block.getType()))
            {
                if (growFungus)
                {
                    if (Material.CRIMSON_FUNGUS.equals(block.getType()) &&
                        block.getRelative(BlockFace.DOWN).getType().equals(Material.CRIMSON_NYLIUM))
                    {
                        // Crimson fungus can grow only on crimson nylium
                        block.applyBoneMeal(BlockFace.UP);
                        this.spawnParticle(block.getLocation());
                    }
                    else if (Material.WARPED_FUNGUS.equals(block.getType()) &&
                        block.getRelative(BlockFace.DOWN).getType().equals(Material.WARPED_NYLIUM))
                    {
                        // Warped fungus can grow only on warped nylium
                        block.applyBoneMeal(BlockFace.UP);
                        this.spawnParticle(block.getLocation());
                    }
                }
            }
            else if (Material.CACTUS.equals(block.getType()) || Material.SUGAR_CANE.equals(block.getType()))
            {
                if (growCactusAndSugarcane)
                {
                    Block rootBlock = block;

                    while (rootBlock.getRelative(BlockFace.DOWN).getType().equals(block.getType()))
                    {
                        rootBlock = rootBlock.getRelative(BlockFace.DOWN);
                    }

                    int height = 1;

                    // Get max height based on block data.
                    int maxHeight = Material.CACTUS.equals(block.getType()) ?
                        this.addon.getSettings().getMaximalCactusSize() :
                        this.addon.getSettings().getMaximalSugarCaneSize();

                    while (block.getType().equals(rootBlock.getType()) && height < maxHeight)
                    {
                        rootBlock = rootBlock.getRelative(BlockFace.UP);
                        height++;
                    }

                    if (height < maxHeight && Material.AIR.equals(rootBlock.getType()))
                    {
                        rootBlock.setBlockData(block.getType().createBlockData(), true);
                        this.spawnParticle(rootBlock.getLocation());
                    }
                }
            }
            else if (Material.SEA_PICKLE.equals(block.getType()))
            {
                if (growSeaPickles)
                {
                    Material type = block.getRelative(BlockFace.DOWN).getType();

                    if (type.equals(Material.TUBE_CORAL_BLOCK) ||
                        type.equals(Material.BRAIN_CORAL_BLOCK) ||
                        type.equals(Material.FIRE_CORAL_BLOCK) ||
                        type.equals(Material.HORN_CORAL_BLOCK) ||
                        type.equals(Material.BUBBLE_CORAL_BLOCK))
                    {
                        if (block.getBlockData() instanceof Waterlogged waterlogged)
                        {
                            if (waterlogged.isWaterlogged())
                            {
                                // Sea pickles can grow only in water.
                                block.applyBoneMeal(BlockFace.UP);
                                this.spawnParticle(block.getLocation());
                            }
                        }
                    }
                }
            }
            else if (Material.WEEPING_VINES.equals(block.getType()) ||
                Material.TWISTING_VINES.equals(block.getType()) ||
                Material.WEEPING_VINES_PLANT.equals(block.getType()) ||
                Material.TWISTING_VINES_PLANT.equals(block.getType()))
            {
                if (growNetherVines)
                {
                    // Vines can grow in a very huge size with bone meal :)
                    block.applyBoneMeal(BlockFace.UP);
                    this.spawnParticle(block.getLocation());
                }
            }
            else if (Material.VINE.equals(block.getType()) || Material.GLOW_LICHEN.equals(block.getType()))
            {
                if (growVines)
                {
                    if (Material.GLOW_LICHEN.equals(block.getType()))
                    {
                        // Apply bone meal to glow lichen
                        block.applyBoneMeal(BlockFace.UP);
                        this.spawnParticle(block.getLocation());
                    }
                    else
                    {
                        // Manually add 1 more vine.
                        Block lastBlock = block;

                        while (lastBlock.getType().equals(block.getType()))
                        {
                            lastBlock = lastBlock.getRelative(BlockFace.DOWN);
                        }

                        if (Material.AIR.equals(lastBlock.getType()))
                        {
                            lastBlock.setBlockData(block.getBlockData(), true);
                        }
                    }
                }
            }
            else if (Material.CAVE_VINES.equals(block.getType()) ||
                Material.CAVE_VINES_PLANT.equals(block.getType()) ||
                Material.SWEET_BERRY_BUSH.equals(block.getType()))
            {
                if (growBerries)
                {
                    // Apply bone meal to berries
                    block.applyBoneMeal(BlockFace.UP);
                    this.spawnParticle(block.getLocation());
                }
            }
            else if (Material.KELP_PLANT.equals(block.getType()) ||
                Material.KELP.equals(block.getType()) ||
                Material.BIG_DRIPLEAF_STEM.equals(block.getType()) ||
                Material.BIG_DRIPLEAF.equals(block.getType()))
            {
                if (growKelpAndDripLeaf)
                {
                    // Apply bone meal to kelp and drip leaf
                    block.applyBoneMeal(BlockFace.UP);
                    this.spawnParticle(block.getLocation());
                }
            }
            else if (Material.CHORUS_FLOWER.equals(block.getType()))
            {
                if (growChorusFlower)
                {
                    // Spawn large chorus tree as it would be painful to manually grow by block.

                    if (block.getRelative(BlockFace.DOWN).getType().equals(Material.END_STONE))
                    {
                        world.generateTree(block.getLocation(), TreeType.CHORUS_PLANT);
                        this.spawnParticle(block.getLocation());
                    }
                }
            }
            else if (Material.SPORE_BLOSSOM.equals(block.getType()))
            {
                if (growSporeBlossom)
                {
                    // Apply bone meal to spore blossom
                    block.getDrops().forEach(drop -> block.getWorld().dropItemNaturally(block.getLocation().add(0.5, 0.5, 0.5), drop));
                    this.spawnParticle(block.getLocation());
                }
            }
        }
    }


    /**
     * This method spawns particles at the given location. It indicates block growing.
     * @param location Location for particles.
     */
    private void spawnParticle(@NotNull Location location)
    {
        Objects.requireNonNull(location.getWorld()).spawnParticle(Particle.VILLAGER_HAPPY,
            location.add(0.5, 0.5, 0.5),
            20,
            0.3D,
            0.3D,
            0.3D);
    }


// ---------------------------------------------------------------------
// Section: Variables
// ---------------------------------------------------------------------


    /**
     * The main addon instance.
     */
    protected final FarmersDanceAddon addon;

    /**
     * Random number generator.
     */
    private final Random random;

    /**
     * Map that links UUID to a Bukkit task that is running.
     */
    protected final Map<UUID, BukkitTask> twerkingTasks;
}
