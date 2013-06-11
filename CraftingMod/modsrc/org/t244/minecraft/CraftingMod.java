package org.t244.minecraft;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = CraftingMod.modid, name = "CraftingMod", version = "1.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=true)
public class CraftingMod {
	public static final String modid = "T244_CraftingMod";

	@Init
	public void load(FMLInitializationEvent e) {

		// add a recipe with a shape
		GameRegistry.addRecipe(new ItemStack(Item.bucketEmpty),
			new Object[]{
				// the first two lines give the shape
				" I ",
				"I I",
				// now we explain what item/block corresponds to what letter above
				'I', Item.ingotIron // we could use an ItemStack to require more than one ingot
			}
		);
	}
}
