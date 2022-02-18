package com.example.loganalyser.demologanalyser.model;

public class EventLog {
	
	private String id;
	
	private String state;
	
	private String type;
	
	private String HOST;
	
	private long timestamp;
	
	private long duration;
	
	//constructor
	public EventLog() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHost() {
		return HOST;
	}

	public void setHost(String host) {
		this.HOST = host;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}
}
