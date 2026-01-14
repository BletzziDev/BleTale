package com.bletzzi.bletale.core.entity;

import com.bletzzi.bletale.api.wrapper.command.WrappedCommandSender;
import com.bletzzi.bletale.api.wrapper.entity.WrappedPlayer;
import com.bletzzi.bletale.core.server.ServerUtil;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.entity.entities.Player;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import javax.annotation.Nonnull;

public class NativePlayer implements WrappedPlayer {
    @Nonnull
    private final Player nativePlayer;

    public NativePlayer(@Nonnull Player nativePlayer) {
        this.nativePlayer = nativePlayer;
    }

    @Override
    public void sendMessage(@NonNullDecl String message) {
        this.sendMessage(ServerUtil.parseMessage(message));
    }

    @Override
    public void sendMessage(@NonNullDecl Message message) {
        this.nativePlayer.sendMessage(message);
    }
}