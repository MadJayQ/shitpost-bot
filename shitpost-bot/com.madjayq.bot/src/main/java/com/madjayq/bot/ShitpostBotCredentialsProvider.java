package com.madjayq.bot;

import com.madjayq.discord.DiscordCredentialsProvider;

public class ShitpostBotCredentialsProvider implements DiscordCredentialsProvider {
	
	private final String DISCORD_API_TOKEN = "ODAzMDk3MDc3MTYzNzUzNTI0.YA40cA.Tlxi8jvzQjtLJXc8njy7SRtb_8Q";
	
	@Override
	public String get() {
		return DISCORD_API_TOKEN;
	}

}
