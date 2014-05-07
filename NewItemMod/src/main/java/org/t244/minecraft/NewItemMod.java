package org.t244.minecraft;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "t244_newitemmod", name = "NewItemMod", version = "1.0")
public class NewItemMod {

	public static IronNugget ironNugget;

	@EventHandler
	public void load(FMLInitializationEvent event) {
		ironNugget = new IronNugget();
		GameRegistry.registerItem(ironNugget, "ironNugget");

		// register recipe to craft 8 ironNugget into 1 ironIngot
		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot),
				ironNugget, ironNugget, ironNugget, ironNugget,	
				ironNugget, ironNugget, ironNugget, ironNugget);
		GameRegistry.addShapelessRecipe(new ItemStack(ironNugget,8),Items.iron_ingot);
	}

}
