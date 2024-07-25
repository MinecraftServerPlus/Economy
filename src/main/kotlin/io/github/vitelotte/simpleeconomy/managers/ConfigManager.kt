package io.github.vitelotte.simpleeconomy.managers

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.plugin.java.JavaPlugin
import kotlin.properties.Delegates

class ConfigManager(private val plugin: JavaPlugin) {
    private lateinit var config: FileConfiguration
    private var initialBalance by Delegates.notNull<Double>()
    private var currencySymbol by Delegates.notNull<String>()
    private var renderFormat by Delegates.notNull<String>()

    fun loadConfig() {
        plugin.saveDefaultConfig()
        config = plugin.config
        initialBalance = config.getDouble("user.initial-balance", 0.0)
        currencySymbol = config.getString("currency.symbol", "$")!!
        renderFormat = config.getString("currency.render-format", "{symbol}{amount}")!!
    }

    fun loadInitialBalance() {
        initialBalance = config.getDouble("initial-balance", 0.0)
    }

    fun fetchInitialBalance() {
        config["initial-balance"] = initialBalance
    }
    fun getInitialBalance(): Double {
        return initialBalance;
    }

    fun setInitialBalance(balance: Double) {
        initialBalance = balance
    }

    fun loadCurrencySymbol() {
        currencySymbol = config.getString("currency.symbol", "$")!!
    }

    fun fetchCurrencySymbol() {
        config["currency.render-format"] = currencySymbol
    }

    fun setCurrencySymbol(symbol: String) {
        currencySymbol = symbol
    }

    fun getCurrencySymbol(): String {
        return currencySymbol
    }

    fun loadRenderFormat() {
        renderFormat = config.getString("currency.render-format", "{symbol}{amount}")!!
    }

    fun fetchRenderFormat() {
        config["currency.render-format"] = renderFormat
    }

    fun setRenderFormat(format: String) {
        renderFormat = format
    }

    fun getRenderFormat(): String {
        return renderFormat
    }
}