package com.petertp.tutorial.item.custom

import com.petertp.tutorial.util.ModTags
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.ItemUsageContext
import net.minecraft.text.Text
import net.minecraft.util.ActionResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class MetalDetectorItem(settings: Settings?) : Item(settings) {
    override fun useOnBlock(context: ItemUsageContext): ActionResult {
        if (!context.world.isClient()) {
            val positionClicked = context.blockPos
            val player = context.player
            var foundBlock = false
            for (i in 0..positionClicked.y + 64) {
                val state = context.world.getBlockState(positionClicked.down(i))
                if (isValuableBlock(state)) {
                    outputValuableCoordinates(positionClicked.down(i), player, state.block)
                    foundBlock = true
                    break
                }
            }
            if (!foundBlock) {
                player!!.sendMessage(Text.literal("No Valuables Found!"))
            }
        }
        context.stack.damage(
            1, context.player
        ) { playerEntity: PlayerEntity? ->
            playerEntity!!.sendToolBreakStatus(
                playerEntity.activeHand
            )
        }
        return ActionResult.SUCCESS
    }

    private fun outputValuableCoordinates(blockPos: BlockPos, player: PlayerEntity?, block: Block) {
        player!!.sendMessage(
            Text.literal(
                "Found ${block.asItem().name.string} at ( ${blockPos.x},  ${blockPos.y}, ${blockPos.z})"
            ), false
        )
    }

    private fun isValuableBlock(state: BlockState): Boolean {
        return state.isIn(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS)
    }

    override fun appendTooltip(stack: ItemStack, world: World?, tooltip: MutableList<Text>, context: TooltipContext) {
        tooltip.add(Text.translatable("item.tutorial.metal_detector.tooltip"))
        super.appendTooltip(stack, world, tooltip, context)
    }
}
