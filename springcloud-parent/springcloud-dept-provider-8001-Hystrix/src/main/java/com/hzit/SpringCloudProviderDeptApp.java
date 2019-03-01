package com.hzit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@MapperScan("com.hzit.mapper")
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker // 服务熔断
@EnableHystrix
@EnableHystrixDashboard
public class SpringCloudProviderDeptApp {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringCloudProviderDeptApp.class, args);
	}

}
