package com.example.loganalyser.demologanalyser;

import java.util.Formatter;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.loganalyser.demologanalyser.config.AppConfig;
import com.example.loganalyser.demologanalyser.model.EventLog;
import com.example.loganalyser.demologanalyser.persist.model.Event;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.loganalyser.demologanalyser")
public class DemoLoganalyserApplication {

	@Autowired
	AppConfig appConfig;

	public void start(String args[]) {
		System.out.println("Event Log Analyser started...");
		if (args.length > 0) {
			List<EventLog> events = appConfig.getFileReader().readLogFile(args[0]);
			List<Event> analysedEvents = appConfig.getLogFileAnalyser().fetchAnalysedEvents(events);
			if(!Objects.isNull(analysedEvents)) {
				Formatter fmt = new Formatter();  
				fmt.format("%25s %20s %15s %15s %15s\n", "Event_ID", "Event_Duration", "Type", "Host", "Alert");
				fmt.format("%25s %20s %15s %15s %15s\n", "--------", "-----------", "----------", "-----", "-----");
				for(Event ev : analysedEvents) {
					fmt.format("%25s %20s %15s %15s %15s\n", ev.getEventId(), ev.getEventDuration(), ev.getEventType(), ev.getHost(), ev.isAlert());
				}		
				System.out.println(fmt);
			}
		} else {
			System.out.println("Please provide logfile path...");
		}
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			this.start(args);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoLoganalyserApplication.class, args);
	}

}
