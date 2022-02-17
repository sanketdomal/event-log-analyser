package com.example.loganalyser.demologanalyser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.loganalyser.demologanalyser.services.LogFileReader;

@SpringBootApplication
public class DemoLoganalyserApplication {
	
	@Autowired
	private LogFileReader logFileReader;

	public static void main(String[] args) {
		SpringApplication.run(DemoLoganalyserApplication.class, args);
		System.out.println("Event Log Analyser started...");
	}
	
	

	
}
