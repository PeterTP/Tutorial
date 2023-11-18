package com.petertp.tutorial.block.custom

import com.petertp.tutorial.item.ModItems
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.CropBlock
import net.minecraft.item.ItemConvertible
import net.minecraft.state.StateManager
import net.minecraft.state.property.IntProperty
import net.minecraft.state.property.Properties

class TomatoCropBlock(settings: Settings?) : CropBlock(settings) {
    companion object {
        const val MAX_AGE = 5
        val AGE: IntProperty = Properties.AGE_5
    }

    override fun getSeedsItem(): ItemConvertible {
        return ModItems.TOMATO_SEEDS
    }

    public override fun getAgeProperty(): IntProperty {
        return AGE
    }

    override fun getMaxAge(): Int {
        return MAX_AGE
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        builder.add(AGE)
    }
}
