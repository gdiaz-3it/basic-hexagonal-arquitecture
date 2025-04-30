package com.service3it.mcsv_tinitianos_lenguajes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class McsvTinitianosLenguajesApplication {

	public static void main(String[] args) {
		SpringApplication.run(McsvTinitianosLenguajesApplication.class, args);
	}

}
