package com.guoyicap.micro.route.zuul.fallback;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="micro-user",fallback = HelloRemoteHystrix.class)
public interface HelloRemote {
	@RequestMapping("/hello")
	public String hello();
}
