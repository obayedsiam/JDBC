package com.dshe.nongovt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
@EnableFeignClients
public class DsheNonGovtServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsheNonGovtServiceApplication.class, args);
	}

}
