package org.t244.minecraft;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = FoodMod.modid, name = "FoodMod", version = "1.0")
public class FoodMod {
	public static final String modid = "t244_foodmod";

	public static Item beefStew;
	public static int beefStewID;

	@EventHandler
	public void load(FMLInitializationEvent event) {
		beefStew = new BeefStew();
		GameRegistry.registerItem(beefStew, "beefStew");

		GameRegistry.addShapelessRecipe(new ItemStack(beefStew),
				Items.bowl, Items.cooked_beef, Items.carrot, Items.potato);
	}
}
