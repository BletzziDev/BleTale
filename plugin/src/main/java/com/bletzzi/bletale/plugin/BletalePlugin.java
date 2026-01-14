package com.bletzzi.bletale.plugin;

import com.bletzzi.bletale.Bletale;
import com.bletzzi.bletale.api.command.CommandHandler;
import com.bletzzi.bletale.api.command.Context;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public final class BletalePlugin extends JavaPlugin {
    public BletalePlugin(@NonNullDecl JavaPluginInit init) {
        super(init);
    }

    @Override
    protected void setup() {
        Bletale.getInstance(this);

        // TEST COMMAND
        Bletale.getInstance(this).registerCommandHandler(new TestCommand());
    }

    @Override
    protected void start() {

    }

    @Override
    protected void shutdown() {

    }

    public static class TestCommand extends CommandHandler {

        public TestCommand() {
            super("bletzzi", "Comando de teste do Bletale");
            addSubCommand(new TestSubCommand());
        }

        @Override
        public void handle(@NonNullDecl Context context) {
            context.sendMessage("Testando a API do Bletale! Bora biiiiilll!!!");
        }

        public static class TestSubCommand extends CommandHandler {

            public TestSubCommand() {
                super("developador", "Subcomando de teste do Blettale");
            }

            @Override
            public void handle(@NonNullDecl Context context) {
                context.sendMessage("Você está usando o subcomando da API do Bletale! Bora Fi do Biiiillll!!!");
            }
        }
    }
}