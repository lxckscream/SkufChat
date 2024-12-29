package ru.screamoov.skufchat.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import ru.screamoov.skufchat.Chat;
import ru.screamoov.skufchat.channel.Channel;

public class ChatListener implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        for (Channel channel : Chat.getChannelsManager().channels) {
            if (message.startsWith(channel.symbol)) {
                Player player = event.getPlayer();
                message = message.replaceFirst(channel.symbol, "");
                message = channel.format(player, message);
                event.setMessage(message);
            }
        }
    }
}
