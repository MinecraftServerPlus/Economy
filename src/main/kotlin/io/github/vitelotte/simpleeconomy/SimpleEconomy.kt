package io.github.vitelotte.simpleeconomy

import io.github.vitelotte.simpleeconomy.managers.ConfigManager
import net.milkbowl.vault.economy.Economy
import org.bukkit.plugin.RegisteredServiceProvider
import org.bukkit.plugin.java.JavaPlugin

class SimpleEconomy : JavaPlugin() {

    companion object {
        lateinit var economy: Economy
        lateinit var configManager: ConfigManager
    }

    override fun onEnable() {
        if (!setupEconomy()) {
            logger.severe("Vault plugin not found! Disabling plugin.")
            server.pluginManager.disablePlugin(this)
            return
        }
        setupConfig();
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

    private fun setupConfig(): Boolean {
        configManager = ConfigManager(this)
        configManager.loadConfig()
        return true;
    }
}
