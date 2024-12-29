package ru.screamoov.skufchat.channel;

import org.bukkit.entity.Player;

import static ru.screamoov.skufapi.colorize.Hex.color;

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
        return color(stringToFormat
                .replaceAll("%player%", player.getName())
                .replaceAll("%message%", message));
    }
}
