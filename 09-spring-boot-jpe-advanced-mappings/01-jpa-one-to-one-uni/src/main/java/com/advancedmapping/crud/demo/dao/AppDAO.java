package com.advancedmapping.crud.demo.dao;

import com.advancedmapping.crud.demo.entity.Instructor;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById (int theId);
    void deleteById(int theId);
}
