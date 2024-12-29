package ru.screamoov.skufchat.channel;

import org.bukkit.entity.Player;

public class Channel {
    public String symbol;
    public String name;
    public String stringToFormat;

    public Channel(String symbol, String name, String stringToFormat) {
        this.symbol = symbol;
        this.name = name;
        this.stringToFormat = stringToFormat;
    }

    public String format(Player player, String message) {
        return stringToFormat
                .replaceAll("%player%", player.getName())
                .replaceAll("%message%", message);
    }
}
