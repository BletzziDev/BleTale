package com.bletzzi.bletale.api.wrapper.receiver;

import com.hypixel.hytale.server.core.Message;

import javax.annotation.Nonnull;

public interface MessageReceiver {
    void sendMessage(@Nonnull String message);
    void sendMessage(@Nonnull Message message);
}