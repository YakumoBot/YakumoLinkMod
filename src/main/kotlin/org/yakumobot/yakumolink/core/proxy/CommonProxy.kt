package org.yakumobot.yakumolink.core.proxy

import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraftforge.common.config.Configuration
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import org.apache.logging.log4j.Logger
import org.yakumobot.yakumolink.core.Config
import org.yakumobot.yakumolink.core.util.Open
import java.io.File

@Open
@Mod.EventBusSubscriber
class CommonProxy {
    companion object {
        @JvmStatic
        @SubscribeEvent
        fun registerBlocks(event: RegistryEvent.Register<Block>) {

        }

        @JvmStatic
        lateinit var logger: Logger

        @JvmStatic
        @SubscribeEvent
        fun registerItems(event: RegistryEvent.Register<Item>) {
        }

        @JvmStatic
        lateinit var config: Configuration //net.minecraftforge.common.config.Configuration
    }

    fun preInit(e: FMLPreInitializationEvent) {
        val directory: File = e.modConfigurationDirectory
        config = Configuration(File(directory.path, "YakumoLink.cfg"))
        Config.readConfig()
    }

    fun init(e: FMLInitializationEvent) {}

    fun postInit(e: FMLPostInitializationEvent) {}

    fun loadComplete(e: FMLLoadCompleteEvent){
        logger.info("Yakumo-Link onLoad")
    }
}