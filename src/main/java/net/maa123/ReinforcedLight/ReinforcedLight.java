package net.maa123.ReinforcedLight;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "ReinforcedLight", name = "ReinforcedLight MOD", version = "1.1.0")
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

	@EventHandler
	public void init(FMLInitializationEvent event){
		GameRegistry.addRecipe(new ItemStack(blockEGlowstone),
			"OIO",
			"GSG",
			"OIO",
			'G',Items.gold_ingot,
			'I',Items.iron_ingot,
			'O',Blocks.obsidian,
			'S',Blocks.glowstone
			);
		GameRegistry.addRecipe(new ItemStack(blockHideButton),
			"BSB",
			"EIE",
			"BSB",
			'B',Blocks.stone_button,
			'I',Items.iron_ingot,
			'E',Items.ender_pearl,
			'S',new ItemStack(Items.dye,1,4)
			);
	}

}