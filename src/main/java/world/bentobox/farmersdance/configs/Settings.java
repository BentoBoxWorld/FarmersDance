//
// Created by BONNe
// Copyright - 2022
//


package world.bentobox.farmersdance.configs;


import world.bentobox.bentobox.api.configuration.ConfigComment;
import world.bentobox.bentobox.api.configuration.ConfigEntry;
import world.bentobox.bentobox.api.configuration.ConfigObject;
import world.bentobox.bentobox.api.configuration.StoreAt;


/**
 * Settings that implements ConfigObject is powerful and dynamic Config Objects that does not need custom parsing. If it
 * is correctly loaded, all its values will be available.
 * <p>
 * Without Getter and Setter this class will not work.
 * <p>
 * To specify location for config object to be stored, you should use @StoreAt(filename="{config file name}",
 * path="{Path to your addon}") To save comments in config file you should use @ConfigComment("{message}") that adds any
 * message you want to be in file.
 */
@StoreAt(filename = "config.yml", path = "addons/FarmersDance")
@ConfigComment("FarmersDance Configuration [version]")
@ConfigComment("This config file is dynamic and saved when the server is shutdown.")
@ConfigComment("")
public class Settings implements ConfigObject
{
    /**
     * Default constructor init.
     */
    public Settings()
    {
    }


// ---------------------------------------------------------------------
// Section: Methods
// ---------------------------------------------------------------------


    /**
     * Is lazy dancing boolean.
     *
     * @return the boolean
     */
    public boolean isLazyDancing()
    {
        return lazyDancing;
    }


    /**
     * Sets lazy dancing.
     *
     * @param lazyDancing the lazy dancing
     */
    public void setLazyDancing(boolean lazyDancing)
    {
        this.lazyDancing = lazyDancing;
    }


    /**
     * Gets minimal dance moves.
     *
     * @return the minimal dance moves
     */
    public int getMinimalDanceMoves()
    {
        return minimalDanceMoves;
    }


    /**
     * Sets minimal dance moves.
     *
     * @param minimalDanceMoves the minimal dance moves
     */
    public void setMinimalDanceMoves(int minimalDanceMoves)
    {
        this.minimalDanceMoves = minimalDanceMoves;
    }


    /**
     * Gets maximal dance moves.
     *
     * @return the maximal dance moves
     */
    public int getMaximalDanceMoves()
    {
        return maximalDanceMoves;
    }


    /**
     * Sets maximal dance moves.
     *
     * @param maximalDanceMoves the maximal dance moves
     */
    public void setMaximalDanceMoves(int maximalDanceMoves)
    {
        this.maximalDanceMoves = maximalDanceMoves;
    }


    /**
     * Gets affect radius.
     *
     * @return the affect radius
     */
    public int getAffectRadius()
    {
        return affectRadius;
    }


    /**
     * Sets affect radius.
     *
     * @param affectRadius the affect radius
     */
    public void setAffectRadius(int affectRadius)
    {
        this.affectRadius = affectRadius;
    }


    /**
     * Gets affect height.
     *
     * @return the affect height
     */
    public int getAffectHeight()
    {
        return affectHeight;
    }


    /**
     * Sets affect height.
     *
     * @param affectHeight the affect height
     */
    public void setAffectHeight(int affectHeight)
    {
        this.affectHeight = affectHeight;
    }


    /**
     * Gets affected block count.
     *
     * @return the affected block count
     */
    public int getAffectedBlockCount()
    {
        return affectedBlockCount;
    }


    /**
     * Sets affected block count.
     *
     * @param affectedBlockCount the affected block count
     */
    public void setAffectedBlockCount(int affectedBlockCount)
    {
        this.affectedBlockCount = affectedBlockCount;
    }


    /**
     * Is grow saplings boolean.
     *
     * @return the boolean
     */
    public boolean isGrowSaplings()
    {
        return growSaplings;
    }


    /**
     * Sets grow saplings.
     *
     * @param growSaplings the grow saplings
     */
    public void setGrowSaplings(boolean growSaplings)
    {
        this.growSaplings = growSaplings;
    }


    /**
     * Is grow crops boolean.
     *
     * @return the boolean
     */
    public boolean isGrowCrops()
    {
        return growCrops;
    }


    /**
     * Sets grow crops.
     *
     * @param growCrops the grow crops
     */
    public void setGrowCrops(boolean growCrops)
    {
        this.growCrops = growCrops;
    }


