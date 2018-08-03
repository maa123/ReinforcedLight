package net.maa123.ReinforcedLight;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class EGlowstone extends Block {
    public EGlowstone() {
        super(Material.rock);
        setBlockName("blockEGlowstone");
        setBlockTextureName("glowstone");
        setCreativeTab(CreativeTabs.tabBlock);
        setHardness(7.0F);
        setHarvestLevel("pickaxe", 2);
        setResistance(Float.POSITIVE_INFINITY);
        setStepSound(Block.soundTypeStone);
        setLightLevel(1.0F);
    }
}