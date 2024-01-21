package com.hibernatejpa.crudDemo;

import com.hibernatejpa.crudDemo.dao.StudentDao;
import com.hibernatejpa.crudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {
			createMultipleStudent(studentDao);
			//createStudent(studentDao);
		};
	}
	private void createMultipleStudent(StudentDao studentDao){
		//create objects
		System.out.println("creating new students object...");
		Student tempStudent= new Student("ekrem","kamiloglu","eko@gmaik.com");
		Student tempStudent1= new Student("bugra","kesk","macit@gmaik.com");
		Student tempStudent2= new Student("bera","acar","acar@gmaik.com");
		// save objects
		System.out.println("saving the students...");
		studentDao.save(tempStudent);
		studentDao.save(tempStudent1);
		studentDao.save(tempStudent2);

	}
	private void createStudent(StudentDao studentDao) {
		//create the student object
		System.out.println("creating new student object...");
		Student tempStudent= new Student("ekrem","kamiloglu","eko@gmaik.com");
		//save the student object
		System.out.println("saving the student...");
		studentDao.save(tempStudent);

		//display id of the saved student
		System.out.println("saved student. Generated id: "+ tempStudent.getId());
	}
}
