package ru.screamoov.skufchat;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import ru.screamoov.skufapi.ISkufPlugin;
import ru.screamoov.skufapi.Main;
import ru.screamoov.skufapi.logger.Logger;
import ru.screamoov.skufchat.channel.Channel;
import ru.screamoov.skufchat.managers.ChannelsManager;

public final class Chat extends JavaPlugin implements ISkufPlugin {
    static Chat plugin;
    static ChannelsManager channelsManager;
    static Logger logger;

    @Override
    public void onEnable() {
        Main.registerPlugin(this);
    }

    public static ChannelsManager getChannelsManager() {
        return channelsManager;
    }

    public static Chat getPlugin() {
        return plugin;
    }

    @Override
    public void disable() {

    }

    @Override
    public void enable() {
        plugin = this;
        logger = new Logger("SkufChat", false);
        channelsManager = new ChannelsManager();
        saveDefaultConfig();

        for (String ln : getConfig().getConfigurationSection("channels").getKeys(false)) {
            channelsManager.registerChannel(
                    new Channel(
                        getConfig().getString("channels." + ln + ".symbol"),
                        getConfig().getString("channels." + ln + ".name"),
                        getConfig().getString("channels." + ln + ".format")
                    )
            );
            logger.info("Зарегистрирован канал: " + ln);
        }
    }

    @Override
    public void shutdown() {

    }

    @Override
    public Logger getLog() {
        return logger;
    }

    @Override
    public Plugin getBukkitPlugin() {
        return null;
    }
}
