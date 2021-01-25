package com.madjayq.pingpong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

@Singleton
public class PingPong {
	private static Logger logger = LoggerFactory.getLogger(PingPong.class);
	
	@Inject
	public PingPong(EventBus eventBus) {
		eventBus.register(this);
		logger.info("Ping Pong Module Loaded");
	}
	
	@Subscribe
	public void discordMessageReceived(MessageReceivedEvent event) {
		if(event.getAuthor().isBot()) {
			return;
		}
		if(event.getMessage().getContentRaw().equalsIgnoreCase("!ping")) {	
			event.getChannel().sendMessage("Pong!").queue();
		}
	}
}
