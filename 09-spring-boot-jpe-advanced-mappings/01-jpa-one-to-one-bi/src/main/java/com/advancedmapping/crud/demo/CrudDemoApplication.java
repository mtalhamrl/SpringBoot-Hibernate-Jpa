package com.advancedmapping.crud.demo;

import com.advancedmapping.crud.demo.dao.AppDAO;
import com.advancedmapping.crud.demo.entity.Instructor;
import com.advancedmapping.crud.demo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			//createInstructor (appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructionDetail(appDAO);
			deleteInstructorDetail(appDAO);
		};
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
