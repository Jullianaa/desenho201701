package com.schoolapp.desenho.schoolapp.models;

import java.util.Date;

public class SchoolClass extends Event {
    private Integer absentClass;

    public SchoolClass(Integer eventId, Date dateEvent, Date startTime, Date endTime, String localEvent,
                       Integer disciplineClassId, Integer absentClass) {
        super(eventId, dateEvent, startTime, endTime, localEvent, disciplineClassId);
        setAbsentClass(absentClass);
    }

    public int getAbsentClass() {
        return this.absentClass;
    }

    public void setAbsentClass(int absentClass) {
        this.absentClass = absentClass;
    }
}
