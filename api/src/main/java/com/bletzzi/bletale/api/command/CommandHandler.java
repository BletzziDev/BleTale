package com.bletzzi.bletale.api.command;

import javax.annotation.Nonnull;

public abstract class CommandHandler {
    @Nonnull
    public final String name;
    @Nonnull
    public final String description;

    public CommandHandler(@Nonnull final String name, @Nonnull final String description) {
        this.name = name;
        this.description = description;
    }

    public abstract void handle(@Nonnull final Context context);
}