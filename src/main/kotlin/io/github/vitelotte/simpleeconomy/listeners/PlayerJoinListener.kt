package io.github.vitelotte.simpleeconomy.listeners

import io.github.vitelotte.simpleeconomy.SimpleEconomy
import io.github.vitelotte.simpleeconomy.extensions.initBalance
import io.github.vitelotte.simpleeconomy.managers.ConfigManager
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerJoinListener : Listener {

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player

        if (!SimpleEconomy.economy.hasAccount(player)) {
            player.initBalance()
        }
    }

}