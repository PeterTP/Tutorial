package com.petertp.tutorial.item

import com.petertp.tutorial.Tutorial
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object ModItems {
    private val RUBY = registerItem("ruby", Item(FabricItemSettings()))
    private val RAW_RUBY = registerItem("raw_ruby", Item(FabricItemSettings()))

    private fun addItemsToIngredientItemGroup(entries: FabricItemGroupEntries) {
        entries.add(RUBY)
        entries.add(RAW_RUBY)
    }
    private fun registerItem(name: String, item: Item): Item {
        return Registry.register(Registries.ITEM, Identifier(Tutorial.MOD_ID, name), item)
    }
    fun registerModItems() {
        Tutorial.logger.info("Registering Mod Items for " + Tutorial.MOD_ID)
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup)
    }
}