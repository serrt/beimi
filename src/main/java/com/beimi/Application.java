package com.beimi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

import com.beimi.config.web.StartedEventListener;
import com.beimi.core.BMDataContext;


@EnableAutoConfiguration
@SpringBootApplication
@EnableAsync
@EnableJpaRepositories("com.beimi.web.service.repository")
public class Application {
    
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(Application.class) ;
		springApplication.addListeners(new StartedEventListener());
		BMDataContext.setApplicationContext(springApplication.run(args));
	}
	
}
