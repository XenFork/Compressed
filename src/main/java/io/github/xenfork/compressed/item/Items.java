package io.github.xenfork.compressed.item;

import io.github.xenfork.compressed.Compressed;
import io.github.xenfork.compressed.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class Items {
    public static final Item COMPRESSED_BLOCK = register("compressed_block", new BlockItem(Blocks.COMPRESSED_BLOCK, defaultGroup()));

    private static Item.Settings defaultGroup() {
        return new Item.Settings().group(ItemGroups.CPM);
    }

    private static <T extends Item, R extends T> R register(String name, R item) {
        return Registry.register(Registry.ITEM, new Identifier(Compressed.MODID, name), item);
    }

    public static void register() {
    }
}