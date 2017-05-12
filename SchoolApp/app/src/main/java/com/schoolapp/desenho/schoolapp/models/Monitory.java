package com.schoolapp.desenho.schoolapp.models;

import java.util.Date;

public class Monitory extends Event {
    private String monitor;

    public Monitory(Integer eventId, Date dateEvent, Date startTime, Date endTime, String localEvent,
                    Integer disciplineClassId, String monitor) {
        super(eventId, dateEvent, startTime, endTime, localEvent, disciplineClassId);
        setMonitor(monitor);
    }

    public String getMonitor() {
        return this.monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
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

        public Builder setMonitor(String monitor){
            this.monitor = monitor;
            return this;
        }

        public Monitory createExam(){
            return new Monitory(eventId, dateEvent, startTime, endTime,
                                localEvent, disciplineClassId, monitor);
        }
    }
}
