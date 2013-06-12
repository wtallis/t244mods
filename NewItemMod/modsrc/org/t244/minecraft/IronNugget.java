package org.t244.minecraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class IronNugget extends Item {

	public IronNugget(int id) {
		super(id);
		this.setUnlocalizedName("ironNugget");
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister i) {
		this.itemIcon = i.registerIcon("T244_NewItemMod:ironNugget");
	}

}
