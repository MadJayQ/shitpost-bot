package com.madjayq.discord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public final class DiscordEventListener extends ListenerAdapter {
	
	private static Logger logger = LoggerFactory.getLogger(DiscordEventListener.class);
	
	private final EventBus eventBus;
	
	@Inject
	public DiscordEventListener(EventBus eventBus) {
		this.eventBus = eventBus;
	}
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		logger.info("Message received from {}", event.getAuthor().getName());
		eventBus.post(event);
	}
}
