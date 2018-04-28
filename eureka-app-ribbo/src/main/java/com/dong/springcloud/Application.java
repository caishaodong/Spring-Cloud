package com.dong.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@SpringBootApplication
@EnableEurekaClient
public class Application {

	@Bean // 定义REST客户端，RestTemplate实例
	@LoadBalanced // 开启负载均衡的能力
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	/*
	 * 这里是设置Ribbon遵循的负载均衡规则
	 */
	@Bean
	public IRule ribbonRule() {
		System.out.println("------->> ribbonRule in <<--------");
		return new RandomRule();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
