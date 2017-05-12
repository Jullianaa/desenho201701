package com.schoolapp.desenho.schoolapp.models;

import java.util.Date;

public class Exam extends Event{
    private Float grade;
    private String contentExam;

    public Exam(Integer eventId, Integer disciplineClassId, Date dateEvent, Date startTime,
                Date endTime, String localEvent, Float grade, String contentExam){
        super(eventId, dateEvent, startTime, endTime, localEvent, disciplineClassId);

        setGrade(grade);
        setContentExam(contentExam);
    }

    public float getGrade() {
        return this.grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public void setContentExam(String contentExam){
        this.contentExam = contentExam;
    }

    public String getContentExam (){
        return this.contentExam;
    }

    public static class Builder{

        private Integer eventId;
        private Integer disciplineClassId;
        private Date dateEvent;
        private Date startTime;
        private Date endTime;
        private String localEvent;
        private Float grade;
        private String contentExam;

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

        public Builder setDisciplineClassId(int disciplineClassId){
            this.disciplineClassId = disciplineClassId;
            return this;
        }

        public Builder setGrade(Float grade){
            this.grade = grade;
            return this;
        }

        public Builder setContentExam(String contentExam){
            this.contentExam = contentExam;
            return this;
        }

        public Exam createExam(){
            return new Exam(eventId, dateEvent, startTime, endTime, localEvent,
                        disciplineClassId, grade, contentExam);
        }
    }
}
