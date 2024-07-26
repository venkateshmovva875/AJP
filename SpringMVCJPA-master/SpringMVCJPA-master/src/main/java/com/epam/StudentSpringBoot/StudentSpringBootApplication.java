package com.epam.StudentSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentSpringBootApplication {

	public static void main(String[] args) {
		// ApplicationContext context =
		SpringApplication.run(StudentSpringBootApplication.class, args);
		// StudentService studentService = context.getBean(StudentService.class);
		// studentService.menu();
	}

	/*
	 * @Override public void run(String... args) throws Exception { // TODO
	 * Auto-generated method stub getStudentService().menu();
	 * 
	 * }
	 * 
	 * @Bean
	 * 
	 * @Autowired public StudentService getStudentService() { return new
	 * StudentService(); }
	 * 
	 * @Bean
	 * 
	 * @Autowired public StudentDaoImpl getStudentDaoImpl() { return new
	 * StudentDaoImpl(); }
	 */

}
