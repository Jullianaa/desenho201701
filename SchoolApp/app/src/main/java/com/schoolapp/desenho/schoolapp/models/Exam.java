package com.schoolapp.desenho.schoolapp.models;

import java.sql.Date;
import java.util.List;

public class Exam extends Event{
    private Float grade;
    private String contentExam;

    public Exam(Integer eventId, Date dateEvent, Date startTime, Date endTime, String localEvent, String discipline,
                Integer disciplineClassId, Float grade, String contentExam){
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
