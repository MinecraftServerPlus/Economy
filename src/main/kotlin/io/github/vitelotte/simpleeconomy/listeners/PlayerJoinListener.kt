package io.github.vitelotte.economy.listeners

import io.github.vitelotte.economy.Economy
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerMoveEvent

class PlayerJoinListener : Listener {

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        val initialBalance = Economy.configManager.getInitialBalance()

        if (!Economy.economy.hasAccount(player)) {
            Economy.economy.createPlayerAccount(player)
            Economy.economy.depositPlayer(player, initialBalance)
        }
    }

}