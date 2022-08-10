
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.doublejump.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import net.mcreator.doublejump.enchantment.DoubleJumpEnchantEnchantment;
import net.mcreator.doublejump.DoubleJumpMod;

public class DoubleJumpModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, DoubleJumpMod.MODID);
	public static final RegistryObject<Enchantment> DOUBLE_JUMP_ENCHANT = REGISTRY.register("double_jump_enchant",
			() -> new DoubleJumpEnchantEnchantment());
}
