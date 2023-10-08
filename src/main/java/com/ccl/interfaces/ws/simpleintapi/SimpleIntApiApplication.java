package com.ccl.interfaces.ws.simpleintapi;

import com.ccl.architecture.logger.annotations.EnableRequestLogger;
import com.ccl.architecture.tracing.services.annotations.EnableTracing;
import com.ccl.architecture.utils.annotations.EnableUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import com.ccl.architecture.jdbc.EnableJdbcRepositories; 

import org.springframework.scheduling.annotation.EnableScheduling;

@EnableJdbcRepositories
@EnableScheduling
@EnableRequestLogger
@EnableTracing
@EnableUtils
@SpringBootApplication
public class SimpleIntApiApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(SimpleIntApiApplication.class, args);
	}
}