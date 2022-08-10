package net.mcreator.doublejump.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.doublejump.network.DoubleJumpModVariables;
import net.mcreator.doublejump.init.DoubleJumpModEnchantments;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DoubleJumpAllowProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getDeltaMovement().y() == -0.0784000015258789
				&& EnchantmentHelper.getItemEnchantmentLevel(DoubleJumpModEnchantments.DOUBLE_JUMP_ENCHANT.get(),
						(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)) != 0) {
			{
				double _setval = DoubleJumpModVariables.enchant_level_one_jumps_allowed;
				entity.getCapability(DoubleJumpModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.double_jump = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (EnchantmentHelper.getItemEnchantmentLevel(DoubleJumpModEnchantments.DOUBLE_JUMP_ENCHANT.get(),
					(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)) == 2) {
				{
					double _setval = DoubleJumpModVariables.enchant_level_two_jumps_allowed;
					entity.getCapability(DoubleJumpModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.double_jump = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (EnchantmentHelper.getItemEnchantmentLevel(DoubleJumpModEnchantments.DOUBLE_JUMP_ENCHANT.get(),
					(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)) == 3) {
				{
					double _setval = DoubleJumpModVariables.enchant_level_three_jumps_allowed;
					entity.getCapability(DoubleJumpModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.double_jump = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (!(EnchantmentHelper.getItemEnchantmentLevel(DoubleJumpModEnchantments.DOUBLE_JUMP_ENCHANT.get(),
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)) != 0)
				|| world.isEmptyBlock(new BlockPos(x, y - 0.1, z)) && entity.getDeltaMovement().y() == -0.0784000015258789) {
			{
				double _setval = 0;
				entity.getCapability(DoubleJumpModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.double_jump = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
