package com.schoolep.desenho.schoolep.models;
import java.util.Date;

public abstract class Event {
    private Date dateEvent;
    private Date startTime;
    private Date endTime;
    private String localEvent;
    private String discipline;

    public Event(Date dateEvent, Date startTime, Date endTime, String localEvent, String discipline) {
        this.dateEvent = dateEvent;
        this.startTime = startTime;
        this.endTime = endTime;
        this.localEvent = localEvent;
        this.discipline = discipline;
    }

    public Date getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(Date dateEvent) {
        this.dateEvent = dateEvent;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getLocalEvent() {
        return localEvent;
    }

    public void setLocalEvent(String localEvent) {
        this.localEvent = localEvent;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
}
