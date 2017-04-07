package com.schoolep.desenho.schoolep.models;

import java.util.List;

public class Exam {
    private Float grade;
    private List<String> contentExam;

    public Exam(Float grade, List<String> contentExam) {
        setGrade(grade);
        setContentExam(contentExam);
    }

    public float getGrade() {
        return this.grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public void setContentExam(List<String> contentExam){
        this.contentExam = contentExam;
    }

    public List<String> getContentExam (){
        return this.contentExam;
    }

}
