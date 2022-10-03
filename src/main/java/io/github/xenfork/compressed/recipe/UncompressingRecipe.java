//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package io.github.xenfork.compressed.recipe;

import io.github.xenfork.compressed.block.CompressedBlock;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.WrittenBookItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class UncompressingRecipe extends SpecialCraftingRecipe {
    private static final Item ITEM = io.github.xenfork.compressed.item.Items.COMPRESSED_BLOCK;

    public UncompressingRecipe(Identifier identifier) {
        super(identifier);
    }

    public boolean matches(CraftingInventory craftingInventory, World world) {
        int i = 0;
        ItemStack itemStack = ItemStack.EMPTY;

        for (int j = 0; j < craftingInventory.size(); ++j) {
            ItemStack itemStack2 = craftingInventory.getStack(j);
            if (!itemStack2.isEmpty()) {
                if (itemStack2.isOf(ITEM)) {
                    if (!itemStack.isEmpty()) {
                        return false;
                    }

                    itemStack = itemStack2;
                } else {
                    if (!itemStack2.isOf(ITEM)) {
                        return false;
                    }

                    ++i;
                }
            }
        }

        return !itemStack.isEmpty() && itemStack.hasNbt() && i > 0;
    }

    @Override
    public ItemStack craft(CraftingInventory craftingInventory) {
        int i = 0;
        ItemStack itemStack = ItemStack.EMPTY;

        // Iterates the inventory
        for (int j = 0; j < craftingInventory.size(); ++j) {
            // The got stack
            ItemStack itemStack2 = craftingInventory.getStack(j);
            // If not empty...
            if (!itemStack2.isEmpty()) {
                // ...and is of the required item
                if (itemStack2.isOf(ITEM)) {
                    if (!itemStack.isEmpty()) {
                        return ItemStack.EMPTY;
                    }
                    itemStack = itemStack2;
                }
                // ...and not the item
                else {
                        // nothing
                        return ItemStack.EMPTY;
                    }

                    // count++
                    ++i;
                }
            }

        if (!itemStack.isEmpty() &&
                itemStack.hasNbt() &&
                i >= 1 &&
                CompressedBlock.getCompressedTime(itemStack) > 1 &&
                CompressedBlock.getCompressedTime(itemStack) <= 16) {
            ItemStack itemStack3 = new ItemStack(ITEM, i);
            if(itemStack.getNbt() != null) {
                NbtCompound nbtCompound = itemStack.getNbt().copy();
                nbtCompound.putInt("compressed_time", CompressedBlock.getCompressedTime(itemStack) - 1);
                itemStack3.setNbt(nbtCompound);
                return itemStack3;
            } else {
                return ItemStack.EMPTY;
            }
        } else {
            return ItemStack.EMPTY;
        }
    }

    /*public DefaultedList<ItemStack> getRemainder(CraftingInventory craftingInventory) {
        DefaultedList<ItemStack> defaultedList = DefaultedList.ofSize(craftingInventory.size(), ItemStack.EMPTY);

        for(int i = 0; i < defaultedList.size(); ++i) {
            ItemStack itemStack = craftingInventory.getStack(i);
            if (itemStack.getItem().hasRecipeRemainder()) {
                defaultedList.set(i, new ItemStack(itemStack.getItem().getRecipeRemainder()));
            } else if (itemStack.getItem() instanceof WrittenBookItem) {
                ItemStack itemStack2 = itemStack.copy();
                itemStack2.setCount(1);
                defaultedList.set(i, itemStack2);
                break;
            }
        }

        return defaultedList;
    }*/

    //应该不需要，暂时注释

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.UNCOMPRESSING;
    }

    @Override
    public boolean fits(int width, int height) {
        return width >= 3 && height >= 3;
    }
}
