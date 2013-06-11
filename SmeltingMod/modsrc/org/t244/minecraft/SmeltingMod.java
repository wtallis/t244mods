/**
 * 
 */
package org.t244.minecraft;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

/**
 * @author wtallis
 *
 */
@Mod(modid = SmeltingMod.modid, name = "SmeltingMod", version = "1.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=true)
public class SmeltingMod {
	public static final String modid = "T244_SmeltingMod";

	@Init
	public void load(FMLInitializationEvent e) {
		FurnaceRecipes r = FurnaceRecipes.smelting();
		r.addSmelting(Item.bucketEmpty.itemID, 0, new ItemStack(Item.ingotIron, 3), 0);
		r.addSmelting(Item.doorIron.itemID, 0, new ItemStack(Item.ingotIron, 6), 0);
		r.addSmelting(Item.minecartEmpty.itemID, 0, new ItemStack(Item.ingotIron, 5), 0);
		r.addSmelting(Block.pressurePlateIron.blockID, 0, new ItemStack(Item.ingotIron, 2), 0);
		r.addSmelting(Block.cauldron.blockID, 0, new ItemStack(Item.ingotIron, 7), 0);
		r.addSmelting(Block.hopperBlock.blockID, 0, new ItemStack(Item.ingotIron, 5), 0);
		r.addSmelting(Item.minecartHopper.itemID, 0, new ItemStack(Item.ingotIron, 10), 0);
	}
}
