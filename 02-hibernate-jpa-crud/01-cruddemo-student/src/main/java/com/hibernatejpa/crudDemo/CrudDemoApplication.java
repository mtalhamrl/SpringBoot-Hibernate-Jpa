package com.hibernatejpa.crudDemo;

import com.hibernatejpa.crudDemo.dao.StudentDao;
import com.hibernatejpa.crudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {
			deleteAllStudent(studentDao);
			// deleteStudent(studentDao);
			// updateStudent(studentDao);
			// queryForStudentsByLastName(studentDao);
			//queryForStudents(studentDao);
			//readStudent(studentDao);
			// createMultipleStudent(studentDao);
			//createStudent(studentDao);
		};
	}

	private void deleteAllStudent(StudentDao studentDao) {
		System.out.println("deleting all students");
		int numRowsDeleted=studentDao.deleteAll();
		System.out.println("deleted row count: "+ numRowsDeleted);
	}

	private void deleteStudent(StudentDao studentDao) {
		int studentId=3;
		System.out.println("deleting student id: "+ studentId);
		studentDao.delete(studentId);
	}

	private void updateStudent(StudentDao studentDao) {
		//retriev student based on the id: primary key
		int studentID=1;
		System.out.println("getting student with id: " + studentID);
		Student myStudent=studentDao.findById(studentID);
		//change first name to whatever i want
		System.out.println("updating student...");
		myStudent.setFirst_name("Talha");
		//update the student
		studentDao.update(myStudent);
		//display the updated student
		System.out.println("updated student: "+ myStudent);
	}

	private void queryForStudentsByLastName(StudentDao studentDao) {
		//get a list of students
		List<Student> theStudents = studentDao.findByLastName("meral");
		//display list of students
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDao studentDao) {
		// get a list of students
		List<Student> theStudents= studentDao.findAll();
		//display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDao studentDao) {
		// create a student object
		System.out.println("creating new student object...");
		Student tempStudent=new Student("mehmet","meral","mtm@gmail.com");
		//save the student
		System.out.println("Saving the student...");
		studentDao.save(tempStudent);
		//display id of the saved student
		int theID=tempStudent.getId();
		System.out.println("saved student. generated id: "+ theID);
		// retrieve stuent based on the id: primary key
		System.out.println("retrieving student with id: "+ theID);
		Student myStudent=studentDao.findById(theID);
		//display student
		System.out.println("found the student: "+ myStudent);

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
