package com.example.example.student;

// This class represents a table in database
// Entity refers to a Java object that is meant to be persisted in a relational database.

import com.example.example.school.School;
import com.example.example.studentprofile.StudentProfile;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Students")
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "FirstName")
    private String fname;

    @Column(name = "LastName")
    private String lname;

    @Column(unique = true) // email will be unique
    private String email;

    private Integer age;

    @OneToOne(mappedBy = "student", cascade =  CascadeType.ALL)
    private StudentProfile studentProfile;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "school_id")
    @JsonBackReference
    private School school;


    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    // If you want to convert a Java class into an entity , we need a default  constructor with no args
    public Student() {
    }

    public Student(String fname, String lname, String email, Integer age) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.age = age;
    }

    public Integer getId(int i) {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
