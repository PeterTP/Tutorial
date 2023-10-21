package com.petertp.tutorial.item

import com.petertp.tutorial.Tutorial
import com.petertp.tutorial.block.ModBlocks
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text
import net.minecraft.util.Identifier
object ModItemGroups {
    val RUBY_GROUP: ItemGroup = Registry.register(
        Registries.ITEM_GROUP,
        Identifier(Tutorial.MOD_ID, "ruby"),
        FabricItemGroup.builder()
            .displayName(Text.translatable("itemgroup.ruby"))
            .icon { ItemStack(ModItems.RUBY) }
            .entries { displayContext, entries ->
                entries.add(ModItems.RUBY)
                entries.add(ModItems.RAW_RUBY)
                entries.add(ModBlocks.RUBY_BLOCK)
                entries.add(ModBlocks.RUBY_ORE)
            }.build())
    fun registerItemGroups() {
        Tutorial.logger.info("Registering Item Groups")
    }
}