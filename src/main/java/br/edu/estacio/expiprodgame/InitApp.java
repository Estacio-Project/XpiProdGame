package br.edu.estacio.expiprodgame;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@SpringBootApplication
/*@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})*/
/*@EntityScan(basePackages = { "br.edu.estacio.expiprodgame.bean" })
@EnableJpaRepositories(basePackages = { "br.edu.estacio.expiprodgame.repository" })
@ComponentScan(basePackages = {"br.edu.estacio.expiprodgame.controller"})
*/public class InitApp {

	public static void main(String[] args) {
		SpringApplication.run(InitApp.class, args);
	}
	
	
	@Bean
	public FixedLocaleResolver localeResolver(){
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}
}
