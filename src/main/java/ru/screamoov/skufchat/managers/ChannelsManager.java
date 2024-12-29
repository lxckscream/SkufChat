package ru.screamoov.skufchat.managers;

import ru.screamoov.skufchat.channel.Channel;

import java.util.ArrayList;

public class ChannelsManager {
    public ArrayList<Channel> channels = new ArrayList<Channel>();
    public void registerChannel(Channel channel) {
        channels.add(channel);
    }
}
