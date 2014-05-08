package org.t244.minecraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;

public class Dagger extends ItemSword {
	public Dagger(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName("ironDagger");
		this.setCreativeTab(CreativeTabs.tabCombat);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister i) {
		this.itemIcon = i.registerIcon("t244_irondaggermod:ironDagger");
	}

	@Override
	public boolean hitEntity(ItemStack daggerStack, EntityLivingBase target, EntityLivingBase user)
	{
		daggerStack.damageItem(1, user);
		//TODO: awareness check for target before applying backstab bonus
		if (user.isSneaking() &&
				target.getLookVec().dotProduct(user.getLookVec()) > Math.acos(Math.toRadians(30.0))) {
				target.attackEntityFrom(DamageSource.generic,30.0F);
		}
		return true;
	}
}
