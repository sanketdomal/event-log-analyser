package com.example.loganalyser.demologanalyser.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.loganalyser.demologanalyser.persist.model.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
	
	
}