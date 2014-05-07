package org.t244.minecraft;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = CraftingMod.modid, name = "CraftingMod", version = "1.0")
public class CraftingMod {
	public static final String modid = "T244_CraftingMod";

	@EventHandler
	public void load(FMLInitializationEvent e) {

		// add a recipe with a shape
		GameRegistry.addRecipe(new ItemStack(Items.bucket),
			new Object[]{
				// the first two lines give the shape
				" I ",
				"I I",
				// now we explain what item/block corresponds to what letter above
				'I', Items.iron_ingot // we could use an ItemStack to require more than one ingot
			}
		);
        GameRegistry.addRecipe(new ItemStack(Items.diamond_horse_armor),
                "  L",
                "DLD",
                "DSD",
                'L',Items.leather,'D',Items.diamond,'S',Items.string
        );
	}
}
