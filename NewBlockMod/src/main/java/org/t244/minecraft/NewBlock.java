package org.t244.minecraft;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class NewBlock extends Block {

	public static final Block[] allowableDrops = {Blocks.red_flower, Blocks.red_mushroom};
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
		return Item.getItemFromBlock(allowableDrops[r.nextInt(allowableDrops.length)]);
	}
}
