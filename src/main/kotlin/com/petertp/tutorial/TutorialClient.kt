package com.petertp.tutorial

import com.petertp.tutorial.Tutorial.logger
import net.fabricmc.api.ClientModInitializer

object TutorialClient : ClientModInitializer {
    override fun onInitializeClient() {
        logger.info("Loading Client-Side!")
    }
}