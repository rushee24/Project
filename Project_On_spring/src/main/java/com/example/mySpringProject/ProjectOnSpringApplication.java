package com.example.mySpringProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class ProjectOnSpringApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectOnSpringApplication.class, args);
		System.out.println("sdfghj");
		
	}
  /*   @RequestMapping("/first")
      public String helloString()
	  {
		return "Hello ";
	  }*/
}
