package com.madjayq.discord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Singleton;

@Singleton
public class DiscordServiceImpl implements DiscordService {
    public static Logger logger = LoggerFactory.getLogger(DiscordServiceImpl.class);
    
    public DiscordServiceImpl() {
        logger.info("Starting Discord Service...");
    }
}
