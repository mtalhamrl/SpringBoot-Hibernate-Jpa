package com.advancedmapping.crud.demo;

import com.advancedmapping.crud.demo.dao.AppDAO;
import com.advancedmapping.crud.demo.entity.Course;
import com.advancedmapping.crud.demo.entity.Instructor;
import com.advancedmapping.crud.demo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			//createInstructor (appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructionDetail(appDAO);
			//deleteInstructorDetail(appDAO);
			//createInstructorWithCourse(appDAO);
			//findInstructorWithCourses(appDAO);
			//findCoursesForInstructor(appDAO);
			//findInstructorWithCoursesJoinFetch(appDAO);
			//updateInstructor(appDAO);
			//updateCourse(appDAO);
			deleteCourse(appDAO);

		};
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId=11;
		appDAO.deleteCourseById(theId);
	}

	private void updateCourse(AppDAO appDAO) {
		int theId=10;
		//find
		Course course = appDAO.findByCourseId(theId);
		//updaete
		course.setTitle("f1");
		appDAO.update(course);

	}

	private void updateInstructor(AppDAO appDAO) {
		int theId=1;
		//find instructor
		Instructor instructor = appDAO.findInstructorById(theId);
		//update
		instructor.setLastName("akbez");
		appDAO.update(instructor);
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId=1;
		//find the instructor
		System.out.println("find instructor id: "+ theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("temp instructor :" + tempInstructor);
		System.out.println("associated courses: "+ tempInstructor.getCourses());
		System.out.println("done");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("finding instructor id: "+ theId);
		Instructor tempInstructor= appDAO.findInstructorById(theId);
		System.out.println("instructor: "+ tempInstructor);
		//find courses for instructor
		System.out.println("finding courses for instructor id: "+ theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);
		tempInstructor.setCourses(courses);
		System.out.println("the associated courses: "+ tempInstructor.getCourses());
		System.out.println("done");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId=1;
		System.out.println("finding instructor id: "+ theId);
		Instructor tempInstructor= appDAO.findInstructorById(theId);
		System.out.println("instructor: "+ tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());
		System.out.println("done");
	}

	private void createInstructorWithCourse(AppDAO appDAO) {
		Instructor tempInstructor =
				new Instructor("ahmet","ambez","ambez@gmail.com");

		//create instructorDetail
		InstructorDetail tempInstructorDetail=
				new InstructorDetail("youtube.com/ambbbezz","rocking");

		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course tempCourse1 = new Course("math");
		Course tempCourse2 = new Course("football");
		//add course to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		//save the instructor
		System.out.println("savinggg" + tempInstructor);
		System.out.println("the course: "+ tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("doneee");

	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId=1;
		System.out.println("deleting id= " + theId);
		appDAO.deleteByInstructorDetailId(theId);
		System.out.println("done");
	}

	private void findInstructionDetail(AppDAO appDAO) {
		//get the in.detail object
		int theId=3;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(theId);

		System.out.println("instruction detail: "+ instructorDetail);

		System.out.println("associtaed instructor: "+ instructorDetail.getInstructor());

		System.out.println("done");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId=3;
		System.out.println("deleting instructor id: " + theId);
		appDAO.deleteById(theId);
		System.out.println("done");
	}

	/* private void findInstructor(AppDAO appDAO) {
		int theId=3;
		System.out.println("finding instructor id " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("temp instructor: "+ tempInstructor);
		System.out.println("the only instructor detail : " + tempInstructor.getInstructorDetail());

	} */

	/* private void createInstructor(AppDAO appDAO) {


		Instructor tempInstructor =
				new Instructor("ahmet","ambez","ambez@gmail.com");

		//create instructorDetail
		InstructorDetail tempInstructorDetail=
				new InstructorDetail("youtube.com/ambbbezz","rocking");

		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		System.out.println("saving instructor" + tempInstructor);
		appDAO.save(tempInstructor);
		//note it will also save instructor detail too because of cascade.all :)
		System.out.println("done");
}*/
}
