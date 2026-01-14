package com.bletzzi.bletale.core.command;

import com.bletzzi.bletale.api.command.CommandHandler;
import com.hypixel.hytale.server.core.command.system.AbstractCommand;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import javax.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;

public class NativeCommandHandler extends AbstractCommand {
    @Nonnull
    private final CommandHandler commandHandler;

    public NativeCommandHandler(@Nonnull final CommandHandler commandHandler) {
        super(commandHandler.name, commandHandler.description);
        this.commandHandler = commandHandler;
        if(!commandHandler.subcommands.isEmpty()) {
            commandHandler.subcommands.forEach(handler -> addSubCommand(new NativeCommandHandler(handler)));
        }
    }

    @NullableDecl
    @Override
    protected CompletableFuture<Void> execute(@NonNullDecl CommandContext nativeContext) {
        return CompletableFuture.runAsync(() -> {
            commandHandler.handle(new NativeCommandContext(nativeContext));
        });
    }
}