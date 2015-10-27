package com.taji34.troncraft;

import com.taji34.troncraft.blocks.LiquidEnergy;
import com.taji34.troncraft.handlers.BucketHandler;
import com.taji34.troncraft.items.LiquidEnergyBucket;
import com.taji34.troncraft.proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

/**
 * Created by Nick on 10/13/2015.
 */

@Mod(modid = Troncraft.MODID, name = Troncraft.MODNAME, version = Troncraft.VERSION)
public class Troncraft {

    public static final String MODID = "troncraft";
    public static final String MODNAME = "Troncraft";
    public static final String VERSION = "1.0.0";

    public static final BucketHandler bucketHandler = new BucketHandler();

    public static Fluid liquidEnergyFluid;
    public static Block liquidEnergyBlock;
    public static Item liquidEnergyBucket;

    @Instance(value = Troncraft.MODID)
    public static Troncraft instance;

    @SidedProxy(clientSide = "com.taji34.troncraft.proxies.ClientProxy",
            serverSide = "com.taji34.troncraft.proxies.ServerProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //Create and register liquid energy as a fluid/block
        liquidEnergyFluid = new Fluid("liquidenergy");
        liquidEnergyFluid.setLuminosity(5);
        FluidRegistry.registerFluid(liquidEnergyFluid);
        liquidEnergyBlock = new LiquidEnergy(liquidEnergyFluid, Material.water).setBlockName("liquidEnergy");
        GameRegistry
                .registerBlock(liquidEnergyBlock, MODID + "_" + liquidEnergyBlock.getUnlocalizedName().substring(5));
        liquidEnergyFluid.setUnlocalizedName(liquidEnergyBlock.getUnlocalizedName());

        //create and register the liquid energy bucket
        liquidEnergyBucket = new LiquidEnergyBucket(liquidEnergyBlock);
        FluidContainerRegistry.registerFluidContainer(liquidEnergyFluid, new ItemStack(liquidEnergyBucket),
                new ItemStack(Items.bucket));
        GameRegistry
                .registerItem(liquidEnergyBucket, MODID + "_" + liquidEnergyBucket.getUnlocalizedName().substring(5));

        //register the bucket handler
        bucketHandler.buckets.put(liquidEnergyBlock, liquidEnergyBucket);
        MinecraftForge.EVENT_BUS.register(bucketHandler);
    }

    @EventHandler
    public void load(FMLInitializationEvent event) {

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
