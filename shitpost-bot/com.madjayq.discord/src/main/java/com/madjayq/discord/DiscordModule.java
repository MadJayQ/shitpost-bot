package com.madjayq.discord;

import com.google.inject.AbstractModule;

public class DiscordModule extends AbstractModule {
    @Override
    protected void configure() {
        // TODO Auto-generated method stub
        bind(DiscordService.class).to(DiscordServiceImpl.class);
    }

}
