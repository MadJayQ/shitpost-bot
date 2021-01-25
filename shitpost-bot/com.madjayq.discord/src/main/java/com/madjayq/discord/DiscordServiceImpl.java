package com.madjayq.discord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Singleton
public class DiscordServiceImpl extends ListenerAdapter implements DiscordService {
	public static Logger logger = LoggerFactory.getLogger(DiscordServiceImpl.class);
	
	//TODO: This needs to be hidden somewhere lol
	private final String discordApiToken;
	private final DiscordEventListener discordEventListener;
	
	private JDA discordApi;
	    
    @Inject
    public DiscordServiceImpl(DiscordCredentialsProvider discordCredentialsProvider, 
    		DiscordEventListener discordEventListener) {
    	this.discordApiToken = discordCredentialsProvider.get();
    	this.discordEventListener = discordEventListener;
        logger.info("Discord Service Status: Pending...");
    }
    
    private PrivateChannel findUserPrivateChannel(long userId) {
    	return discordApi.getPrivateChannelCache().stream().filter(c -> c.getUser().getIdLong() == userId).findAny().orElse(null);
    }
    
    @Override
    public User getUser(long userId) {
    	return discordApi.getUserById(userId);
    }
    
    @Override
    public void sendMessage(long userId, String message) {
    	//Attempt to find an available private channel with this user
    	PrivateChannel channel = findUserPrivateChannel(userId);
    	if(channel == null) {
    		User user = getUser(userId);
    		if(user == null) {
    			logger.warn("Attempting to send message to unknown user {}", userId);
    			return;
    		}
    		user.openPrivateChannel().flatMap(newChannel -> newChannel.sendMessage(message)).queue();
    	}
    	channel.sendMessage(message).queue();
    }
    
    
    @Override
    public void start() throws Exception {
    	discordApi = JDABuilder.createDefault(discordApiToken)
    			.addEventListeners(discordEventListener)
    			.build();   
    	discordApi.awaitReady();
    	logger.info("Discord Server Status: OK");
    }
 }
