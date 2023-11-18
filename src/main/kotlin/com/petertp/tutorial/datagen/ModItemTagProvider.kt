package com.petertp.tutorial.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import com.petertp.tutorial.item.ModItems
import net.minecraft.registry.RegistryWrapper.WrapperLookup
import net.minecraft.registry.tag.ItemTags
import java.util.concurrent.CompletableFuture

class ModItemTagProvider(output: FabricDataOutput?, completableFuture: CompletableFuture<WrapperLookup?>?) :
    FabricTagProvider.ItemTagProvider(output, completableFuture) {
    override fun configure(arg: WrapperLookup) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
            .add(ModItems.RUBY_HELMET, ModItems.RUBY_CHESTPLATE, ModItems.RUBY_LEGGINGS, ModItems.RUBY_BOOTS)
    }
}
