package org.t244.minecraft;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = FoodMod.modid, name = "FoodMod", version = "1.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=true)
public class FoodMod {
	public static final String modid = "T244_FoodMod";
	
	public static Item beefStew;
	public static int beefStewID;
	
	@PreInit
	public void loadConfig(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		beefStewID = config.getItem("beefStew", 3842).getInt();
		config.save();
	}
	
	@Init
	public void load(FMLInitializationEvent event) {
		beefStew = new BeefStew(beefStewID);
		LanguageRegistry.addName(beefStew, "Beef Stew");
		GameRegistry.registerItem(beefStew, "beefStew");

		GameRegistry.addShapelessRecipe(new ItemStack(beefStew), 
				Item.bowlEmpty, Item.beefCooked, Item.carrot, Item.potato);
	}
}
