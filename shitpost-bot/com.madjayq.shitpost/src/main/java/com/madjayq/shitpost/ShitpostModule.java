package com.madjayq.shitpost;

import com.google.inject.AbstractModule;

public class ShitpostModule extends AbstractModule {
    @Override
    public void configure() {
        bind(ShitpostClassificationService.class).to(ShitpostClassificationServiceImpl.class);
    }

}
