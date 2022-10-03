//
// Created by BONNe
// Copyright - 2022
//

package world.bentobox.farmersdance;


import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import world.bentobox.bentobox.api.addons.Addon;
import world.bentobox.bentobox.api.configuration.Config;
import world.bentobox.farmersdance.configs.Settings;
import world.bentobox.farmersdance.listeners.DancingHandler;
import world.bentobox.farmersdance.listeners.FastDancingListener;
import world.bentobox.farmersdance.listeners.LazyDancingListener;


/**
 * This is main Addon class. It allows to load it into BentoBox hierarchy.
 */
public class FarmersDanceAddon extends Addon
{
    /**
     * Executes code when loading the addon. This is called before {@link #onEnable()}. This <b>must</b> be used to
     * setup configuration, worlds and commands.
     */
    @Override
    public void onLoad()
    {
        super.onLoad();

        // Storing default configuration is simple. But be aware, you need
        // @StoreAt(filename="config.yml", path="addons/Visits") in header of your Config file.
        this.saveDefaultConfig();

        this.settings = new Config<>(this, Settings.class).loadConfigObject();

        if (this.settings == null)
        {
            // If we failed to load Settings then we should not enable addon.
            // We can log error and set state to DISABLED.

            this.logError("Farmers Dance settings could not load! Addon disabled.");
            this.setState(State.DISABLED);
        }
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

        // Choose which dancing mode is enabled.
        if (this.settings.isLazyDancing())
        {
            this.dancingHandler = new LazyDancingListener(this);
            this.registerListener((Listener) this.dancingHandler);
        }
        else
        {
            this.dancingHandler = new FastDancingListener(this);
            this.registerListener((Listener) this.dancingHandler);
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


        // onReload most of addons just need to reload configuration.
        // If flags, listeners and handlers were set up correctly via Addon.class then
        // they will be reloaded automatically.

        this.settings = new Config<>(this, Settings.class).loadConfigObject();

        // TODO: check and readd disabled addon list in addon manager.

        if (this.settings == null)
        {
            // If we failed to load Settings then we should not enable addon.
            // We can log error and set state to DISABLED.

            this.logError("Farmers Dance settings could not load! Addon disabled.");
            this.setState(State.DISABLED);
        }
    }


    /**
     * Executes code when disabling the addon.
     */
    @Override
    public void onDisable()
    {
        // Stop all running tasks.
        this.dancingHandler.stopTasks();
    }


    /**
     * This method saves settings file from memory.
     */
    public void saveSettings()
    {
        if (this.settings != null)
        {
            new Config<>(this, Settings.class).saveConfigObject(this.settings);
        }
    }


    /**
     * This method returns the settings value.
     *
     * @return the value of settings.
     */
    public Settings getSettings()
    {
        return this.settings;
    }


// ---------------------------------------------------------------------
// Section: Variables
// ---------------------------------------------------------------------

    /**
     * Settings object contains
     */
    private Settings settings;

    /**
     * This stores currently active dancing handler.
     */
    private DancingHandler dancingHandler;
}
