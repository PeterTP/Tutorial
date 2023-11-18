package com.petertp.tutorial.datagen

import com.petertp.tutorial.block.ModBlocks
import com.petertp.tutorial.block.custom.TomatoCropBlock
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import com.petertp.tutorial.item.ModItems
import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.Models
import net.minecraft.item.ArmorItem

class ModModelProvider(output: FabricDataOutput?) : FabricModelProvider(output) {
    override fun generateBlockStateModels(blockStateModelGenerator: BlockStateModelGenerator) {
        val rubyPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RUBY_BLOCK)
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_RUBY_BLOCK)
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_ORE)
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_RUBY_ORE)
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_RUBY_ORE)
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_STONE_RUBY_ORE)
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOUND_BLOCK)
        rubyPool.stairs(ModBlocks.RUBY_STAIRS)
        rubyPool.slab(ModBlocks.RUBY_SLAB)
        rubyPool.button(ModBlocks.RUBY_BUTTON)
        rubyPool.pressurePlate(ModBlocks.RUBY_PRESSURE_PLATE)
        rubyPool.fence(ModBlocks.RUBY_FENCE)
        rubyPool.fenceGate(ModBlocks.RUBY_FENCE_GATE)
        rubyPool.wall(ModBlocks.RUBY_WALL)
        blockStateModelGenerator.registerDoor(ModBlocks.RUBY_DOOR)
        blockStateModelGenerator.registerTrapdoor(ModBlocks.RUBY_TRAPDOOR)
        blockStateModelGenerator.registerCrop(ModBlocks.TOMATO_CROP, TomatoCropBlock.AGE, 0, 1, 2, 3, 4, 5)
    }

    override fun generateItemModels(itemModelGenerator: ItemModelGenerator) {
        itemModelGenerator.register(ModItems.RUBY, Models.GENERATED)
        itemModelGenerator.register(ModItems.RAW_RUBY, Models.GENERATED)
        itemModelGenerator.register(ModItems.COAL_BRIQUETTE, Models.GENERATED)
        itemModelGenerator.register(ModItems.TOMATO, Models.GENERATED)
        itemModelGenerator.register(ModItems.METAL_DETECTOR, Models.GENERATED)
        itemModelGenerator.register(ModItems.RUBY_PICKAXE, Models.HANDHELD)
        itemModelGenerator.register(ModItems.RUBY_AXE, Models.HANDHELD)
        itemModelGenerator.register(ModItems.RUBY_SHOVEL, Models.HANDHELD)
        itemModelGenerator.register(ModItems.RUBY_SWORD, Models.HANDHELD)
        itemModelGenerator.register(ModItems.RUBY_HOE, Models.HANDHELD)
        itemModelGenerator.registerArmor(ModItems.RUBY_HELMET as ArmorItem)
        itemModelGenerator.registerArmor(ModItems.RUBY_CHESTPLATE as ArmorItem)
        itemModelGenerator.registerArmor(ModItems.RUBY_LEGGINGS as ArmorItem)
        itemModelGenerator.registerArmor(ModItems.RUBY_BOOTS as ArmorItem)
    }
}
