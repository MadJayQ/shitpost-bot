package com.madjayq.bot;

import java.util.Arrays;
import java.util.Collection;

import com.google.inject.AbstractModule;
import com.madjayq.discord.DiscordModule;
import com.madjayq.pingpong.PingPongModule;

public class ShitpostBotModuleProvider {
    
    public static Collection<AbstractModule> modules() {
        return Arrays.asList(new ShitpostBotModule(),
        		new DiscordModule(),
        		new PingPongModule());
    }
}
