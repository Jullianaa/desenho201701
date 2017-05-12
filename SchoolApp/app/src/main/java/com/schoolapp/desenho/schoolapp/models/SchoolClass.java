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

    public static class Builder{

        private Integer eventId;
        private Date dateEvent;
        private Date startTime;
        private Date endTime;
        private String localEvent;
        private Integer disciplineClassId;
        private String monitor;

        public Builder setEventId(int eventId){
            this.eventId = eventId;
            return this;
        }

        public Builder setDateEvent(Date dateEvent){
            this.dateEvent = dateEvent;
            return this;
        }

        public Builder setStartTime(Date startTime){
            this.startTime = startTime;
            return this;
        }

        public Builder setEndTime(Date endTime){
            this.endTime = endTime;
            return this;
        }

        public Builder setLocalEvent(String localEvent){
            this.localEvent = localEvent;
            return this;
        }

        public Builder setDisciplineClassId(Integer disciplineClassId){
            this.disciplineClassId = disciplineClassId;
            return this;
        }

        public Builder setAbsentClass(Integer absentClass){
            this.absentClass = absentClass;
            return this;
        }

        public SchoolClass createExam(){
            return new SchoolClass(eventId, dateEvent, startTime, endTime,
                                localEvent, disciplineClassId, absentClass);
        }
    }
}
