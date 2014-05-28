package org.t244.minecraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import java.util.Random;

public class NewBlock extends Block {

	public static final Item[] allowableDrops = {
			Item.getItemFromBlock(Blocks.red_flower),
			Item.getItemFromBlock(Blocks.red_mushroom),
			Items.diamond_sword
	};
	public static final String name = "newBlock";

	public NewBlock(Material material) {
		super(material);
		this.setBlockName(name);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister i) {
		this.blockIcon = i.registerIcon(NewBlockMod.modID+":"+name);
	}

	@Override
	public Item getItemDropped(int metadata, Random r, int fortune) {
		return allowableDrops[r.nextInt(allowableDrops.length)];
		}

	@Override
	public void onBlockDestroyedByPlayer(World w, int x, int y, int z, int metadata) {
		if(new Random().nextFloat()<0.10) {
			EntityTNTPrimed t = new EntityTNTPrimed(w,x,y,z,null);
			w.spawnEntityInWorld(t);
		}
	}
}
