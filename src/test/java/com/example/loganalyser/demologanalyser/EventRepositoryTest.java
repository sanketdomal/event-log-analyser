package com.example.loganalyser.demologanalyser;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.loganalyser.demologanalyser.Repository.EventRepository;
import com.example.loganalyser.demologanalyser.model.EventLog;
import com.example.loganalyser.demologanalyser.persist.model.Event;
import com.example.loganalyser.demologanalyser.services.EventService;
import com.example.loganalyser.demologanalyser.services.LogFileAnalyser;
import com.example.loganalyser.demologanalyser.services.LogFileReader;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventRepositoryTest {
	
	@Autowired
    private EventRepository eventRepository;
	
	@Autowired
	private EventService eventService;
	
	@Autowired 
	private LogFileReader logFileReader;
	
	@Autowired
	private LogFileAnalyser logFileAnalyser;
	
	
	
	@Test
    public void whenFindingEventById_thenCorrect() {
		eventService.save(new Event("scsmbstgrb", 3, "APPLICATION_LOG", "12345", false));
//        assertThat(eventRepository.findById(1L)).isInstanceOf(Optional.class);
        
    }
	
	@Test
    public void FindAllEvents() {
		List<Event> list = eventService.findAll();
		assertNotEquals(null, list);
    }
	
	@Test
	//Test to fetch all analysed events here
    public void whenFindingAnalaysedEventFromFile() {
		List<EventLog> logs = logFileReader.readLogFile("H:\\sanketDocs\\creditSuiessAssignment\\logfile.txt");
		List<Event> analysedEvents = logFileAnalyser.fetchAnalysedEvents(logs);
		System.out.println(analysedEvents);
    }
	

}
