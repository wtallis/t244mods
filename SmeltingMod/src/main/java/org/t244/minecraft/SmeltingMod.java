package org.t244.minecraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

@Mod(modid = SmeltingMod.modid, name = "SmeltingMod", version = "1.1", dependencies="required-after:t244_newitemmod")
public class SmeltingMod {
	public static final String modid = "t244_smeltingmod";

	@EventHandler
	public void load(FMLInitializationEvent e) {
		// recipes to melt things down into iron
		GameRegistry.addSmelting(Items.bucket, new ItemStack(Items.iron_ingot, 3),0);
		GameRegistry.addSmelting(Items.iron_door, new ItemStack(Items.iron_ingot, 6), 0);
		GameRegistry.addSmelting(Items.minecart, new ItemStack(Items.iron_ingot, 5), 0);
		GameRegistry.addSmelting(Blocks.cauldron, new ItemStack(Items.iron_ingot, 7), 0);
		GameRegistry.addSmelting(Blocks.hopper, new ItemStack(Items.iron_ingot, 5), 0);
		GameRegistry.addSmelting(Items.hopper_minecart, new ItemStack(Items.iron_ingot, 10), 0);

		// recipes to melt things down into ironNuggets
		GameRegistry.addSmelting(Blocks.rail, new ItemStack(NewItemMod.ironNugget, 3), 0);
		GameRegistry.addSmelting(Blocks.iron_bars, new ItemStack(NewItemMod.ironNugget, 3), 0);
		GameRegistry.addSmelting(Items.iron_ingot, new ItemStack(NewItemMod.ironNugget, 8), 0);

		//TODO: melt down things that wear down
	}
}
