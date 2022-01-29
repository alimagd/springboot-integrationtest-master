package com.example.springboottest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springboottest.model.Student;

@Component
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<Student> createStudent() {
        List<Student> students = new ArrayList<>();
        List<Student> savedStudents = new ArrayList<>();
        
        students.add(new Student("Ali Joon", "Desc for st111"));
        students.add(new Student("Fatti Magd", "Desc 4 st656"));
        students.add(new Student("Hamid Bro", "Dsc 4 ST0989"));
        Iterable<Student> itrStudents=repository.saveAll(students);
        itrStudents.forEach(savedStudents::add);

        return savedStudents;
    }

    public Student retrieveStudent(Integer studentId) {
       return repository.findById(studentId).orElse(new Student());
  
    }
 
}
