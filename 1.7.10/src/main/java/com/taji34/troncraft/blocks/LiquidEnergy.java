package com.taji34.troncraft.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

/**
 * Created by Nick on 10/13/2015.
 */
public class LiquidEnergy extends BlockFluidClassic {

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public LiquidEnergy(Fluid fluid, Material material) {
        super(fluid, material);
    }

    @Override
    public IIcon getIcon(int side, int metadata) {
        return (side == 0 || side == 1) ? icons[0] : icons[1];
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
        icons = new IIcon[2];
        icons[0] = register.registerIcon("troncraft:liquidEnergyStill");
        icons[1] = register.registerIcon("troncraft:liquidEnergyFlowing");
    }

    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
        if (world.getBlock(x, y, z).getMaterial().isLiquid()) {
            return false;
        }
        return super.canDisplace(world, x, y, z);
    }

    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
        if (world.getBlock(x, y, z).getMaterial().isLiquid()) {
            return false;
        }
        return super.displaceIfPossible(world, x, y, z);
    }
}
