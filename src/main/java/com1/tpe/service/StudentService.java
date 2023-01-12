package com1.tpe.service;

import com1.tpe.domain.Student;

import java.util.List;


public interface StudentService {
    List<Student> getAllStudent();

    Student findByIdStudent(Long id);

    void saveStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(Long id);
}
