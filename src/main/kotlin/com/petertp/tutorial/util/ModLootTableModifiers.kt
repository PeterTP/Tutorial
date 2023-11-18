package com.petertp.tutorial.util

import net.fabricmc.fabric.api.loot.v2.LootTableEvents
import net.fabricmc.fabric.api.loot.v2.LootTableEvents.Modify
import net.fabricmc.fabric.api.loot.v2.LootTableSource
import com.petertp.tutorial.item.ModItems
import net.minecraft.loot.LootManager
import net.minecraft.loot.LootPool
import net.minecraft.loot.LootTable
import net.minecraft.loot.condition.RandomChanceLootCondition
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.function.SetCountLootFunction
import net.minecraft.loot.provider.number.ConstantLootNumberProvider
import net.minecraft.loot.provider.number.UniformLootNumberProvider
import net.minecraft.resource.ResourceManager
import net.minecraft.util.Identifier

object ModLootTableModifiers {
    private val JUNGLE_TEMPLE_ID = Identifier("minecraft", "chests/jungle_temple")
    private val CREEPER_ID = Identifier("minecraft", "entities/creeper")
    private val SUSPICIOUS_SAND_ID = Identifier("minecraft", "archaeology/desert_pyramid")
    fun modifyLootTables() {
        LootTableEvents.MODIFY.register(Modify { resourceManager: ResourceManager?, lootManager: LootManager?, id: Identifier, tableBuilder: LootTable.Builder, source: LootTableSource? ->
            if (JUNGLE_TEMPLE_ID == id) {
                val poolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1f))
                    .conditionally(RandomChanceLootCondition.builder(1f)) // Drops 100% of the time
                    .with(ItemEntry.builder(ModItems.METAL_DETECTOR))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build())
                tableBuilder.pool(poolBuilder.build())
            }
            if (CREEPER_ID == id) {
                val poolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1f))
                    .conditionally(RandomChanceLootCondition.builder(1f))
                    .with(ItemEntry.builder(ModItems.COAL_BRIQUETTE))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build())
                tableBuilder.pool(poolBuilder.build())
            }
        })
//        LootTableEvents.REPLACE.register(LootTableEvents.Replace { resourceManager: ResourceManager?, lootManager: LootManager?, id: Identifier, original: LootTable, source: LootTableSource? ->
//            if (SUSPICIOUS_SAND_ID == id) {
//                val entries: MutableList<LootPoolEntry> =
//                    ArrayList(listOf<LootPoolEntry>(original.pools[0].entries))
//                entries.add(ItemEntry.builder(ModItems.METAL_DETECTOR).build())
//                entries.add(ItemEntry.builder(ModItems.COAL_BRIQUETTE).build())
//                val pool = LootPool.builder().with(entries)
//                return@register LootTable.builder().pool(pool).build()
//            }
//            null
//        })
    }
}
