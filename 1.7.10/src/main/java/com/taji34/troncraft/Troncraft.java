package com.taji34.troncraft;

import com.taji34.troncraft.blocks.LiquidEnerginium;
import com.taji34.troncraft.proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

/**
 * Created by Nick on 10/13/2015.
 */

@Mod(modid = Troncraft.MODID, name = Troncraft.MODNAME, version = Troncraft.VERSION)
public class Troncraft {

    public static final String MODID = "troncraft";
    public static final String MODNAME = "Troncraft";
    public static final String VERSION = "1.0.0";

    public static Fluid liquidEnerginiumFluid;
    public static LiquidEnerginium liquidEnerginiumBlock;

    @Instance(value = Troncraft.MODID)
    public static Troncraft instance;

    @SidedProxy(clientSide = "com.taji34.troncraft.proxies.ClientProxy",
            serverSide = "com.taji34.troncraft.proxies.ServerProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        liquidEnerginiumFluid = new Fluid("liquidenerginium");
        liquidEnerginiumFluid.setLuminosity(5);
        FluidRegistry.registerFluid(liquidEnerginiumFluid);
        liquidEnerginiumBlock = (LiquidEnerginium) new LiquidEnerginium(liquidEnerginiumFluid, Material.water)
                .setBlockName("liquidEnerginium");
        GameRegistry.registerBlock(liquidEnerginiumBlock, MODID + "_" + liquidEnerginiumBlock.getUnlocalizedName().substring(5));
        liquidEnerginiumFluid.setUnlocalizedName(liquidEnerginiumBlock.getUnlocalizedName());
    }

    @EventHandler
    public void load(FMLInitializationEvent event) {

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
