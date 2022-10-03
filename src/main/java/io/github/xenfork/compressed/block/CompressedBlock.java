package io.github.xenfork.compressed.block;

import io.github.xenfork.compressed.block.enums.CompressedBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;


public class CompressedBlock extends Block {
    public static final EnumProperty<CompressedBlocks> COMPRESSED_BLOCKS =
            EnumProperty.of("compressed_blocks", CompressedBlocks.class);

    public static final IntProperty COMPRESSED_TIME =
            IntProperty.of("compressed_time", 1, 16);

    public CompressedBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(stateManager.getDefaultState().with(COMPRESSED_TIME, 1).with(COMPRESSED_BLOCKS, CompressedBlocks.NONE));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(COMPRESSED_TIME, COMPRESSED_BLOCKS);
    }

    public static int getCompressedTime(ItemStack stack) {
        NbtCompound nbt = stack.getNbt();
        if (nbt != null) {
            int tm = nbt.getInt("compressed_time");
            // TODO: 2022/10/3 Remove it
            System.out.println(tm);
            return tm;
        }
        return 0;
    }
}
