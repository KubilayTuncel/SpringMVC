package com1.tpe.controller;

import com1.tpe.domain.Student;
import com1.tpe.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller //http://127.0.0.1:8080/students
@RequestMapping("/students") //bu anatation bize yukaridaki endpoint kisminin bu class'a gelebilmesini saglamak icin yaziyoruz.
                            //students endpointi ile gelen requestler ile bu sinifa bakilacagini anlatiyorum.
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/hi") //students/hi
    public ModelAndView sayHi() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message","Merhaba");
        mav.addObject("messagebody","Ben bir Ögrenci Yönetim Sistemiyim.");
        mav.setViewName("hi"); //hi.jsp' yi gösteriyorum uzanti olarak
        return mav;
    }

    @GetMapping("/new")
    public String sendStudentForm(@ModelAttribute("student") Student student) {
        // @ModelAttribute = Model'e student isminde attribute ekledik.
        //amac burada springMVC'nin analayacagi sekle getirmek.
        return "studentForm"; //buradaki studentForm webapp deki studentFrom jsp kismina yönlendirme ve o sekilde gözükmesini sagliyoruz.
    }

    @PostMapping("/saveStudent") //students/saveStudent
    public String createStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);

        return "redirect:/students";
    }

    @GetMapping
    public ModelAndView getStudent(){
        List<Student> list = studentService.getAllStudent();
        ModelAndView mav = new ModelAndView(); //Burada olusturdugumuz mav model bilgisini setliyoruz
        mav.addObject("students",list);//bu kisimda list olarak springMVC'ye list'i model olarak ekliyoruz
        mav.setViewName("students"); // Bu kismda da nasil gözükmesi gerektigini yaziyoruz. Iceride yazdigimiz student
                                     //webapp kisminda js dosyalarinda student adi altinda kayitli.

        return mav;
    }

    //http://localhost:8080/springmvc/students/update?id=1
    @GetMapping("/update") //birden fazla parametre alcaksam @RequestParam kullaniyoruz
    public String showFormForUpdate(@RequestParam("id") Long id, Model model) {

        Student student = studentService.findByIdStudent(id);
        model.addAttribute(student);

        return "studentForm";
    }

    //http://localhost:8080/springmvc/students/delete/1
    @GetMapping("/delete/{id}") //tek parametre alcak isek @PathVariable kullaniyoruz.
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);

        return "redirect:/students";
    }

}
