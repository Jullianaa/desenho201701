package com.schoolapp.desenho.schoolapp.models;

import java.util.ArrayList;

public class DisciplineClass {
    private Integer disciplineId;
    private String className;
    private String classProfessor;
    private ArrayList<SchoolClass> days;
    private ArrayList<Exam> exams;

    public DisciplineClass(Integer disciplineId, String className, String classProfessor, ArrayList<SchoolClass> days, ArrayList<Exam> exams) {

        setDisciplineId(disciplineId);
        setClassName(className);
        setClassProfessor(classProfessor);
        setDays(days);
        setExams(exams);
    }

    public Integer getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(Integer disciplineId) {
        this.disciplineId = disciplineId;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassProfessor() {
        return this.classProfessor;
    }

    public void setClassProfessor(String classProfessor) {
        this.classProfessor = classProfessor;
    }

    public ArrayList<SchoolClass> getDays() {
        return this.days;
    }

    public ArrayList<Exam> getExams() {
        return exams;
    }

    public void setExams(ArrayList<Exam> exams) {
        this.exams = exams;
    }

    public void setDays(ArrayList<SchoolClass> days) {

        this.days = days;
    }
}
