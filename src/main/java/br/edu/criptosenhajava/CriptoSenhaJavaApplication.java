package br.edu.criptosenhajava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class CriptoSenhaJavaApplication {

	public static void main(String[] args) { SpringApplication.run(CriptoSenhaJavaApplication.class, args); }

	@Bean
	public PasswordEncoder getPasswordEnconder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}
