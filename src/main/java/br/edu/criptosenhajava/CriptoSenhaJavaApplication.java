package br.edu.criptosenhajava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)//digo para ele não executar essa classe do spring security
public class CriptoSenhaJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CriptoSenhaJavaApplication.class, args);
	}

}
