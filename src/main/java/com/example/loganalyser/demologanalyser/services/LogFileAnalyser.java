package com.example.loganalyser.demologanalyser.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.example.loganalyser.demologanalyser.model.EventLog;
import com.example.loganalyser.demologanalyser.persist.model.Event;

@Service
@Configurable
public class LogFileAnalyser {

	@Autowired
	EventService eventService;

	Map<String, EventLog> eventMap = new HashMap<String, EventLog>();

	public void analyseEventLog() {

	}

	public List<Event> fetchAnalysedEvents(List<EventLog> eventsFromLog) {
		long duration = 0;
		for (EventLog eventLog : eventsFromLog) {
			EventLog prevEventLog = eventMap.put(eventLog.getId(), eventLog);
			if (!Objects.isNull(prevEventLog)) {
				if (prevEventLog.getState().equals("STARTED")) {
					duration = eventLog.getTimestamp() - prevEventLog.getTimestamp();
				} else {
					duration = prevEventLog.getTimestamp() - eventLog.getTimestamp();
				}
				eventLog.setDuration(duration);
				eventMap.put(eventLog.getId(), eventLog);

			}
		}
		try {
			for (EventLog ev : eventMap.values()) {
				eventService.save(
						new Event(ev.getId(), ev.getDuration(), ev.getType(), ev.getHost(), ev.getDuration() > 4));
			}
			
			return eventService.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
