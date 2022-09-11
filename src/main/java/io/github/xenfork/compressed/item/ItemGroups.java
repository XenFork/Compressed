package io.github.xenfork.compressed.item;

import io.github.xenfork.compressed.Compressed;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

/**
 * @author ARMrAmzing
 */
public final class ItemGroups {
    public static final ItemGroup CPM = FabricItemGroupBuilder.build(
            new Identifier(Compressed.MODID, "cpm"),
            () -> new ItemStack(Items.COMPRESSED_BLOCK));
}
