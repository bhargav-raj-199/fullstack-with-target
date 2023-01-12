package com.acheron.mobile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MobilestoreEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobilestoreEurekaServerApplication.class, args);
	}

}
