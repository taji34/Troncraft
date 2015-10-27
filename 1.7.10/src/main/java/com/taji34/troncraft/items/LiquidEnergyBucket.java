package com.taji34.troncraft.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;

/**
 * Created by Nick on 10/27/2015.
 */
public class LiquidEnergyBucket extends ItemBucket {

    public LiquidEnergyBucket(Block block) {
        super(block);
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("liquidEnergyBucket");
        setContainerItem(Items.bucket);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister register) {
        itemIcon = register.registerIcon("troncraft:bucket_liquid_energy");
    }
}
