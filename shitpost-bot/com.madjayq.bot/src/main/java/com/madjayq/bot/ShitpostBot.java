package com.madjayq.bot;

import org.slf4j.LoggerFactory;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.madjayq.discord.DiscordService;
import com.madjayq.pingpong.PingPong;

import org.slf4j.Logger;

public class ShitpostBot {
    public static Logger logger = LoggerFactory.getLogger(ShitpostBot.class);
    
    private final DiscordService discordService;
    
    @Inject
    public ShitpostBot(DiscordService discordService) {
    	this.discordService = discordService;
    }
    
    public void start() throws Exception {
    	discordService.start();
    }
    
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(ShitpostBotModuleProvider.modules());
        logger.info("Shitpost Bot 5000 coming online...");
        try {
        	injector.getInstance(ShitpostBot.class).start();
        	injector.getInstance(PingPong.class); //HACK for now, im tired
        } catch (Exception ex) {
        	logger.error(String.format("Entered Error State: %s", ex.getMessage()));
        }
    }

}
