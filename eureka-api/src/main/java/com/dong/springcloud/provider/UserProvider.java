package com.dong.springcloud.provider;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserProvider {

	@GetMapping(value = "find/{id}")
	public String find(@PathVariable(name = "id") String id, HttpServletRequest request) {
		long startTime = System.currentTimeMillis();
		System.out.println("服务端端口： " + request.getLocalPort() + "  接受到请求......");

//		try {
//			Thread.sleep(500000);// 休眠5秒钟，测试网关超时
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		// 实际项目中，这里可以使用JSONObject，返回json字符串
		// 为了便于测试消费者app的负载均衡，返回服务端端口
		long endTime = System.currentTimeMillis();
		String s = String.format("参数是：“%s”，张三的服务端口是：%s，耗时%d毫秒", id, request.getLocalPort(), (endTime - startTime));
		System.out.println(s);
		return s;
	}

}
