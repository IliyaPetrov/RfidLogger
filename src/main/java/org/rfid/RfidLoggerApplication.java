package org.rfid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RfidLoggerApplication {
	public static void main(String[] args) {
		WaitForService.ping();
		SpringApplication.run(RfidLoggerApplication.class, args);
	}
}