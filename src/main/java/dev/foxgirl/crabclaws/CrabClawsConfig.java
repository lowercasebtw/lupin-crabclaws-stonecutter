package dev.foxgirl.crabclaws;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import dev.architectury.platform.Platform;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class CrabClawsConfig {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Gson GSON = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
    private static final CrabClawsConfig CONFIG = loadConfig();

    public float clawExtraReachAmount = 3.0F;
    public boolean shouldSpawnClawsInRuins = true;
    public int probabilityOfClawsInRuins = 7;

    private static CrabClawsConfig loadConfig() {
        final Path configPath = Platform.getConfigFolder().resolve("crabclaws.json");
        final Path tempPath = Platform.getConfigFolder().resolve("crabclaws.json.tmp");
        try {
            return GSON.fromJson(Files.newBufferedReader(configPath), CrabClawsConfig.class);
        } catch (NoSuchFileException cause) {
            LOGGER.warn("Config file not found, will be created");
        } catch (JsonParseException cause) {
            LOGGER.error("Failed to parse config file", cause);
        } catch (Exception cause) {
            LOGGER.error("Failed to load config file", cause);
        }

        CrabClawsConfig config = new CrabClawsConfig();
        try {
            Files.writeString(tempPath, GSON.toJson(config, CrabClawsConfig.class));
            Files.move(tempPath, configPath, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception cause) {
            LOGGER.error("Failed to save new config file", cause);
        }

        return config;
    }

    public static CrabClawsConfig getConfig() {
        return CONFIG;
    }
}
