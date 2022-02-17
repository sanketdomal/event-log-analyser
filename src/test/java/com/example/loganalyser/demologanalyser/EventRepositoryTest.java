package com.example.loganalyser.demologanalyser;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.loganalyser.demologanalyser.Repository.EventRepository;
import com.example.loganalyser.demologanalyser.persist.model.Event;
import com.example.loganalyser.demologanalyser.services.EventService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventRepositoryTest {
	
	@Autowired
    private EventRepository eventRepository;
	
	@Autowired
	private EventService eventService;
	
	@Test
    public void whenFindingEventById_thenCorrect() {
		eventRepository.save(new Event("scsmbstgrb", 3, "APPLICATION_LOG", "12345", false));
//        assertThat(eventRepository.findById(1L)).isInstanceOf(Optional.class);
        
    }
	
	@Test
    public void FindAllEvents() {
		List<Event> list = eventService.findAll();
		//System.out.println(list.toString());      
    }
	

}
