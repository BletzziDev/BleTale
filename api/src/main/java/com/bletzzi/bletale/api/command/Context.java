package com.bletzzi.bletale.api.command;

import com.bletzzi.bletale.api.wrapper.command.WrappedCommandSender;
import com.bletzzi.bletale.api.wrapper.entity.WrappedPlayer;
import com.hypixel.hytale.server.core.Message;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface Context {
    @Nonnull
    WrappedCommandSender getSender();

    @Nullable
    WrappedPlayer getSenderAsPlayer();

    void sendMessage(@Nonnull String message);

    void sendMessage(@Nonnull Message message);
}