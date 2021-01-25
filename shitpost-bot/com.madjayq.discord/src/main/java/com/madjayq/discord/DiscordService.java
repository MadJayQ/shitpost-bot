package com.madjayq.discord;

import net.dv8tion.jda.api.entities.User;

public interface DiscordService {
	public void start() throws Exception;
	
	public void sendMessage(long userId, String message);
	
	public User getUser(long userId);
}
