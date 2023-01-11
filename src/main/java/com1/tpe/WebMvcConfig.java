package com1.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc //Mvc ile calisacagimi belirtiyorum.
@ComponentScan("com1.tpe")
public class WebMvcConfig implements WebMvcConfigurer {

    //!!! viewResolver objemi bean olarak ekliyorum.
    //Bu kisim bizim fronent icin olusturulmus lan web-inf kismindaki views'lerimizi kullanabilmek icin olusturdugumuz kisim
    @Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/views/"); //Bu satirla view dosyalarimin nerede oldugunu göstermis oluyorum.
        resolver.setSuffix(".jsp"); //jsp uzantili dosyalari dikkate almasini söylüyorum.
        return resolver;
    }

    @Override
    //!!! kullanacagimiz kaynaklarin yerini gösteriyorum (css, images vs.)
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").
                addResourceLocations("/resources/").setCachePeriod(0);
    }
}
