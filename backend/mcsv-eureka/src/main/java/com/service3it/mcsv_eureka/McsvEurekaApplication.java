package com.service3it.mcsv_eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class McsvEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(McsvEurekaApplication.class, args);
	}

}
