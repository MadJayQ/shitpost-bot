package com.madjayq.pingpong;

import com.google.inject.AbstractModule;

public class PingPongModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(PingPong.class);
	}
}
