package com.advancedmapping.crud.demo.dao;

import com.advancedmapping.crud.demo.entity.Course;
import com.advancedmapping.crud.demo.entity.Instructor;
import com.advancedmapping.crud.demo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{
    private EntityManager entityManager;
    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class,theId);
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i JOIN FETCH i.courses JOIN FETCH i.instructorDetail where i.id= :data"
                                                                        , Instructor.class);
        query.setParameter("data",theId);
        //execute
        Instructor instructor = query.getSingleResult();
        return instructor;
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        Instructor instructor = entityManager.find(Instructor.class,theId);
        //get courses
        List<Course> tempCourse = instructor.getCourses();
        //delete courses
        for(Course course : tempCourse){
            course.setInstructor(null);
        }
        //we have to delete courses before the delete associated instructor!!!
        entityManager.remove(instructor);
    }

    @Override
    @Transactional
    public void deleteByInstructorDetailId(int theId) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class,theId);
        //remove the associated object reference
        //break bi-directional link
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class,theId);
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findByCourseId(int theId) {
        return entityManager.find(Course.class,theId);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {
        //retrieve the course
        Course tempCourse = entityManager.find(Course.class,theId);
        //delete the course
        entityManager.remove(tempCourse);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
        //create query
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id = :data", Course.class);
        query.setParameter("data",theId);

        //execute the query
        List<Course> courses = query.getResultList();
        return courses;
    }
    @Override
    @Transactional
    public void saveCourse(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int theId) {
        //create query
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c " +
                                                 "JOIN FETCH c.reviews where c.id = :data",Course.class);
        query.setParameter("data",theId);
        Course course = query.getSingleResult();
        return course;
    }

}
