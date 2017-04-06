package com.schoolep.desenho.schoolep.models;

import java.util.Date;

public class Monitory extends Event {
    private String monitor;

    public Monitory(Date dateEvent, Date startTime, Date endTime, String localEvent, String discipline, String monitor) {
        super(dateEvent, startTime, endTime, localEvent, discipline);
        this.monitor = monitor;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }
}
