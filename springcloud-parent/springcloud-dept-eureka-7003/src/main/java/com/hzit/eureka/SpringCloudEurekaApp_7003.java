package com.hzit.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurekaApp_7003 {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringCloudEurekaApp_7003.class, args);
	}

}
