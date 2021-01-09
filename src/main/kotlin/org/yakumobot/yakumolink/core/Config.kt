package org.yakumobot.yakumolink.core

import org.yakumobot.yakumolink.core.proxy.CommonProxy
import net.minecraftforge.common.config.Configuration
import org.apache.logging.log4j.Level

object Config {
    // This values below you can access elsewhere in your mod:
    var myConfig1 = false
    var myConfig2 = 114
    var myConfig3 = "滑稽"

    private val CATEGORY_GENERAL = "general"
    private val CATEGORY_DIMENSIONS = "dimensions"

    // Call this from CommonProxy.preInit(). It will create our global if it doesn't
    // exist yet and read the values if it does exist.
    fun readConfig() {
        CommonProxy.config.run {
            try {
                load()
                initGeneralConfig()
                initDimensionConfig()
            } catch (e1: Exception) {
                YakumoLink.logger.log(Level.ERROR, "Problem loading global file!", e1)
            } finally {
                if (hasChanged()) {
                    save()
                }
            }
        }
    }

    private fun Configuration.initGeneralConfig() {
        addCustomCategoryComment(CATEGORY_GENERAL, "General configuration")
        myConfig1 = getBoolean("myConfig1", CATEGORY_GENERAL, myConfig1, "示例配置1")
        myConfig2 = getInt("myConfig2", CATEGORY_GENERAL, myConfig2, 0, 999, "示例配置2")
        myConfig3 = getString("myConfig3", CATEGORY_GENERAL, myConfig3, "示例配置3")
    }

    private fun Configuration.initDimensionConfig() {
        addCustomCategoryComment(CATEGORY_DIMENSIONS, "Dimension configuration")
    }
}