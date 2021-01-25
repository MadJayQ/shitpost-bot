package com.madjayq.bot;

import java.util.Arrays;
import java.util.Collection;

import com.google.inject.AbstractModule;

public class ShitpostBotModuleProvider {
    
    public static Collection<AbstractModule> modules() {
        return Arrays.asList(new DiscordModule());
    }

}
