package com.restApi.learningRest.rest;

import com.restApi.learningRest.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;
    @PostConstruct
    public void loadData(){
        theStudents=new ArrayList<>();
        theStudents.add(new Student("talha","meral"));
        theStudents.add(new Student("mehmet","meral"));
        theStudents.add(new Student("zehra","meral"));
    }
    //define endpoint for "/students" return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return  theStudents;
    }
    //define endpoint or "/students/{studentID{" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        //just index into the list... keep it simple for now
        //check the studentId againg list size
        if((studentId>=theStudents.size()) || (studentId<0)) {
            throw new StudentNotFoundException("student id not found - "+ studentId);
        }
       return theStudents.get(studentId);
    }

    //add an exception handler using @exceptionhandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        //create a studenterrorresponse
        StudentErrorResponse error= new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        //return response entity
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        //create a studenterrorresponse
        StudentErrorResponse error= new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        //return response entity
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);

    }
}
