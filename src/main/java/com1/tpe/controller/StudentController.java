package com1.tpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //http://127.0.0.1:8080/students
@RequestMapping("/students") //bu anatation bize yukaridaki endpoint kisminin bu class'a gelebilmesini saglamak icin yaziyoruz.
                            //students endpointi ile gelen requestler ile bu sinifa bakilacagini anlatiyorum.
public class StudentController {

    @GetMapping("/hi") //students/hi
    public ModelAndView sayHi() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message","Merhaba");
        mav.addObject("messagebody","Ben bir Ögrenci Yönetim Sistemiyim.");
        mav.setViewName("hi"); //hi.jsp' yi gösteriyorum uzanti olarak
        return mav;
    }

}
