package com.dong.springcloud.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
	
	public static final Logger logger = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		logger.info("info logback 成功了");
		logger.error("error logback 成功了");
		logger.debug("debug logback 成功了");
	}

}
