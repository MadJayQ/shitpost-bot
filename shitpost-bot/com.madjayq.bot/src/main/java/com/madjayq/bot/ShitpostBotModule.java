package com.madjayq.bot;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.madjayq.discord.DiscordCredentialsProvider;

public class ShitpostBotModule extends AbstractModule {

	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		bind(ShitpostBot.class);
		bind(EventBus.class).toInstance(new EventBus());
		
		bind(DiscordCredentialsProvider.class).to(ShitpostBotCredentialsProvider.class);
	}

}
