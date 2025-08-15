package com.playstation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PlaystationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaystationApplication.class, args);
	}

}
