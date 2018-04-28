package com.dong.springcloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dong.springcloud.service.impl.UserServiceErrorImpl;

@FeignClient(value = "API-USER-SERVER", fallback = UserServiceErrorImpl.class)
public interface UserService {

	@GetMapping("/user/find/{id}")
	String find(@PathVariable(value = "id") String id);

}
