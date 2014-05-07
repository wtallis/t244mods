package org.t244.minecraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class IronNugget extends Item {

	public IronNugget() {
        super();
		this.setUnlocalizedName("ironNugget");
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister i) {
		this.itemIcon = i.registerIcon("t244_newitemmod:ironNugget");
	}

}
