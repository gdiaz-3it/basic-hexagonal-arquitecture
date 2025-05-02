package com.service3it.mcsv_tritianos_aplicaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class McsvTritianosAplicacionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(McsvTritianosAplicacionesApplication.class, args);
	}

}
