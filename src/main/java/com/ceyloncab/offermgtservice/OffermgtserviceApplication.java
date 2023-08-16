package com.ceyloncab.offermgtservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class OffermgtserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OffermgtserviceApplication.class, args);
	}

}
