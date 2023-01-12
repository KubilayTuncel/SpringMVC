package com1.tpe.repository;

import com1.tpe.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //Bu anatation özelesmis anatation'lardir ve import edildikleri class'ta Component anatation var.
public class StudentRepositoryImpl implements StudentRepository{

    @Autowired //DB katmaninda oldugum icin SesionFactory bagimliligimi enjekte ettim.
    private SessionFactory sessionFactory;

    @Override
    public List<Student> getAll() {
        Session session=sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        List<Student> listOfStudent =
                session.createQuery("from Student",Student.class).getResultList();

        tx.commit();
        session.close();
        return listOfStudent;
    }

    @Override
    public Optional<Student> findById(Long id) {
        Session session=sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class,id);
        Optional<Student> opt;
        opt = Optional.ofNullable(student); //Eger dönen deger null ise,
        //ici bos bir student objesi olusturup döndürür.

        tx.commit();
        session.close();
        return opt;
    }

    @Override
    public void save(Student student) {
        Session session=sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.saveOrUpdate(student); //Bu ögrenci varsa update eder, yoksa olusturur.

        tx.commit();
        session.close();

    }

    @Override
    public void update(Student student) {
        Session session=sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.update(student);

        tx.commit();
        session.close();

    }

    @Override
    public void delete(Long id) {
        Session session=sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Student student= session.load(Student.class,id);
        session.delete(student);

        tx.commit();
        session.close();

    }
}
