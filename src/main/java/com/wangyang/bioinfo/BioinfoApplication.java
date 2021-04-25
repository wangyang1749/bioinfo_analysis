package com.wangyang.bioinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BioinfoApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.additional-location","file:${user.home}/.bioinfo/application.yml");
		SpringApplication.run(BioinfoApplication.class, args);
	}

}