    /**
     * Is grow pumpkin and melon boolean.
     *
     * @return the boolean
     */
    public boolean isGrowPumpkinAndMelon()
    {
        return growPumpkinAndMelon;
    }


    /**
     * Sets grow pumpkin and melon.
     *
     * @param growPumpkinAndMelon the grow pumpkin and melon
     */
    public void setGrowPumpkinAndMelon(boolean growPumpkinAndMelon)
    {
        this.growPumpkinAndMelon = growPumpkinAndMelon;
    }


    /**
     * Is grow cactus and sugarcane boolean.
     *
     * @return the boolean
     */
    public boolean isGrowCactusAndSugarcane()
    {
        return growCactusAndSugarcane;
    }


    /**
     * Sets grow cactus and sugarcane.
     *
     * @param growCactusAndSugarcane the grow cactus and sugarcane
     */
    public void setGrowCactusAndSugarcane(boolean growCactusAndSugarcane)
    {
        this.growCactusAndSugarcane = growCactusAndSugarcane;
    }


    /**
     * Is grow mushrooms boolean.
     *
     * @return the boolean
     */
    public boolean isGrowMushrooms()
    {
        return growMushrooms;
    }


    /**
     * Sets grow mushrooms.
     *
     * @param growMushrooms the grow mushrooms
     */
    public void setGrowMushrooms(boolean growMushrooms)
    {
        this.growMushrooms = growMushrooms;
    }


    /**
     * Is grow fungus boolean.
     *
     * @return the boolean
     */
    public boolean isGrowFungus()
    {
        return growFungus;
    }


    /**
     * Sets grow fungus.
     *
     * @param growFungus the grow fungus
     */
    public void setGrowFungus(boolean growFungus)
    {
        this.growFungus = growFungus;
    }


    /**
     * Is grow nether vines boolean.
     *
     * @return the boolean
     */
    public boolean isGrowNetherVines()
    {
        return growNetherVines;
    }


    /**
     * Sets grow nether vines.
     *
     * @param growNetherVines the grow nether vines
     */
    public void setGrowNetherVines(boolean growNetherVines)
    {
        this.growNetherVines = growNetherVines;
    }


    /**
     * Is grow vines boolean.
     *
     * @return the boolean
     */
    public boolean isGrowVines()
    {
        return growVines;
    }


    /**
     * Sets grow vines.
     *
     * @param growVines the grow vines
     */
    public void setGrowVines(boolean growVines)
    {
        this.growVines = growVines;
    }


    /**
     * Is grow tall flowers boolean.
     *
     * @return the boolean
     */
    public boolean isGrowTallFlowers()
    {
        return growTallFlowers;
    }


    /**
     * Sets grow tall flowers.
     *
     * @param growTallFlowers the grow tall flowers
     */
    public void setGrowTallFlowers(boolean growTallFlowers)
    {
        this.growTallFlowers = growTallFlowers;
    }


    /**
     * Is grow sea pickles boolean.
     *
     * @return the boolean
     */
    public boolean isGrowSeaPickles()
    {
        return growSeaPickles;
    }


    /**
     * Sets grow sea pickles.
     *
     * @param growSeaPickles the grow sea pickles
     */
    public void setGrowSeaPickles(boolean growSeaPickles)
    {
        this.growSeaPickles = growSeaPickles;
    }


    /**
     * Is grow kelp and drip leaf boolean.
     *
     * @return the boolean
     */
    public boolean isGrowKelpAndDripLeaf()
    {
        return growKelpAndDripLeaf;
    }


    /**
     * Sets grow kelp and drip leaf.
     *
     * @param growKelpAndDripLeaf the grow kelp and drip leaf
     */
    public void setGrowKelpAndDripLeaf(boolean growKelpAndDripLeaf)
    {
        this.growKelpAndDripLeaf = growKelpAndDripLeaf;
    }


    /**
     * Is grow chorus flower boolean.
     *
     * @return the boolean
     */
    public boolean isGrowChorusFlower()
    {
        return growChorusFlower;
    }


    /**
     * Sets grow chorus flower.
     *
     * @param growChorusFlower the grow chorus flower
     */
    public void setGrowChorusFlower(boolean growChorusFlower)
    {
        this.growChorusFlower = growChorusFlower;
    }


    /**
     * Is grow berries boolean.
     *
     * @return the boolean
     */
    public boolean isGrowBerries()
    {
        return growBerries;
    }


    /**
     * Sets grow berries.
     *
     * @param growBerries the grow berries
     */
    public void setGrowBerries(boolean growBerries)
    {
        this.growBerries = growBerries;
    }


