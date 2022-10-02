package io.github.xenfork.compressed.recipe;

import com.google.gson.JsonObject;
import java.util.function.Function;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;

public class SpecialRecipeSerializer<T extends Recipe<?>> implements RecipeSerializer<T> {
    private final Function<Identifier, T> factory;

    public SpecialRecipeSerializer(Function<Identifier, T> factory) {
        this.factory = factory;
    }

    public T read(Identifier id, JsonObject json) {
        return (T) this.factory.apply(id);
    }

    public T read(Identifier id, PacketByteBuf buf) {
        return (T) this.factory.apply(id);
    }

    public void write(PacketByteBuf buf, T recipe) {
    }
}
