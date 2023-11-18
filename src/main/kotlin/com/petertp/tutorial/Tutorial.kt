package com.petertp.tutorial

import com.petertp.tutorial.block.ModBlocks
import com.petertp.tutorial.item.ModItemGroups
import com.petertp.tutorial.item.ModItems
import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object Tutorial : ModInitializer {
	const val MOD_ID = "tutorial"
	val logger: Logger = LoggerFactory.getLogger(MOD_ID)
	override fun onInitialize() {
		logger.info("Loading Server-Side!")
		ModItemGroups.registerItemGroups()
		ModItems.registerModItems()
		ModBlocks.registerModBlocks()
	}
}