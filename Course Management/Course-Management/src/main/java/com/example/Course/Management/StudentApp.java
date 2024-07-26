package com.example.Course.Management;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example")
public class StudentApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StudentApp.class);
        StudentService studentService = (StudentService)context.getBean("studentService");
        studentService.start();
    }

}
