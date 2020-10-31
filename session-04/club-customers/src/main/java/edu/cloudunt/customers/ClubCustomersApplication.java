package edu.cloudunt.customers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ClubCustomersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClubCustomersApplication.class, args);
	}

}
