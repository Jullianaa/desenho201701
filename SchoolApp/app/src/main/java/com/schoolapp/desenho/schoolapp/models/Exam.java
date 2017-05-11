package com.schoolapp.desenho.schoolapp.models;

import java.util.Date;

public class Exam extends Event{
    private Float grade;
    private String contentExam;

    public Exam(Integer eventId, Integer disciplineClassId, Date dateEvent, Date startTime,
                Date endTime, String localEvent, String discipline, Float grade, String contentExam){
        super(eventId, dateEvent, startTime, endTime, localEvent, discipline, disciplineClassId);
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

}
