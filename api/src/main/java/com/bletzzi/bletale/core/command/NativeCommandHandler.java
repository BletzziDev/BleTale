package com.bletzzi.bletale.core.command;

import com.bletzzi.bletale.api.command.CommandHandler;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.CommandBase;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import javax.annotation.Nonnull;

public class NativeCommandHandler extends CommandBase {
    @Nonnull
    private final CommandHandler commandHandler;

    public NativeCommandHandler(@Nonnull final CommandHandler commandHandler) {
        super(commandHandler.name, commandHandler.description);
        this.commandHandler = commandHandler;
    }

    @Override
    protected void executeSync(@NonNullDecl CommandContext nativeContext) {
        commandHandler.handle(new NativeCommandContext(nativeContext));
    }
}