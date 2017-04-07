package com.schoolep.desenho.schoolep.models;
import java.util.Date;

public abstract class Event {
    private Date dateEvent;
    private Date startTime;
    private Date endTime;
    private String localEvent;
    private String discipline;

    public Event(Date dateEvent, Date startTime, Date endTime, String localEvent, String discipline) {
        setDateEvent(dateEvent);
        setStartTime(startTime);
        setEndTime(endTime);
        setLocalEvent(localEvent);
        setDiscipline(discipline);
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

    public String getDiscipline() {
        return this.discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
}
