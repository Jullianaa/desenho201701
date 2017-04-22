package com.schoolep.desenho.schoolapp.models;

import java.sql.Date;

public class Monitory extends Event {
    private String monitor;

    public Monitory(Integer eventId, Date dateEvent, Date startTime, Date endTime, String localEvent,
                    String discipline, Integer disciplineClassId, String monitor) {
        super(eventId, dateEvent, startTime, endTime, localEvent, discipline, disciplineClassId);
        setMonitor(monitor);
    }

    public String getMonitor() {
        return this.monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }
}
