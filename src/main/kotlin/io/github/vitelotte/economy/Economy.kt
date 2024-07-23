package io.github.vitelotte.economy

import org.bukkit.plugin.RegisteredServiceProvider
import org.bukkit.plugin.java.JavaPlugin

class Economy : JavaPlugin() {

    companion object {
        lateinit var economy: Economy
    }

    override fun onEnable() {
        if (!setupEconomy()) {
            logger.severe("Vault plugin not found! Disabling plugin.")
            server.pluginManager.disablePlugin(this)
            return
        }
        logger.info("Plugin successfully enabled.")
    }

    override fun onDisable() {
        this.saveConfig()
        logger.info("Plugin successfully disabled.")
    }

    private fun setupEconomy(): Boolean {
        if (server.pluginManager.getPlugin("Vault") == null) {
            return false
        }

        val registerServiceProvider: RegisteredServiceProvider<Economy> = server.servicesManager.getRegistration(Economy::class.java) ?: return false
        economy = registerServiceProvider.provider;
        return true;
    }
}
