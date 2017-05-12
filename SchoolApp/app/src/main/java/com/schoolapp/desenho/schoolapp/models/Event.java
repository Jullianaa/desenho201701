package com.schoolapp.desenho.schoolapp.models;
import java.util.Date;

public abstract class Event {
    private Integer eventId;
    private Date dateEvent;
    private Date startTime;
    private Date endTime;
    private String localEvent;
    private Integer disciplineClassId;

    public Event(Integer eventId, Date dateEvent, Date startTime, Date endTime, String localEvent,
                 Integer disciplineClassId) {
        setEventId(eventId);
        setDateEvent(dateEvent);
        setStartTime(startTime);
        setEndTime(endTime);
        setLocalEvent(localEvent);
        setDisciplineClassId(disciplineClassId);
    }

    public Date getDateEvent() {
        return this.dateEvent;
    }

    public void setDateEvent(Date dateEvent) {
        this.dateEvent = dateEvent;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getLocalEvent() {
        return this.localEvent;
    }

    public void setLocalEvent(String localEvent) {
        this.localEvent = localEvent;
    }

    public Integer getDisciplineClassId() {
        return disciplineClassId;
    }

    public void setDisciplineClassId(Integer disciplineClassId) {
        this.disciplineClassId = disciplineClassId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }
}
