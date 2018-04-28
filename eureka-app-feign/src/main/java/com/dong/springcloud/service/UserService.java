package com.dong.springcloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("API-USER-SERVER")
public interface UserService {

	@GetMapping("/user/find/{id}")
	String find(@PathVariable(value = "id") String id);
	
	
	/*
	 * 容错处理类，当调用失败时，简单返回空字符串
	 */
	@Component
	public class DefaultFallback implements UserService {
		@Override
		public String find(String id) {
			return "fault";
		}
	}

}
