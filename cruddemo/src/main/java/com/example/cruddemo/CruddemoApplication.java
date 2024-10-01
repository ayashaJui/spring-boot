package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

//	command line runner
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return args -> {
//			createStudent(studentDAO);

			//create multiple student
//			createMultipleStudent(studentDAO);

			//find by id
			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {
		// create student object
		System.out.println("Creating new student...");
		Student tempStudent = new Student("Jane", "Doe", "jane@gmail.com");

		// save the student
		System.out.println("Saving the student...");
//		studentDAO.save(tempStudent);

		// display id of student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// retrieve student based on id
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found student: " + myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student.....");
		Student tempStudent1 = new Student("Jane", "Doe", "jane@gmail.com");
		Student tempStudent2 = new Student("James", "Doe", "james@gmail.com");
		Student tempStudent3 = new Student("Paul", "Doe", "paul@gmail.com");

		// save the object
		System.out.println("Saving the student.....");

//		studentDAO.save(tempStudent1);
//		studentDAO.save(tempStudent2);
//		studentDAO.save(tempStudent3);


	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student.....");
		Student tempStudent = new Student("John", "Doe", "john@gmail.com");

		// save the object
		System.out.println("Saving the student.....");
		studentDAO.save(tempStudent);

		// display id of save student
		System.out.println("Saved Student. Generated ID: "+ tempStudent.getId());
	}

}
