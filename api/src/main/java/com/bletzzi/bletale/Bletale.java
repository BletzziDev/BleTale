package com.bletzzi.bletale;

import com.bletzzi.bletale.api.command.CommandHandler;
import com.bletzzi.bletale.core.command.NativeCommandHandler;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;

import javax.annotation.Nonnull;

public final class Bletale {
    private static Bletale instance;

    @Nonnull
    private final JavaPlugin plugin;

    private Bletale(@Nonnull final JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void registerCommandHandler(@Nonnull final CommandHandler commandHandler) {
        this.plugin.getCommandRegistry().registerCommand(new NativeCommandHandler(commandHandler));
    }

    public static Bletale getInstance(@Nonnull final JavaPlugin plugin) {
        if(instance == null) {
            instance = new Bletale(plugin);

            final String manifestGroup = plugin.getManifest().getGroup();
            final String manifestName = plugin.getManifest().getName();
            if(manifestGroup.equals("Bletzzi") && manifestName.equals("Bletale")) {
                plugin.getLogger().atInfo().log("[Bletale] Bletale API has been loaded in Standalone Mode!");
            } else plugin.getLogger().atInfo().log(String.format("[Bletale] Bletale API has been loaded by a third party plugin (%s:%s)!", manifestGroup, manifestName));
        }
        return instance;
    }
}