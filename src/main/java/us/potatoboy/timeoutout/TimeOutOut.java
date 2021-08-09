package us.potatoboy.timeoutout;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;

public class TimeOutOut implements ModInitializer {
    private static TimeOutOutConfig config;

    @Override
    public void onInitialize() {
        config = TimeOutOutConfig.loadConfig(new File(FabricLoader.getInstance().getConfigDir() + "/timeoutout.json"));
    }

    public static TimeOutOutConfig getConfig() {
        return config;
    }
}
