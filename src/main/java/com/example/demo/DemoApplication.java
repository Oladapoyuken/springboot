package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@RestController
@EnableScheduling

//Lesson 5. RestTemplates: Used to consume an API
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

    //this beans allows the use of the ConsumeWebService class to consume an API
    @Bean
    public RestTemplate getRestTemplate(){

        return new RestTemplate();
    }

    //Learn more about Core and fix this
//    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/view-product").allowedOrigins("http://localhost:9090");
            }
        };
    }

}


//Lesson 4: REST CONTROLLER
//public class DemoApplication{
//
//    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);
//    }
//}

//Lesson 1.  start a springboot app, convert and run the jar file as a live server
//public class DemoApplication {
//
//    public static void main(String[] args) {
//
//        SpringApplication.run(DemoApplication.class, args);
//    }
//
//    @RequestMapping(value = "/hello")
//    public String Hello(){
//        return "Hello World";
//    }

//}

//Lesson 2: extend a springboot servlet initializer to auto configure our app running in a servlet container
//public class DemoApplication extends SpringBootServletInitializer {
//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//                //original return fxn
//        //        return super.configure(application);
//
//        return application.sources(DemoApplication.class);
//    }
//
//    public static void main(String[] args) {
//
//        SpringApplication.run(DemoApplication.class, args);
//    }
//
//    @RequestMapping(value = "/hello")
//    public String Hello(){
//        return "Hello, this is from tomcat";
//    }
//
//}

//Lesson 3: Application runner and Command line Runner interfaces, used to run a code immediately the Springboot app is started
//public class DemoApplication implements ApplicationRunner {
//
//    public static void main(String[] args) {
//
//        SpringApplication.run(DemoApplication.class, args);
//    }
//
//    @RequestMapping(value = "/hello")
//    public String Hello(){
//        return "Hello, this is from tomcat";
//    }
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        System.out.println("Hello from application runner");
//    }
//}


