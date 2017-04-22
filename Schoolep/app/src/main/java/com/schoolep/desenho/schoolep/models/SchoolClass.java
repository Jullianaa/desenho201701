package com.schoolep.desenho.schoolep.models;

import java.sql.Date;

public class SchoolClass extends Event {
    private Integer absentClass;

    public SchoolClass(Integer eventId, Date dateEvent, Date startTime, Date endTime, String localEvent,
                       String discipline, Integer disciplineClassId, Integer absentClass) {
        super(eventId, dateEvent, startTime, endTime, localEvent, discipline, disciplineClassId);
        setAbsentClass(absentClass);
    }

    public int getAbsentClass() {
        return this.absentClass;
    }

    public void setAbsentClass(int absentClass) {
        this.absentClass = absentClass;
    }
}
