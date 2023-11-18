package com.petertp.tutorial.item

import com.petertp.tutorial.Tutorial
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import com.petertp.tutorial.block.ModBlocks
import com.petertp.tutorial.item.custom.MetalDetectorItem
import com.petertp.tutorial.item.custom.ModArmorItem
import net.minecraft.item.*
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object ModItems {
    val RUBY = registerItem("ruby", Item(FabricItemSettings()))
    val RAW_RUBY = registerItem("raw_ruby", Item(FabricItemSettings()))
    val METAL_DETECTOR = registerItem(
        "metal_detector",
        MetalDetectorItem(FabricItemSettings().maxDamage(64))
    )
    val TOMATO = registerItem("tomato", Item(FabricItemSettings().food(ModFoodComponents.TOMATO)))
    val COAL_BRIQUETTE = registerItem(
        "coal_briquette",
        Item(FabricItemSettings())
    )
    val RUBY_STAFF = registerItem(
        "ruby_staff",
        Item(FabricItemSettings().maxCount(1))
    )
    val RUBY_PICKAXE = registerItem(
        "ruby_pickaxe",
        PickaxeItem(ModToolMaterials.RUBY, 2, 2f, FabricItemSettings())
    )
    val RUBY_AXE = registerItem(
        "ruby_axe",
        AxeItem(ModToolMaterials.RUBY, 3f, 1f, FabricItemSettings())
    )
    val RUBY_SHOVEL = registerItem(
        "ruby_shovel",
        ShovelItem(ModToolMaterials.RUBY, 0f, 0f, FabricItemSettings())
    )
    val RUBY_SWORD = registerItem(
        "ruby_sword",
        SwordItem(ModToolMaterials.RUBY, 5, 3f, FabricItemSettings())
    )
    val RUBY_HOE = registerItem(
        "ruby_hoe",
        HoeItem(ModToolMaterials.RUBY, 0, 0f, FabricItemSettings())
    )
    val RUBY_HELMET = registerItem(
        "ruby_helmet",
        ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET, FabricItemSettings())
    )
    val RUBY_CHESTPLATE = registerItem(
        "ruby_chestplate",
        ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, FabricItemSettings())
    )
    val RUBY_LEGGINGS = registerItem(
        "ruby_leggings",
        ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, FabricItemSettings())
    )
    val RUBY_BOOTS = registerItem(
        "ruby_boots",
        ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS, FabricItemSettings())
    )
    val TOMATO_SEEDS = registerItem(
        "tomato_seeds",
        AliasedBlockItem(ModBlocks.TOMATO_CROP, FabricItemSettings())
    )

    private fun addItemsToIngredientItemGroup(entries: FabricItemGroupEntries) {
        entries.add(RUBY)
        entries.add(RAW_RUBY)
    }

    private fun registerItem(name: String, item: Item): Item {
        return Registry.register(Registries.ITEM, Identifier(Tutorial.MOD_ID, name), item)
    }

    fun registerModItems() {
        Tutorial.logger.info("Registering Mod Items for " + Tutorial.MOD_ID)
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
            .register(ModItems::addItemsToIngredientItemGroup)
    }
}
