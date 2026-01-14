package com.bletzzi.bletale.api.command;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public abstract class CommandHandler {
    public final String name;
    @Nonnull
    public final String description;

    public final List<CommandHandler> subcommands = new ArrayList<>();

    public CommandHandler(final String name, @Nonnull final String description) {
        this.name = name;
        this.description = description;
    }

    public void addSubCommand(@Nonnull final CommandHandler handler) {
        this.subcommands.add(handler);
    }

    public abstract void handle(@Nonnull final Context context);
}