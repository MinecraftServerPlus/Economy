package io.github.vitelotte.simpleeconomy.extensions

import io.github.vitelotte.simpleeconomy.SimpleEconomy
import org.bukkit.OfflinePlayer

fun OfflinePlayer.getBalance(): Double{
    return SimpleEconomy.economy.getBalance(this)
}

fun OfflinePlayer.setBalance(balance: Double) {
    SimpleEconomy.economy.depositPlayer(this, balance)
}

fun OfflinePlayer.initBalance() {
    SimpleEconomy.economy.createPlayerAccount(this)
    SimpleEconomy.economy.depositPlayer(this, SimpleEconomy.configManager.getInitialBalance())
}