package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
			createMultipleStudent(studentDAO);

			//find by id
//			readStudent(studentDAO);

			//getAll
//			queryForStudents(studentDAO);

//			queryForStudentsByLastName(studentDAO);
			
//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);

//			deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all students.........");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Rows Deleted: "+ numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		System.out.println("Deleting student.....");
		studentDAO.delete(7);
	}

	private void updateStudent(StudentDAO studentDAO) {
		System.out.println("getting student.......");
		Student theStudent = studentDAO.findById(5);

		System.out.println("Update student");
		theStudent.setFirstName("john");

		studentDAO.update(theStudent);

		System.out.println("Updated: "+ theStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get list of students
		List<Student> theStudent = studentDAO.findByLastName("Do");

		// display list
		for(Student std: theStudent){
			System.out.println(std);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get list
		List<Student> theStudents = studentDAO.findAll();

		// display
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
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

		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);


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
