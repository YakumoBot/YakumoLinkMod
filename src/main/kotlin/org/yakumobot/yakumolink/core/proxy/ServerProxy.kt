package org.yakumobot.yakumolink.core.proxy

import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.event.FMLServerStartingEvent
import net.minecraftforge.fml.relauncher.Side


@Mod.EventBusSubscriber(Side.SERVER)
class ServerProxy : CommonProxy() {
    fun serverStarting(e: FMLServerStartingEvent){
        logger.info("Yakumo-Link onStandby")
    }

}