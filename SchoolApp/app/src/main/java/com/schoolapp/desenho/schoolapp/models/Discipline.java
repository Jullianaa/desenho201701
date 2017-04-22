package com.schoolep.desenho.schoolapp.models;

import java.util.ArrayList;

public class Discipline {
    private Integer disciplineId;
    private String disciplineName;
    private String disciplineCode;
    private Integer disciplineCredits;
    private ArrayList<DisciplineClass> classes;

    public Discipline(Integer disciplineId, String disciplineName, String disciplineCode, Integer disciplineCredits, ArrayList<DisciplineClass> classes) {
        setDisciplineName(disciplineName);
        setDisciplineCode(disciplineCode);
        setDisciplineCredits(disciplineCredits);
        setClasses(classes);
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

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public String getDisciplineCode() {
        return this.disciplineCode;
    }

    public void setDisciplineCode(String disciplineCode) {
        this.disciplineCode = disciplineCode;
    }

    public ArrayList<DisciplineClass> getClasses() {
        return this.classes;
    }

    public void setClasses(ArrayList<DisciplineClass> classes){
        this.classes = classes;
    }

    public int getDisciplineCredits() {
        return this.disciplineCredits;
    }

    public void setDisciplineCredits(int disciplineCredits) {
        this.disciplineCredits = disciplineCredits;
    }
}