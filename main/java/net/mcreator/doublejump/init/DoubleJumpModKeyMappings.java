
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.doublejump.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.doublejump.network.DoubleJumpKeybindMessage;
import net.mcreator.doublejump.DoubleJumpMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class DoubleJumpModKeyMappings {
	public static final KeyMapping DOUBLE_JUMP_KEYBIND = new KeyMapping("key.double_jump.double_jump_keybind", GLFW.GLFW_KEY_SPACE,
			"key.categories.gameplay");

	@SubscribeEvent
	public static void registerKeyBindings(FMLClientSetupEvent event) {
		ClientRegistry.registerKeyBinding(DOUBLE_JUMP_KEYBIND);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == DOUBLE_JUMP_KEYBIND.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						DoubleJumpMod.PACKET_HANDLER.sendToServer(new DoubleJumpKeybindMessage(0, 0));
						DoubleJumpKeybindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}
	}
}
