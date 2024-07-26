package com.gfg.Spring.boot.app;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import Model.company;

@SpringBootApplication
@ComponentScan({"com.gfg.Spring.boot.app","Model"})
public class MyspringApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MyspringApplication.class, args);
		 company c = context.getBean(company.class);
		 c.setId(intBean());
		 c.setNameString(StringBean());
		 System.out.println(c.getId());
		 System.out.println(c.getNameString());
		 c.show();
	}
	@Bean
    public static int intBean() {
        return 0;
    }
	@Bean
    public static String StringBean() {
        return "saipavan";
    }
 
}
