package com.example.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 开启缓存支持啊
 */
@EnableCaching
@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.example.async.entity")
//@EntityScan(basePackages = "com.example.async.entity")
public class AsyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyncApplication.class, args);
	}

}
