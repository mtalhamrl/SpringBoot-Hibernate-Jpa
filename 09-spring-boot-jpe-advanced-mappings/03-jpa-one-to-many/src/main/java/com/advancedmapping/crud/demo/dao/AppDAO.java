package com.advancedmapping.crud.demo.dao;

import com.advancedmapping.crud.demo.entity.Course;
import com.advancedmapping.crud.demo.entity.Instructor;
import com.advancedmapping.crud.demo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById (int theId);
    Instructor findInstructorByIdJoinFetch(int theId);
    void deleteById(int theId);
    void deleteByInstructorDetailId(int theId);
    InstructorDetail findInstructorDetailById(int theId);
    void update(Instructor instructor);
    void update(Course course);
    Course findByCourseId(int theId);
    void deleteCourseById(int theId);

    List<Course> findCoursesByInstructorId(int theId);
}
