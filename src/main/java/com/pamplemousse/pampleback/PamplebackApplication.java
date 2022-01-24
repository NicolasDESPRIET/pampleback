package com.pamplemousse.pampleback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class PamplebackApplication {

	/**
	 * Application Launcher.
	 * @param args
	 */
	public static void main(final String[] args) {
		SpringApplication.run(PamplebackApplication.class, args);
	}

}
