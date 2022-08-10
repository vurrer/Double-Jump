package net.mcreator.doublejump.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.doublejump.network.DoubleJumpModVariables;

public class DoubleJumpProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(DoubleJumpModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new DoubleJumpModVariables.PlayerVariables())).allow_double_jump > 1 && world.isEmptyBlock(new BlockPos(x, y - 0.5, z))) {
			{
				double _setval = (entity.getCapability(DoubleJumpModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new DoubleJumpModVariables.PlayerVariables())).allow_double_jump - 1;
				entity.getCapability(DoubleJumpModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.allow_double_jump = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((entity.getCapability(DoubleJumpModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new DoubleJumpModVariables.PlayerVariables())).double_jump > 0) {
				entity.setDeltaMovement(
						new Vec3((entity.getDeltaMovement().x()), (DoubleJumpModVariables.double_jump_height / 2), (entity.getDeltaMovement().z())));
				{
					double _setval = (entity.getCapability(DoubleJumpModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new DoubleJumpModVariables.PlayerVariables())).double_jump - 1;
					entity.getCapability(DoubleJumpModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.double_jump = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else {
			{
				double _setval = (entity.getCapability(DoubleJumpModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new DoubleJumpModVariables.PlayerVariables())).double_jump + 1;
				entity.getCapability(DoubleJumpModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.allow_double_jump = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
