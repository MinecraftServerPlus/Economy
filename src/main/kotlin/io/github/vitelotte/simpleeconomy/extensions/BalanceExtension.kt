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

fun OfflinePlayer.addBalance(balance: Double) {
    SimpleEconomy.economy.depositPlayer(this, balance);
}

fun OfflinePlayer.subtractBalance(balance: Double) {
    if (SimpleEconomy.economy.has(this, balance)) {
        SimpleEconomy.economy.withdrawPlayer(this, balance)
    }
}