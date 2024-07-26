package com.example.Course.Management;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example")
public class CourseApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CourseApp.class);
        CourseService courseService = (CourseService)context.getBean("courseService");
        courseService.start();
        
    }

}

