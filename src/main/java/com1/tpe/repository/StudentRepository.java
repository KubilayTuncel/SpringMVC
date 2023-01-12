package com1.tpe.repository;

import com1.tpe.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    List<Student> getAll();

    Optional<Student> findById(Long id); //optinal dedigimiz zaman,
    // bu kismda hatadan dolayi nullPointer Exp. gelebilir diye yazdik.

    void save(Student student);

    void update(Student student);

    void delete(Long id);
}
