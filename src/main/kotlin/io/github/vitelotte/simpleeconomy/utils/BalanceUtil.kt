package io.github.vitelotte.simpleeconomy.utils

import io.github.vitelotte.simpleeconomy.SimpleEconomy

class BalanceUtil {
    companion object {
        fun getRenderedBalance(balance: Double, currencySymbol: String = SimpleEconomy.configManager.getCurrencySymbol()): String {
            var renderedBalance: String = SimpleEconomy.configManager.getRenderFormat()
            renderedBalance = renderedBalance.replace("{symbol}", currencySymbol)
            renderedBalance = renderedBalance.replace("{balance}", balance.toString())
            return renderedBalance
        }
    }
}