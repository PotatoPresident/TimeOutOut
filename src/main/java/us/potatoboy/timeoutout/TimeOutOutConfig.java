package us.potatoboy.timeoutout;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class TimeOutOutConfig {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public int readTimeoutSeconds = 120;
    public long loginTimeoutTicks = 2400;
    public long keepAlivePacketIntervalSeconds = 15;
    public long keepAliveTimeoutSeconds = 120;

    public static TimeOutOutConfig loadConfig(File file) {
        TimeOutOutConfig config;

        if (file.exists() && file.isFile()) {
            try (
                    FileInputStream fileInputStream = new FileInputStream(file);
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            ) {
                config = GSON.fromJson(bufferedReader, TimeOutOutConfig.class);
            } catch (IOException e) {
                throw new RuntimeException("Failed to load config", e);
            }
        } else {
            config = new TimeOutOutConfig();
        }

        config.saveConfig(file);

        return config;
    }

    public void saveConfig(File config) {
        try (
                FileOutputStream stream = new FileOutputStream(config);
                Writer writer = new OutputStreamWriter(stream, StandardCharsets.UTF_8);
        ) {
            GSON.toJson(this, writer);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config", e);
        }
    }
}
