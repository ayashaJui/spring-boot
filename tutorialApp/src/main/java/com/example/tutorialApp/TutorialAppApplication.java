package com.example.tutorialApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//for packages outside main
//@SpringBootApplication(
//		scanBasePackages = {"com.example.tutorialApp",
//							"com.example.util"})

@SpringBootApplication
public class TutorialAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(TutorialAppApplication.class, args);
	}

}
