package com.taji34.troncraft;

import com.taji34.troncraft.proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Nick on 10/13/2015.
 */

@Mod(modid = Troncraft.MODID, name = Troncraft.MODNAME, version = Troncraft.VERSION)
public class Troncraft {

    public static final String MODID = "troncraft";
    public static final String MODNAME = "Troncraft";
    public static final String VERSION = "1.0.0";

    @Instance(value = Troncraft.MODID)
    public static Troncraft instance;

    @SidedProxy(clientSide = "com.taji34.troncraft.proxies.ClientProxy",
            serverSide = "com.taji34.troncraft.proxies.ServerProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

    }

    @EventHandler
    public void load(FMLInitializationEvent event) {

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
