package br.com.infnet.almoxarifadocli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AlmoxarifadoCliApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlmoxarifadoCliApplication.class, args);
	}
}