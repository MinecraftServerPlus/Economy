package io.github.vitelotte.economy.managers

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.plugin.java.JavaPlugin
import kotlin.properties.Delegates

class ConfigManager(private val plugin: JavaPlugin) {
    private lateinit var config: FileConfiguration
    private var initialBalance by Delegates.notNull<Long>()
    private var currencySymbol by Delegates.notNull<String>()
    private var renderFormat by Delegates.notNull<String>()

    fun loadConfig() {
        plugin.saveDefaultConfig()
        config = plugin.config
        initialBalance = config.getLong("user.initial-balance", 0)
        currencySymbol = config.getString("currency.symbol", "$")!!
        renderFormat = config.getString("currency.render-format", "{symbol}{amount}")!!
    }

    fun loadInitialBalance() {
        initialBalance = config.getLong("initial-balance", 0)
    }

    fun fetchInitialBalance() {
        config["initial-balance"] = initialBalance
    }

    fun getInitialBalance(): Long {
        return initialBalance;
    }

    fun setInitialBalance(balance: Long) {
        initialBalance = balance
    }

    fun loadCurrencySymbol() {
        currencySymbol = config.getString("currency.symbol", "$")!!
    }

    fun fetchCurrencySymbol() {
        config["currency.render-format"] = currencySymbol
    }

    fun getCurrencySymbol(): String {
        return currencySymbol
    }

    fun setCurrencySymbol(symbol: String) {
        currencySymbol = symbol
    }

    fun loadRenderFormat() {
        renderFormat = config.getString("currency.render-format", "{symbol}{amount}")!!
    }

    fun fetchRenderFormat() {
        config["currency.render-format"] = renderFormat
    }

    fun getRenderFormat(): String {
        return renderFormat
    }

    fun setRenderFormat(format: String) {
        renderFormat = format
    }
}