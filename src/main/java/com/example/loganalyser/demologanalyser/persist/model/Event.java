package com.example.loganalyser.demologanalyser.persist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "events")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "event_id", nullable = false)
	private String eventId;

	@Column(name = "event_duration", nullable = false)
	private long eventDuration;

	@Column(name = "event_type", nullable = true)
	private String eventType;

	@Column(name = "host", nullable = true)
	private String host;

	@Column(name = "alert", nullable = false)
	private boolean alert;

	public Event() {
		// TODO Auto-generated constructor stub
	}

	public Event(String eventId, long eventDuration, String eventType, String host, boolean alert) {
		this.eventId = eventId;
		this.eventDuration = eventDuration;
		this.eventType = eventType;
		this.host = host;
		this.alert = alert;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public long getEventDuration() {
		return eventDuration;
	}

	public void setEventDuration(long eventDuration) {
		this.eventDuration = eventDuration;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public boolean isAlert() {
		return alert;
	}

	public void setAlert(boolean alert) {
		this.alert = alert;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", eventId=" + eventId + ", eventDuration=" + eventDuration + ", eventType="
				+ eventType + ", host=" + host + ", alert=" + alert + "]";
	}

}
