package com.schoolep.desenho.schoolep.models;

import java.util.List;

public class Discipline {
    private String disciplineName;
    private String disciplineCode;
    private Integer disciplineCredits;
    private List<DisciplineClass> classes;

    public Discipline(String disciplineName, String disciplineCode, Integer disciplineCredits, List<DisciplineClass> classes) {
        setDisciplineName(disciplineName);
        setDisciplineCode(disciplineCode);
        setDisciplineCredits(disciplineCredits);
        setClasses(classes);
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

    public List<DisciplineClass> getClasses() {
        return this.classes;
    }

    public void setClasses(List<DisciplineClass> classes){
        this.classes = classes;
    }

    public int getDisciplineCredits() {
        return this.disciplineCredits;
    }

    public void setDisciplineCredits(int disciplineCredits) {
        this.disciplineCredits = disciplineCredits;
    }
}