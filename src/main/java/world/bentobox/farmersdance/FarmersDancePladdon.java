//
// Created by BONNe
// Copyright - 2022
//


package world.bentobox.farmersdance;


import world.bentobox.bentobox.api.addons.Addon;
import world.bentobox.bentobox.api.addons.Pladdon;


public class FarmersDancePladdon extends Pladdon
{

    private FarmersDanceAddon addon;

    @Override
    public Addon getAddon()
    {
        if (addon == null) {
            addon = new FarmersDanceAddon();
        }
        return addon;
    }
}
