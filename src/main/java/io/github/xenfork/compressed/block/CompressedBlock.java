package io.github.xenfork.compressed.block;

import io.github.xenfork.compressed.block.enums.CompressedBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;


public class CompressedBlock extends Block {
    public static final EnumProperty<CompressedBlocks> COMPRESSED_BLOCKS =
            EnumProperty.of("compressed_blocks", CompressedBlocks.class);

    public static final IntProperty COMPRESSED_TIMES =
            IntProperty.of("compressed_times", 1, 16);;

    public CompressedBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(stateManager.getDefaultState().with(COMPRESSED_TIMES, 1).with(COMPRESSED_BLOCKS, CompressedBlocks.NONE));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(COMPRESSED_TIMES,COMPRESSED_BLOCKS);
    }
}
