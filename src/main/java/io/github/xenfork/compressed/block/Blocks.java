package io.github.xenfork.compressed.block;

import io.github.xenfork.compressed.Compressed;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class Blocks {
    public static final Block COMPRESSED_BLOCK = register(
            "compressed_block",
            new CompressedBlock(FabricBlockSettings.of(Material.STONE).strength(3).resistance(1.2F).requiresTool())
    );

    private static <T extends Block, R extends T> R register(String name, R block) {
        return Registry.register(Registry.BLOCK, new Identifier(Compressed.MODID, name), block);
    }

    public static void register() {
    }
}
