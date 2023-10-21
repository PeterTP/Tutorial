package com.petertp.tutorial

import com.petertp.tutorial.Tutorial.MOD_ID
import com.petertp.tutorial.Tutorial.logger
import net.fabricmc.api.ClientModInitializer

object TutorialClient : ClientModInitializer {
    override fun onInitializeClient() {
        logger.info("$MOD_ID clientside loaded successfully!")
    }
}