    /**
     * Is grow spore blossom boolean.
     *
     * @return the boolean
     */
    public boolean isGrowSporeBlossom()
    {
        return this.growSporeBlossom;
    }


    /**
     * Sets grow spore blossom.
     *
     * @param growSporeBlossom the grow spore blossom
     */
    public void setGrowSporeBlossom(boolean growSporeBlossom)
    {
        this.growSporeBlossom = growSporeBlossom;
    }


    /**
     * Gets maximal cactus size.
     *
     * @return the maximal cactus size
     */
    public int getMaximalCactusSize()
    {
        return this.maximalCactusSize;
    }


    /**
     * Sets maximal cactus size.
     *
     * @param maximalCactusSize the maximal cactus size
     */
    public void setMaximalCactusSize(int maximalCactusSize)
    {
        this.maximalCactusSize = maximalCactusSize;
    }


    /**
     * Gets maximal sugar cane size.
     *
     * @return the maximal sugar cane size
     */
    public int getMaximalSugarCaneSize()
    {
        return this.maximalSugarCaneSize;
    }


    /**
     * Sets maximal sugar cane size.
     *
     * @param maximalSugarCaneSize the maximal sugar cane size
     */
    public void setMaximalSugarCaneSize(int maximalSugarCaneSize)
    {
        this.maximalSugarCaneSize = maximalSugarCaneSize;
    }


// ---------------------------------------------------------------------
// Section: Variables
// ---------------------------------------------------------------------


    @ConfigComment("")
    @ConfigComment("Allows to toggle between lazy dancing and active dancing.")
    @ConfigComment("Lazy dancing means that players just need to hold shift, while active dancing")
    @ConfigComment("requires repeating shift pressing.")
    @ConfigComment("Default value = false.")
    @ConfigEntry(path = "dance.lazy-dancing", needsRestart = true)
    private boolean lazyDancing = false;

    @ConfigComment("")
    @ConfigComment("Allows to set how many dance moves player must perform until plants starts to")
    @ConfigComment("grow. This does not affect lazy dancing.")
    @ConfigComment("Default value = 3.")
    @ConfigEntry(path = "dance.minimal-dance-moves")
    private int minimalDanceMoves = 3;

    @ConfigComment("")
    @ConfigComment("Allows to set how many dance moves player can perform until they are capped.")
    @ConfigComment("Every 1 second player looses 1 dance move. So fast hands can accumulate a lot")
    @ConfigComment("of dance moves and then be still until stored dance moves are cleared.")
    @ConfigComment("This does not affect lazy dancing.")
    @ConfigComment("Default value = 8.")
    @ConfigEntry(path = "dance.maximal-dance-moves")
    private int maximalDanceMoves = 8;

    @ConfigComment("")
    @ConfigComment("Allows to set the square radius of blocks from player location where plants will")
    @ConfigComment("be affected. This is just in X and Z coordinate.")
    @ConfigComment("Default value = 3.")
    @ConfigEntry(path = "area.affected-radius")
    private int affectRadius = 3;

    @ConfigComment("")
    @ConfigComment("Allows to set the height of affected area in blocks.")
    @ConfigComment("0 means that effect will be only at player level. 1 means that effect will be")
    @ConfigComment("1 block above and bellow")
    @ConfigComment("Default value = 0.")
    @ConfigEntry(path = "area.affected-height")
    private int affectHeight = 0;

    @ConfigComment("")
    @ConfigComment("Allows to set how many blocks in affected area will be triggered in every game")
    @ConfigComment("tick. If multiple are allowed, then there is a chance that it can be the same")
    @ConfigComment("block. This is per player.")
    @ConfigComment("Default value = 1.")
    @ConfigEntry(path = "area.affected-block-count")
    private int affectedBlockCount = 1;

    @ConfigComment("")
    @ConfigComment("Toggles if dancing will affect saplings. This includes:")
    @ConfigComment(" oak_sapling, spruce_sapling, birch_sapling, jungle_sapling, acacia_sapling, ")
    @ConfigComment(" dark_oak_sapling, mangrove_propagule, azalea, flowering_azalea, bamboo. ")
    @ConfigComment("Default value = true.")
    @ConfigEntry(path = "groups.grow-saplings")
    private boolean growSaplings = true;

    @ConfigComment("")
    @ConfigComment("Toggles if dancing will affect crops. This includes:")
    @ConfigComment(" wheat, carrots, potatoes, beetroots. ")
    @ConfigComment("Default value = true.")
    @ConfigEntry(path = "groups.grow-crops")
    private boolean growCrops = true;

