package com.guoyicap.micro.route.zuul.fallback;

public class HelloRemoteHystrix implements HelloRemote{

	@Override
	public String hello() {
		// TODO Auto-generated method stub
		return "hello--gg";
	}

}
