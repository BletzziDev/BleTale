package com.bletzzi.bletale.core.command;

import com.bletzzi.bletale.api.command.Context;
import com.bletzzi.bletale.api.wrapper.command.WrappedCommandSender;
import com.bletzzi.bletale.api.wrapper.entity.WrappedPlayer;
import com.bletzzi.bletale.core.entity.NativePlayer;
import com.bletzzi.bletale.core.server.ServerUtil;
import com.bletzzi.bletale.core.wrapper.command.NativeCommandSender;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.entity.entities.Player;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class NativeCommandContext implements Context {

    @Nonnull
    private final CommandContext nativeContext;

    protected NativeCommandContext(@Nonnull final CommandContext nativeContext) {
        this.nativeContext = nativeContext;
    }

    @Nonnull
    @Override
    public WrappedCommandSender getSender() {
        return new NativeCommandSender(this.nativeContext.sender());
    }

    @Nullable
    @Override
    public WrappedPlayer getSenderAsPlayer() {
        return new NativePlayer((Player) this.nativeContext.sender());
    }

    @Override
    public void sendMessage(@Nonnull String message) {
        this.sendMessage(ServerUtil.parseMessage(message));
    }

    @Override
    public void sendMessage(@Nonnull Message message) {
        this.nativeContext.sendMessage(message);
    }
}