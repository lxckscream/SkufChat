package ru.screamoov.skufchat.channel;

public class Channel {
    public String symbol;
    public String name;
    public String stringToFormat;

    public Channel(String symbol, String name, String stringToFormat) {
        this.symbol = symbol;
        this.name = name;
        this.stringToFormat = stringToFormat;
    }
}
