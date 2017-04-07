package com.schoolep.desenho.schoolep.models;

import java.util.List;

public class Exam {
    private List <String> contentExam;
    private float grade;

    public Exam(float grade) {
        this.grade = grade;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public void addContentExam(String content){
        this.contentExam.add(content);
    }

    public List<String> getContentExam (){
        return this.contentExam;
    }

}
