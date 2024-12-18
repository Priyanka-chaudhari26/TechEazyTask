package com.example.assignment.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    private String name;
    private String address;

    
    @ManyToMany
    @JoinTable(
        name = "student_subject", 
        joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "subject_id") 
    )
    private Set<Subject> subjects = new HashSet<>(); 

    
    public Student() {}

    public Student(String name, String address) {
        this.name = name;
        this.address = address;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

   
    public void addSubject(Subject subject) {
        this.subjects.add(subject);
        subject.getStudents().add(this); 
    }

    
    public void removeSubject(Subject subject) {
        this.subjects.remove(subject);
        subject.getStudents().remove(this); 
    }

    
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
