package org.t244.minecraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = IronDaggerMod.modID, name = "IronDaggerMod" ,version = "1.0", dependencies = "required-after:t244_newitemmod")
public class IronDaggerMod {
	public static final String modID = "t244_irondaggermod";

	public static Dagger ironDagger;

	@EventHandler
	public void load(FMLInitializationEvent e) {
		ToolMaterial nuggetIron = EnumHelper.addToolMaterial("nuggetIRON", 2, 250, 6.0F, 1.0F, 18);
		nuggetIron.customCraftingMaterial = NewItemMod.ironNugget;

		ironDagger = new Dagger(nuggetIron);

		GameRegistry.registerItem(ironDagger, "ironDagger");
		GameRegistry.addShapedRecipe(new ItemStack(ironDagger),
				"n",
				"n",
				"L",
				'n', NewItemMod.ironNugget, 'L', Items.leather);
	}


}
