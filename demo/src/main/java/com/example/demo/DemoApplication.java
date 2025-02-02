package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class DemoApplication {

	@RequestMapping(value = "/hello",method= RequestMethod.GET)
	public String Hello(){
		return "Welcome the Application";
	}

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

}
