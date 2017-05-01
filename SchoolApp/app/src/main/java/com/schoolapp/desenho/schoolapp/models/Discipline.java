package com.schoolapp.desenho.schoolapp.models;

import java.util.ArrayList;

public class Discipline {
    private Integer disciplineId;
    private String disciplineName;
    private String disciplineCode;
    private Integer disciplineCredits;
    private ArrayList<DisciplineClass> classes;
    private Integer studentId;

    public Discipline(Integer disciplineId, String disciplineName, String disciplineCode,
                      Integer disciplineCredits, ArrayList<DisciplineClass> classes,
                      Integer studentId) {
        setDisciplineName(disciplineName);
        setDisciplineCode(disciplineCode);
        setDisciplineCredits(disciplineCredits);
        setClasses(classes);
        setStudentId(studentId);
    }

    public Integer getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(Integer disciplineId) {
        this.disciplineId = disciplineId;
    }

    public String getDisciplineName() {
        return this.disciplineName;
    }

    private void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public String getDisciplineCode() {
        return this.disciplineCode;
    }

    private void setDisciplineCode(String disciplineCode) {
        this.disciplineCode = disciplineCode;
    }

    public ArrayList<DisciplineClass> getClasses() {
        return this.classes;
    }

    private void setClasses(ArrayList<DisciplineClass> classes){
        this.classes = classes;
    }

    public int getDisciplineCredits() {
        return this.disciplineCredits;
    }

    private void setDisciplineCredits(int disciplineCredits) {
        this.disciplineCredits = disciplineCredits;
    }

    public Integer getStudentId() {
        return studentId;
    }

    private void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}