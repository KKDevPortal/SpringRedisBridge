package com.kkdevprotal.SpringRedisBridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringRedisBridgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRedisBridgeApplication.class, args);
	}

}
