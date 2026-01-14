package com.bletzzi.bletale;

import com.hypixel.hytale.server.core.plugin.JavaPlugin;

import javax.annotation.Nonnull;

public final class Bletale {
    private static Bletale instance;

    @Nonnull
    private final JavaPlugin plugin;

    private Bletale(@Nonnull final JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public static Bletale getInstance(@Nonnull final JavaPlugin plugin) {
        if(instance == null) instance = new Bletale(plugin);
        return instance;
    }
}