package com.schoolapp.desenho.schoolapp.models;

import java.util.Date;

public class Task extends Event {
    private String taskDescription;

    public Task(Integer eventId, Date dateEvent, Date startTime, Date endTime, String localEvent,
                Integer disciplineClassId, String taskDescription) {
        super(eventId, dateEvent, startTime, endTime, localEvent, disciplineClassId);
        setTaskDescription(taskDescription);
    }

    public String getTaskDescription() {
        return this.taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
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

        public Builder setTaskDescription(String taskDescription){
            this.taskDescription = taskDescription;
            return this;
        }

        public Task createExam(){
            return new Task(eventId, dateEvent, startTime, endTime,
                                localEvent, disciplineClassId, taskDescription);
        }
    }
}
