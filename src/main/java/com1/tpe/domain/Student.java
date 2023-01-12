package com1.tpe.domain;

import org.hibernate.type.LocalDateTimeType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name="t_student")
public class Student {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Isim kismi bos birakilamaz")
    private String firstName;

    @NotEmpty(message = "Soy-Isim kismi bos birakilamaz")
    private String lastName;

    @NotNull(message = "Lütfen puan bilgisini giriniz")
    private Integer grade; //wrapper (Integer) olarak yaziyoruz ki icerigi default olarak 0 degil de
                           //null olarak doldursun. Sonra ekleme isleminiyapabiliriz. o yüzden int sekilde yazmadik

    private LocalDateTime createDate = LocalDateTime.now();

    public Long getId() {
        return id;
    }

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

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getGrade() {
        return grade;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", grade=" + grade +
                ", createDate=" + createDate +
                '}';
    }
}
