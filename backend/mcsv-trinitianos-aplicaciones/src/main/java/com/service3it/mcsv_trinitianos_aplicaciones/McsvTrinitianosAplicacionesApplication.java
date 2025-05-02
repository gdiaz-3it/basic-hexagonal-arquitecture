package com.service3it.mcsv_trinitianos_aplicaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class McsvTrinitianosAplicacionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(McsvTrinitianosAplicacionesApplication.class, args);
	}

}
