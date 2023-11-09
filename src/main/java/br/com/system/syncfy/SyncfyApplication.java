package br.com.system.syncfy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.system.syncfy.infra.configuration.cors")
public class SyncfyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SyncfyApplication.class, args);
	}

}
