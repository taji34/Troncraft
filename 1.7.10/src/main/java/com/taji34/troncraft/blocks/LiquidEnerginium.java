package com.taji34.troncraft.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

/**
 * Created by Nick on 10/13/2015.
 */
public class LiquidEnerginium extends BlockFluidClassic {

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public LiquidEnerginium(Fluid fluid, Material material) {
        super(fluid, material);
        setCreativeTab(CreativeTabs.tabMisc);
    }

    @Override
    public IIcon getIcon(int side, int metadata) {
        return (side == 0 || side == 1) ? icons[0] : icons[1];
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
        icons = new IIcon[2];
        icons[0] = register.registerIcon("troncraft:energiniumStill");
        icons[1] = register.registerIcon("troncraft:energiniumFlowing");
    }

}