    @ConfigComment("")
    @ConfigComment("Toggles if dancing will affect pumpkins and melons.")
    @ConfigComment("Dancing near sapling will force-grow pumpkin/melon near stem.")
    @ConfigComment("Default value = true.")
    @ConfigEntry(path = "groups.grow-pumpkin-melon")
    private boolean growPumpkinAndMelon = true;

    @ConfigComment("")
    @ConfigComment("Toggles if dancing will affect cactus and sugarcane.")
    @ConfigComment("Dancing near cactus/sugarcane will grow it by 1 level. Max level is still 3.")
    @ConfigComment("Default value = true.")
    @ConfigEntry(path = "groups.grow-cactus-sugarcane")
    private boolean growCactusAndSugarcane = true;

    @ConfigComment("")
    @ConfigComment("Toggles if dancing will affect mushrooms.")
    @ConfigComment("Dancing near brown and red mushroom will allow it to grow.")
    @ConfigComment("Huge mushroom requirements still must be met.")
    @ConfigComment("Default value = true.")
    @ConfigEntry(path = "groups.grow-mushrooms")
    private boolean growMushrooms = true;

    @ConfigComment("")
    @ConfigComment("Toggles if dancing will affect fungus.")
    @ConfigComment("Dancing near warped and crimson fungus will allow it to grow.")
    @ConfigComment("Large fungus requirements still must be met.")
    @ConfigComment("Default value = true.")
    @ConfigEntry(path = "groups.grow-fungus")
    private boolean growFungus = true;

    @ConfigComment("")
    @ConfigComment("Toggles if dancing will affect warped and twisted wines.")
    @ConfigComment("Default value = true.")
    @ConfigEntry(path = "groups.grow-nether-vines")
    private boolean growNetherVines = true;

    @ConfigComment("")
    @ConfigComment("Toggles if dancing will affect vines and glow lichen.")
    @ConfigComment("Default value = true.")
    @ConfigEntry(path = "groups.grow-vines")
    private boolean growVines = true;

    @ConfigComment("")
    @ConfigComment("Toggles if dancing will affect tall flowers.")
    @ConfigComment("It means that tall flowers will drop their item, like using bone meal.")
    @ConfigComment("Default value = true.")
    @ConfigEntry(path = "groups.grow-tall-flowers")
    private boolean growTallFlowers = true;

    @ConfigComment("")
    @ConfigComment("Toggles if dancing will affect sea pickles.")
    @ConfigComment("Sea pickles requirements still must be met.")
    @ConfigComment("Default value = true.")
    @ConfigEntry(path = "groups.grow-sea-pickles")
    private boolean growSeaPickles = true;

    @ConfigComment("")
    @ConfigComment("Toggles if dancing will affect kelp and large drip leaf.")
    @ConfigComment("Default value = true.")
    @ConfigEntry(path = "groups.grow-kelp-drip-leaf")
    private boolean growKelpAndDripLeaf = true;

    @ConfigComment("")
    @ConfigComment("Toggles if dancing will affect chorus flower.")
    @ConfigComment("Dancing near chorus flower will force it to grow in full chorus tree.")
    @ConfigComment("Default value = true.")
    @ConfigEntry(path = "groups.grow-chorus-flower")
    private boolean growChorusFlower = true;

    @ConfigComment("")
    @ConfigComment("Toggles if dancing will affect sweet berries and glow berries.")
    @ConfigComment("Dancing near berries will produce berries.")
    @ConfigComment("Default value = true.")
    @ConfigEntry(path = "groups.grow-berries")
    private boolean growBerries = true;

    @ConfigComment("")
    @ConfigComment("Toggles if dancing will affect spore blossoms.")
    @ConfigComment("Dancing near spore blossoms will drop new spore blossom.")
    @ConfigComment("Default value = false.")
    @ConfigEntry(path = "groups.spore-blossoms")
    private boolean growSporeBlossom = true;

    @ConfigComment("")
    @ConfigComment("The maximal cactus size that it can grow to.")
    @ConfigComment("Default value = 3.")
    @ConfigEntry(path = "size.cactus-size")
    private int maximalCactusSize = 3;

    @ConfigComment("")
    @ConfigComment("The maximal sugar cane size that it can grow to.")
    @ConfigComment("Default value = 3.")
    @ConfigEntry(path = "size.sugar-cane-size")
    private int maximalSugarCaneSize;
}
