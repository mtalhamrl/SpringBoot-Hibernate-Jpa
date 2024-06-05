package com.advancedmapping.crud.demo.dao;

import com.advancedmapping.crud.demo.entity.Instructor;
import com.advancedmapping.crud.demo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    @Transactional
    public void deleteById(int theId) {
        Instructor instructor = entityManager.find(Instructor.class,theId);
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


}
