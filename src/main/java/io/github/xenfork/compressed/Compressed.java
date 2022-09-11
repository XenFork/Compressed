package io.github.xenfork.compressed;

import io.github.xenfork.compressed.block.Blocks;
import io.github.xenfork.compressed.item.Items;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Compressed implements ModInitializer {
    public static final String MODID = "cpm";
    public static final Logger logger = LogManager.getLogger("Compressed");

    @Override
    public void onInitialize() {
        logger.info("[CPM] Compressed is starting!");
        logger.info("[CPM] Thanks for playing");
        logger.info("[CPM] From ARMrAmzing, the creator of AmazingRabbit Studio");
        Blocks.register();
        Items.register();
    }
}
