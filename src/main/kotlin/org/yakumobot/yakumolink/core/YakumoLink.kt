package org.yakumobot.yakumolink.core

import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import org.apache.logging.log4j.Logger
import org.yakumobot.yakumolink.core.proxy.CommonProxy

@Mod(
    modid = YakumoLink.MODID,
    name = YakumoLink.NAME,
    version = YakumoLink.VERSION,
    dependencies = "net.shadowfacts.forgelin.KotlinAdapter"
)
class YakumoLink {
    companion object {
        const val MODID = "yakumolink"
        const val NAME = "Yakumo Link"
        const val VERSION = "1.0.0"

        @JvmStatic
        lateinit var logger: Logger

        @JvmStatic
        @SidedProxy(
            clientSide = "org.yakumobot.yakumolink.core.proxy.ClientProxy",
            serverSide = "org.yakumobot.yakumolink.core.proxy.ServerProxy"
        )
        lateinit var proxy: CommonProxy
    }

    @EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        logger = event.modLog
        proxy.preInit(event)
    }

    @EventHandler
    fun init(event: FMLInitializationEvent) {
        proxy.init(event)
    }

    @EventHandler
    fun postInit(event: FMLPostInitializationEvent) {
        proxy.postInit(event)
    }
}
