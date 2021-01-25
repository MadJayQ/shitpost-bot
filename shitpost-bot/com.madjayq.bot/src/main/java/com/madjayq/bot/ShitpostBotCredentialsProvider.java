package com.madjayq.bot;

import com.madjayq.discord.DiscordCredentialsProvider;

public class ShitpostBotCredentialsProvider implements DiscordCredentialsProvider {
	
	private final String DISCORD_API_TOKEN = "ODAzMDk3MDc3MTYzNzUzNTI0.YA40cA.G0bkrjM6fbl6aiKXPcN9F0zFm9M";
	
	@Override
	public String get() {
		return DISCORD_API_TOKEN;
	}

}
