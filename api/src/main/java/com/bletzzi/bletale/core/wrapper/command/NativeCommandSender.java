package com.bletzzi.bletale.core.wrapper.command;

import com.bletzzi.bletale.api.wrapper.command.WrappedCommandSender;
import com.bletzzi.bletale.core.server.ServerUtil;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandSender;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import javax.annotation.Nonnull;

public class NativeCommandSender implements WrappedCommandSender {
    @Nonnull
    private final CommandSender nativeSender;

    public NativeCommandSender(@Nonnull CommandSender nativeSender) {
        this.nativeSender = nativeSender;
    }

    @Override
    public void sendMessage(@NonNullDecl String message) {
        this.sendMessage(ServerUtil.parseMessage(message));
    }

    @Override
    public void sendMessage(@NonNullDecl Message message) {
        this.nativeSender.sendMessage(message);
    }
}