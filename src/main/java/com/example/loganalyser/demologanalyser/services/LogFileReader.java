package com.example.loganalyser.demologanalyser.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.loganalyser.demologanalyser.model.EventLog;

@Component
public class LogFileReader {
	
	public List<EventLog> readLogFile(String filePath){
		System.out.println("readLogFile");
		return null;
		
	}

}
