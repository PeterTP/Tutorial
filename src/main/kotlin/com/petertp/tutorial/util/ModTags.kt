package com.petertp.tutorial.util

import com.petertp.tutorial.Tutorial
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier

object ModTags {
    object Blocks {
        val METAL_DETECTOR_DETECTABLE_BLOCKS = createTag("metal_detector_detectable_blocks")
        private fun createTag(name: String): TagKey<Block> {
            return TagKey.of<Block>(RegistryKeys.BLOCK, Identifier(Tutorial.MOD_ID, name))
        }
    }

    object Items {
        private fun createTag(name: String): TagKey<Item> {
            return TagKey.of<Item>(RegistryKeys.ITEM, Identifier(Tutorial.MOD_ID, name))
        }
    }
}
