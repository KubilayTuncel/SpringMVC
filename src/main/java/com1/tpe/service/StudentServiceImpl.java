package com1.tpe.service;

import com1.tpe.domain.Student;
import com1.tpe.exception.ResourceNotFoundException;
import com1.tpe.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service //Bu anatation özellesmis anatation'lardir ve import edildikleri class'ta Component anatation var.
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository repository;

    @Override
    public List<Student> getAllStudent() {
        return repository.getAll();
    }

    @Override
    public Student findByIdStudent(Long id) {
        //nullPointerExp. kurtarmak icin
        // bi önceki class'ta Optinal class'ini kullandik. Bu yzden burada cte verdi. bundan da kurtarmak icin
        //orElseThrow methodunun kullandik Optinal class'indan. Daha sonrasinda kendi olusturdugumuz exception class'i ile
        //kullaniciya istedigimiz mesaji gönderebilmis olduk.
        Student student = repository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Bu "+ id +"'li Student objesi bulunamadi."));
        return student;
    }

    @Override
    public void saveStudent(Student student) {
        repository.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        repository.update(student);
    }

    @Override
    public void deleteStudent(Long id) {
        repository.delete(id);
    }
}
