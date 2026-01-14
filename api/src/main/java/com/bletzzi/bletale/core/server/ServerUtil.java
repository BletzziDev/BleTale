package com.bletzzi.bletale.core.server;

import com.hypixel.hytale.server.core.Message;

import javax.annotation.Nonnull;

public class ServerUtil {
    private ServerUtil() {}

    @Nonnull
    public static Message parseMessage(@Nonnull String message) {
        return Message.raw(message);
    }
}