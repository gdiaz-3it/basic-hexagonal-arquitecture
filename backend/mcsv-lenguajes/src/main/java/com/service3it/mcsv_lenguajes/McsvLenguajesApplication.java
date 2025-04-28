package com.service3it.mcsv_lenguajes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class McsvLenguajesApplication {

	public static void main(String[] args) {
		SpringApplication.run(McsvLenguajesApplication.class, args);
	}

}
