package com.schoolep.desenho.schoolep.models;

import java.util.Date;

public class SchoolClass extends Event {

    private int absentClass;

    public SchoolClass(Date dateEvent, Date startTime, Date endTime, String localEvent, String discipline) {
        super(dateEvent, startTime, endTime, localEvent, discipline);
    }

    public int getAbsentClass() {
        return absentClass;
    }

    public void setAbsentClass(int absentClass) {
        this.absentClass = absentClass;
    }
}
