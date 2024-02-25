package com.springdemoMVC.mvc;

import com.springdemoMVC.mvc.validation.CourseCode;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {

    private String firstName;
    @NotNull(message = "is required")
    @Size(min=1, message = "is required")
    private String lastName;
    @Min(value = 0 , message = "must be greater than or equal to 0")
    @Max(value = 10, message = "must be less than 10 or equal to 10")
    private int freePasses;
    @CourseCode
    //i can give the this rule my rules for exp. coursecode(value"tops",messsage"must start wtih tops")
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }

    public Customer(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
