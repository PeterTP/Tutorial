package com.petertp.tutorial.datagen

import com.petertp.tutorial.block.ModBlocks
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import com.petertp.tutorial.item.ModItems
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder
import net.minecraft.item.ItemConvertible
import net.minecraft.item.Items
import net.minecraft.recipe.book.RecipeCategory
import net.minecraft.util.Identifier

class ModRecipeProvider(output: FabricDataOutput?) : FabricRecipeProvider(output) {
    private val RUBY_SMELTABLES = listOf<ItemConvertible>(
        ModItems.RAW_RUBY,
        ModBlocks.RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE, ModBlocks.NETHER_RUBY_ORE, ModBlocks.END_STONE_RUBY_ORE
    )

    override fun generate(exporter: RecipeExporter?) {
        offerSmelting(
            exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
            0.7f, 200, "ruby"
        )
        offerBlasting(
            exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
            0.7f, 100, "ruby"
        )
        offerReversibleCompactingRecipes(
            exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY, RecipeCategory.DECORATIONS,
            ModBlocks.RUBY_BLOCK
        )
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_RUBY, 1)
            .pattern("SSS")
            .pattern("SRS")
            .pattern("SSS")
            .input('S', Items.STONE)
            .input('R', ModItems.RUBY)
            .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
            .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
            .offerTo(exporter, Identifier(getRecipeName(ModItems.RAW_RUBY)))
    }
}