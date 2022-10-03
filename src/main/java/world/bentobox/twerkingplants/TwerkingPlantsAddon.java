//
// Created by BONNe
// Copyright - 2022
//

package world.bentobox.twerkingplants;


import org.bukkit.Bukkit;

import world.bentobox.bentobox.api.addons.Addon;


/**
 * This is main Addon class. It allows to load it into BentoBox hierarchy.
 */
public class TwerkingPlantsAddon extends Addon
{
    /**
     * Executes code when loading the addon. This is called before {@link #onEnable()}. This <b>must</b> be used to
     * setup configuration, worlds and commands.
     */
    @Override
    public void onLoad()
    {
        super.onLoad();
    }


    /**
     * Executes code when enabling the addon. This is called after {@link #onLoad()}. <br/> Note that commands and
     * worlds registration <b>must</b> be done in {@link #onLoad()}, if need be. Failure to do so <b>will</b> result in
     * issues such as tab-completion not working for commands.
     */
    @Override
    public void onEnable()
    {
        // Check if it is enabled - it might be loaded, but not enabled.

        if (this.getPlugin() == null || !this.getPlugin().isEnabled())
        {
            Bukkit.getLogger().severe("BentoBox is not available or disabled!");
            this.setState(State.DISABLED);
            return;
        }
    }


    @Override
    public void allLoaded()
    {
        super.allLoaded();
    }


    /**
     * Executes code when reloading the addon.
     */
    @Override
    public void onReload()
    {
        super.onReload();
    }


    /**
     * Executes code when disabling the addon.
     */
    @Override
    public void onDisable()
    {
    }
}
