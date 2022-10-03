package io.github.xenfork.compressed.recipe;

import io.github.xenfork.compressed.Compressed;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRecipeSerializers {
    public static final SpecialRecipeSerializer<UncompressingRecipe> UNCOMPRESSING = register("crafting_special_uncompressing", new SpecialRecipeSerializer<>(UncompressingRecipe::new));

    private static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String id, S serializer) {
        return Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(Compressed.MODID, id), serializer);
    }
}
