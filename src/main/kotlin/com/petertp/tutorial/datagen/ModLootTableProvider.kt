package com.petertp.tutorial.datagen

import com.petertp.tutorial.block.ModBlocks
import com.petertp.tutorial.block.custom.TomatoCropBlock
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import com.petertp.tutorial.item.ModItems
import net.minecraft.block.Block
import net.minecraft.enchantment.Enchantments
import net.minecraft.item.Item
import net.minecraft.loot.LootTable
import net.minecraft.loot.condition.BlockStatePropertyLootCondition
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.entry.LeafEntry
import net.minecraft.loot.entry.LootPoolEntry
import net.minecraft.loot.function.ApplyBonusLootFunction
import net.minecraft.loot.function.SetCountLootFunction
import net.minecraft.loot.provider.number.UniformLootNumberProvider
import net.minecraft.predicate.StatePredicate

class ModLootTableProvider(dataOutput: FabricDataOutput?) : FabricBlockLootTableProvider(dataOutput) {
    override fun generate() {
        addDrop(ModBlocks.RUBY_BLOCK)
        addDrop(ModBlocks.RAW_RUBY_BLOCK)
        addDrop(ModBlocks.SOUND_BLOCK)
        addDrop(ModBlocks.RUBY_ORE, copperLikeOreDrops(ModBlocks.RUBY_ORE, ModItems.RAW_RUBY))
        addDrop(ModBlocks.DEEPSLATE_RUBY_ORE, copperLikeOreDrops(ModBlocks.DEEPSLATE_RUBY_ORE, ModItems.RAW_RUBY))
        addDrop(ModBlocks.NETHER_RUBY_ORE, copperLikeOreDrops(ModBlocks.NETHER_RUBY_ORE, ModItems.RAW_RUBY))
        addDrop(ModBlocks.END_STONE_RUBY_ORE, copperLikeOreDrops(ModBlocks.END_STONE_RUBY_ORE, ModItems.RAW_RUBY))
        addDrop(ModBlocks.RUBY_STAIRS)
        addDrop(ModBlocks.RUBY_TRAPDOOR)
        addDrop(ModBlocks.RUBY_WALL)
        addDrop(ModBlocks.RUBY_FENCE)
        addDrop(ModBlocks.RUBY_FENCE_GATE)
        addDrop(ModBlocks.RUBY_BUTTON)
        addDrop(ModBlocks.RUBY_PRESSURE_PLATE)
        addDrop(ModBlocks.RUBY_DOOR, doorDrops(ModBlocks.RUBY_DOOR))
        addDrop(ModBlocks.RUBY_SLAB, slabDrops(ModBlocks.RUBY_SLAB))
        val builder = BlockStatePropertyLootCondition.builder(ModBlocks.TOMATO_CROP).properties(
            StatePredicate.Builder.create()
                .exactMatch(TomatoCropBlock.AGE, 5)
        )
        addDrop(
            ModBlocks.TOMATO_CROP,
            cropDrops(ModBlocks.TOMATO_CROP, ModItems.TOMATO, ModItems.TOMATO_SEEDS, builder)
        )
    }

    private fun copperLikeOreDrops(drop: Block?, item: Item?): LootTable.Builder {
        return dropsWithSilkTouch(
            drop, applyExplosionDecay(
                drop,
                (ItemEntry.builder(item)
                    .apply(
                        SetCountLootFunction
                            .builder(
                                UniformLootNumberProvider
                                    .create(2.0f, 5.0f)
                            )
                    ) as LeafEntry.Builder<*>)
                    .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
            ) as LootPoolEntry.Builder<*>
        )
    }
}
