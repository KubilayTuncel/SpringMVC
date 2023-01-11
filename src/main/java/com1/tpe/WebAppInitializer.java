package com1.tpe;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//!!! web.xml yerine bu sinifimizi kullanacagiz.
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    //Database ve hibernate ayarlarim icin kullancagim.
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                RootContextConfig.class
        };
    }

    @Override
    //MVC config ayarlarim icin kullanacagim
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                WebMvcConfig.class
        };
    }

    @Override
    //Hangi url hangi servlet a iliskilendirilecek, onu ayarliyoruz.
    protected String[] getServletMappings() {
        return new String[]{"/"}; //gelen bütün request leri bu servlet tarafından karşılanacağını söylüyorum
    }
}
