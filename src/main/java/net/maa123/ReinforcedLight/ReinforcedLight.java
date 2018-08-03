package net.maa123.ReinforcedLight;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "ReinforcedLight", name = "ReinforcedLight MOD", version = "1.0.0")
public class ReinforcedLight {

    public static Block blockEGlowstone;

    public static Block blockHideButton;

    @EventHandler
    public void perInit(FMLPreInitializationEvent event) {
        blockEGlowstone = new EGlowstone();
        blockHideButton = new HideButton();
        
        GameRegistry.registerBlock(blockEGlowstone, "blockEGlowstone");
        GameRegistry.registerBlock(blockHideButton, "blockHideButton");
    }

}