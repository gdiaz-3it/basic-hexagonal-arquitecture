package com.service3it.mscv_tritianos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MscvTritianosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscvTritianosApplication.class, args);
	}

}
