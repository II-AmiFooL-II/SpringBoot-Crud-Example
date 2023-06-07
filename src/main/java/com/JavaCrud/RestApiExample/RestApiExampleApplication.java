package com.JavaCrud.RestApiExample;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class RestApiExampleApplication {
	//private static final Logger LOGGER=LoggerFactory.getLogger(RestApiExampleApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(RestApiExampleApplication.class, args);
		//LOGGER.info("Simple log statement with inputs {}, {} and {}", 1,2,3);
		log.info("testing logging with lombok");
	}

}
