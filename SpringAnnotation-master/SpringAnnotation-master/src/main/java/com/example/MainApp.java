package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@ComponentScan("com.example")
public class MainApp {
    public static void main(String[] args) {
        // Load the Spring context
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainApp.class);

        // Retrieve the bean from the Spring context
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");

        employeeService.runMenu();
    }
}

