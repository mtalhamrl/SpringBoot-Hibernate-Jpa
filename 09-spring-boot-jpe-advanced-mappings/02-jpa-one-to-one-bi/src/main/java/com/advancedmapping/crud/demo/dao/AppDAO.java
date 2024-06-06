package com.advancedmapping.crud.demo.dao;

import com.advancedmapping.crud.demo.entity.Instructor;
import com.advancedmapping.crud.demo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById (int theId);
    void deleteById(int theId);
    void deleteByInstructorDetailId(int theId);
    InstructorDetail findInstructorDetailById(int theId);
}
