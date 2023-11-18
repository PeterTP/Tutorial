package com.petertp.tutorial.block

import com.petertp.tutorial.Tutorial
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.block.ExperienceDroppingBlock
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object ModBlocks {
    val RUBY_BLOCK = registerBlock("ruby_block", Block(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK)))
    val RUBY_ORE = registerBlock("ruby_ore", ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.EMERALD_ORE)))

    private fun registerBlock(name: String, block: Block): Block {
        registerBlockItem(name, block)
        return Registry.register(Registries.BLOCK, Identifier(Tutorial.MOD_ID, name), block)
    }

    private fun registerBlockItem(name: String, block: Block): Item {
        return Registry.register(Registries.ITEM, Identifier(Tutorial.MOD_ID, name), BlockItem(block, FabricItemSettings()))
    }

    fun registerModBlocks() {
        Tutorial.logger.info("Registering Blocks")
    }
}