package com.schoolep.desenho.schoolep.models;

import java.util.Date;

public class Monitory extends Event {
    private String monitor;

    public Monitory(Date dateEvent, Date startTime, Date endTime, String localEvent, String discipline, String monitor) {
        super(dateEvent, startTime, endTime, localEvent, discipline);
        setMonitor(monitor);
    }

    public String getMonitor() {
        return this.monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }
}
