package org.t244.minecraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;

public class BeefStew extends ItemFood {

	public BeefStew() {
		// heal amount, saturation modifier, wolves like
		super(10, 0.6F, false);
		this.setUnlocalizedName("beefStew");
		this.setMaxStackSize(1);
		this.setPotionEffect(Potion.regeneration.id, 10, 0, 0.3F);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister i) {
		this.itemIcon = i.registerIcon("t244_foodmod:beefStew");
	}
	
	@Override
    public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player)
    {
        super.onEaten(itemStack, world, player);
        return new ItemStack(Items.bowl);
    }
	
	@Override
	public int getMaxItemUseDuration(ItemStack i) {
		return 48;
	}
}
