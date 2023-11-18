package com.petertp.tutorial.block

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import com.petertp.tutorial.Tutorial
import com.petertp.tutorial.block.custom.SoundBlock
import com.petertp.tutorial.block.custom.TomatoCropBlock
import net.minecraft.block.*
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier
import net.minecraft.util.math.intprovider.UniformIntProvider

object ModBlocks {
    val RUBY_BLOCK = registerBlock(
        "ruby_block",
        Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK))
    )
    val RAW_RUBY_BLOCK = registerBlock(
        "raw_ruby_block",
        Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK))
    )
    val RUBY_ORE = registerBlock(
        "ruby_ore",
        ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(2f), UniformIntProvider.create(2, 5))
    )
    val DEEPSLATE_RUBY_ORE = registerBlock(
        "deepslate_ruby_ore",
        ExperienceDroppingBlock(
            FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(4f),
            UniformIntProvider.create(2, 5)
        )
    )
    val NETHER_RUBY_ORE = registerBlock(
        "nether_ruby_ore",
        ExperienceDroppingBlock(
            FabricBlockSettings.copyOf(Blocks.NETHERRACK).strength(1.5f),
            UniformIntProvider.create(2, 5)
        )
    )
    val END_STONE_RUBY_ORE = registerBlock(
        "end_stone_ruby_ore",
        ExperienceDroppingBlock(
            FabricBlockSettings.copyOf(Blocks.END_STONE).strength(4f),
            UniformIntProvider.create(4, 7)
        )
    )
    val SOUND_BLOCK = registerBlock(
        "sound_block",
        SoundBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK))
    )
    val RUBY_STAIRS = registerBlock(
        "ruby_stairs",
        StairsBlock(RUBY_BLOCK.defaultState, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK))
    )
    val RUBY_SLAB = registerBlock(
        "ruby_slab",
        SlabBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK))
    )
    val RUBY_BUTTON = registerBlock(
        "ruby_button",
        ButtonBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON, 10, true)
    )
    val RUBY_PRESSURE_PLATE = registerBlock(
        "ruby_pressure_plate",
        PressurePlateBlock(
            PressurePlateBlock.ActivationRule.EVERYTHING,
            FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON
        )
    )
    val RUBY_FENCE = registerBlock(
        "ruby_fence",
        FenceBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK))
    )
    val RUBY_FENCE_GATE = registerBlock(
        "ruby_fence_gate",
        FenceGateBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), WoodType.ACACIA)
    )
    val RUBY_WALL = registerBlock(
        "ruby_wall",
        WallBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK))
    )
    val RUBY_DOOR = registerBlock(
        "ruby_door",
        DoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque(), BlockSetType.IRON)
    )
    val RUBY_TRAPDOOR = registerBlock(
        "ruby_trapdoor",
        TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque(), BlockSetType.IRON)
    )
    val TOMATO_CROP: Block = Registry.register<Block, TomatoCropBlock>(
        Registries.BLOCK, Identifier(Tutorial.MOD_ID, "tomato_crop"),
        TomatoCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT))
    )

    private fun registerBlock(name: String, block: Block): Block {
        registerBlockItem(name, block)
        return Registry.register<Block, Block>(Registries.BLOCK, Identifier(Tutorial.MOD_ID, name), block)
    }

    private fun registerBlockItem(name: String, block: Block): Item {
        return Registry.register<Item, BlockItem>(
            Registries.ITEM, Identifier(Tutorial.MOD_ID, name),
            BlockItem(block, FabricItemSettings())
        )
    }

    fun registerModBlocks() {
        Tutorial.logger.info("Registering ModBlocks for " + Tutorial.MOD_ID)
    }
}
