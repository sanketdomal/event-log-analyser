package com.example.loganalyser.demologanalyser.services;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.loganalyser.demologanalyser.model.EventLog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

@Service
@Configurable
public class LogFileReader {
	Gson gson = new GsonBuilder().create();

	public List<EventLog> readLogFile(String filePath) {
		System.out.println("Provided File Path: "+filePath);
		List<String> list = new ArrayList<>();

		// read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
			
			stream.forEach(line-> {
				if(!line.isEmpty() || !line.isBlank()) {
					list.add(line);
				}
			});

			

		} catch (IOException e) {

			e.printStackTrace();
		}
		
		//getEventsFormLog(list);

		return getEventsFormLog(list);
	}

	private List<EventLog> getEventsFormLog(List<String> list) {
		
		List<EventLog> events = new ArrayList<EventLog>();
		try {
			for(String s:list) {
				
				JsonObject jsonObject = new JsonParser().parse(s).getAsJsonObject();
//				if(Objects.isNull(jsonObject.get("type")))
//					jsonObject.addProperty("type", "");
//				
//				if(Objects.isNull(jsonObject.get("HOST")))
//					jsonObject.addProperty("HOST", "");
				
				EventLog convertedObject = gson.fromJson(jsonObject, EventLog.class);
				if(!Objects.isNull(convertedObject))
					events.add(convertedObject);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}	
		
		return events;
		
	}

}
