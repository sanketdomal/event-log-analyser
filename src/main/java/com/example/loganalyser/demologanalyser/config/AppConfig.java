package com.example.loganalyser.demologanalyser.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.loganalyser.demologanalyser.services.LogFileAnalyser;
import com.example.loganalyser.demologanalyser.services.LogFileReader;

@Configuration
public class AppConfig {
	
	 @Bean
	    public LogFileAnalyser getLogFileAnalyser() {
	        return new LogFileAnalyser();
	    }
	 
	 @Bean
	 public LogFileReader getFileReader() {
	        return new LogFileReader();
	    }

}
