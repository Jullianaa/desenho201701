package com.schoolep.desenho.schoolep.models;

import java.sql.Date;

public class SchoolClass extends Event {
    private Integer absentClass;

    public SchoolClass(Date dateEvent, Date startTime, Date endTime, String localEvent,
                       String discipline, Integer absentClass) {
        super(dateEvent, startTime, endTime, localEvent, discipline);
        setAbsentClass(absentClass);
    }

    public int getAbsentClass() {
        return this.absentClass;
    }

    public void setAbsentClass(int absentClass) {
        this.absentClass = absentClass;
    }
}
