package io.github.xenfork.compressed.recipe;

import com.google.gson.JsonObject;
import io.github.xenfork.compressed.Compressed;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public interface RecipeSerializer<T extends Recipe<?>> {
    SpecialRecipeSerializer<UncompressingRecipe> UNCOMPRESSING = (SpecialRecipeSerializer)register("crafting_special_uncompressing", new SpecialRecipeSerializer(UncompressingRecipe::new));

    T read(Identifier id, JsonObject json);

    T read(Identifier id, PacketByteBuf buf);

    void write(PacketByteBuf buf, T recipe);

    static <S extends net.minecraft.recipe.RecipeSerializer<T>, T extends Recipe<?>> S register(String id, S serializer) {
        return Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(Compressed.MODID, id), serializer);
    }
}
