package io.github.vitelotte.simpleeconomy.managers

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.plugin.java.JavaPlugin
import kotlin.properties.Delegates

class ConfigManager(private val plugin: JavaPlugin) {
    private lateinit var config: FileConfiguration

    private val initialBalancePath = "system.initial-balance"
    private val currencySymbolPath = "currency.symbol"
    private val renderFormatPath = "currency.render-format"
    private val defaultLanguagePath = "system.default-language"

    private var initialBalance by Delegates.notNull<Double>()
    private var currencySymbol by Delegates.notNull<String>()
    private var renderFormat by Delegates.notNull<String>()
    private var defaultLanguage by Delegates.notNull<String>()

    fun loadConfig() {
        plugin.saveDefaultConfig()
        config = plugin.config
        initialBalance = config.getDouble(initialBalancePath, 0.0)
        currencySymbol = config.getString(currencySymbolPath, "$")!!
        renderFormat = config.getString(renderFormatPath, "{symbol}{amount}")!!
        defaultLanguage = config.getString(defaultLanguagePath, "ko-kr")!!
    }

    fun loadInitialBalance() {
        initialBalance = config.getDouble(initialBalancePath, 0.0)
    }

    fun fetchInitialBalance() {
        config[initialBalancePath] = initialBalance
    }
    fun getInitialBalance(): Double {
        return initialBalance
    }

    fun setInitialBalance(balance: Double) {
        initialBalance = balance
    }

    fun loadCurrencySymbol() {
        currencySymbol = config.getString(currencySymbolPath, "$")!!
    }

    fun fetchCurrencySymbol() {
        config[currencySymbolPath] = currencySymbol
    }

    fun setCurrencySymbol(symbol: String) {
        currencySymbol = symbol
    }

    fun getCurrencySymbol(): String {
        return currencySymbol
    }

    fun loadRenderFormat() {
        renderFormat = config.getString(renderFormatPath, "{symbol}{amount}")!!
    }

    fun fetchRenderFormat() {
        config[renderFormatPath] = renderFormat
    }

    fun setRenderFormat(format: String) {
        renderFormat = format
    }

    fun getRenderFormat(): String {
        return renderFormat
    }

    fun loadDefaultLanguage() {
        defaultLanguage = config.getString(defaultLanguagePath, "ko-kr")!!
    }

    fun fetchDefaultLanguage() {
        config[defaultLanguagePath] = defaultLanguage
    }

    fun getDefaultLanguage(): String {
        return defaultLanguage
    }

    fun setDefaultLanguage(language: String) {
        defaultLanguage = language
    }
}