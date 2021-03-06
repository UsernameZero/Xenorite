package com.techiecrow.armor;

import com.techiecrow.crativetab.CreativeTabArmour;
import com.techiecrow.reference.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import com.techiecrow.Xenorite;

public class ShadowBoronArmor extends ItemArmor
{

	private String[] armourTypes = new String[]
	{ "helmetshadowboron", "chestplateshadowboron", "leggingsshadowboron", "bootsshadowboron" };

	public ShadowBoronArmor(ArmorMaterial armorMaterial, int renderIndex, int armorType)
	{
		super(armorMaterial, renderIndex, armorType);
		this.setCreativeTab(CreativeTabArmour.Xenoritearmour);
		this.setMaxStackSize(1);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemstack)
	{
		if (!world.isDaytime() && player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem().equals(Xenorite.heavenlyglintHelmet) && player.getCurrentArmor(2) != null && player.getCurrentArmor(2).getItem().equals(Xenorite.heavenlyglintChestplate) && player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem().equals(Xenorite.heavenlyglintLeggings) && player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem().equals(Xenorite.heavenlyglintBoots))
		{
			player.addPotionEffect(new PotionEffect(1, 0, 0));
		}
	}

	@Override
	public void registerIcons(IIconRegister reg)
	{
		if (this == Xenorite.shadowboronHelmet)
			this.itemIcon = reg.registerIcon("xenorite:helmetShadowBoron");
		if (this == Xenorite.shadowboronChestplate)
			this.itemIcon = reg.registerIcon("xenorite:chestplateShadowBoron");
		if (this == Xenorite.shadowboronLeggings)
			this.itemIcon = reg.registerIcon("xenorite:leggingsShadowBoron");
		if (this == Xenorite.shadowboronBoots)
			this.itemIcon = reg.registerIcon("xenorite:bootsShadowBoron");
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == Xenorite.shadowboronHelmet || stack.getItem() == Xenorite.shadowboronChestplate || stack.getItem() == Xenorite.shadowboronBoots)
		{
			return Reference.MOD_ID + ":textures/models/armor/shadowboron_layer_1.png";
		}
		if (stack.getItem() == Xenorite.shadowboronLeggings)
		{
			return Reference.MOD_ID + ":textures/models/armor/shadowboron_layer_2.png";
		}
		else
		{
			return null;
		}
	}
}