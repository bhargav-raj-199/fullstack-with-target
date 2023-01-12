package com.acheron.mobile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author BhargavRajJinka
 *
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class MobilestoreConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobilestoreConfigServerApplication.class, args);
	}

}
