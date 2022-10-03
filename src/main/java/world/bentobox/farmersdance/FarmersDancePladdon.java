//
// Created by BONNe
// Copyright - 2022
//


package world.bentobox.farmersdance;


import org.bukkit.plugin.java.annotation.dependency.Dependency;
import org.bukkit.plugin.java.annotation.plugin.ApiVersion;
import org.bukkit.plugin.java.annotation.plugin.Plugin;

import world.bentobox.bentobox.api.addons.Addon;
import world.bentobox.bentobox.api.addons.Pladdon;


/**
 * This is a dummy class that allows to load addon via Bukkit Plugin loader.
 * @author BONNe
 */
@Plugin(name="Pladdon", version="1.0")
@ApiVersion(ApiVersion.Target.v1_17)
@Dependency(value = "BentoBox")
public class FarmersDancePladdon extends Pladdon
{
    @Override
    public Addon getAddon()
    {
        return new FarmersDanceAddon();
    }
}