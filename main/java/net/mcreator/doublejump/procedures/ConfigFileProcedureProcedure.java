package net.mcreator.doublejump.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;

import net.mcreator.doublejump.network.DoubleJumpModVariables;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ConfigFileProcedureProcedure {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		execute();
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		File config = new File("");
		com.google.gson.JsonObject jsonOBJ = new com.google.gson.JsonObject();
		config = new File((FMLPaths.GAMEDIR.get().toString() + "/config/double_jump/"), File.separator + "config.json");
		if (!config.exists()) {
			try {
				config.getParentFile().mkdirs();
				config.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			jsonOBJ.addProperty("double_jump_height", 1);
			jsonOBJ.addProperty("enchant_level_one_jumps_allowed", 1);
			jsonOBJ.addProperty("enchant_level_two_jumps_allowed", 2);
			jsonOBJ.addProperty("enchant_level_three_jumps_allowed", 3);
			{
				Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(config);
					fileWriter.write(mainGSONBuilderVariable.toJson(jsonOBJ));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		} else {
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(config));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					jsonOBJ = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					DoubleJumpModVariables.double_jump_height = jsonOBJ.get("double_jump_height").getAsDouble();
					DoubleJumpModVariables.enchant_level_one_jumps_allowed = jsonOBJ.get("enchant_level_one_jumps_allowed").getAsDouble();
					DoubleJumpModVariables.enchant_level_two_jumps_allowed = jsonOBJ.get("enchant_level_two_jumps_allowed").getAsDouble();
					DoubleJumpModVariables.enchant_level_three_jumps_allowed = jsonOBJ.get("enchant_level_three_jumps_allowed").getAsDouble();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
