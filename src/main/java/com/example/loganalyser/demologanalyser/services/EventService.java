package com.example.loganalyser.demologanalyser.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loganalyser.demologanalyser.Repository.EventRepository;
import com.example.loganalyser.demologanalyser.persist.model.Event;

@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepository;
	
	public List<Event> findAll() {
		Iterable<Event> it = eventRepository.findAll();

		List<Event> events = new ArrayList<Event>();
		it.forEach(e -> events.add(e));		
		return events;
	}

}
