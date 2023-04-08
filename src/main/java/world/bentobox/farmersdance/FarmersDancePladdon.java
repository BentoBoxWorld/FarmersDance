//
// Created by BONNe
// Copyright - 2022
//


package world.bentobox.farmersdance;


import world.bentobox.bentobox.api.addons.Addon;
import world.bentobox.bentobox.api.addons.Pladdon;


public class FarmersDancePladdon extends Pladdon
{
    @Override
    public Addon getAddon()
    {
        return new FarmersDanceAddon();
    }
}
