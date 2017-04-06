package com.schoolep.desenho.schoolep.models;

import java.util.List;

public class Discipline {
    private String disciplineName;
    private String disciplineCode;
    private List<DisciplineClass> classes;
    private int disciplineCredits;

    public Discipline(String disciplineName, String disciplineCode, int disciplineCredits) {
        this.disciplineName = disciplineName;
        this.disciplineCode = disciplineCode;
        this.disciplineCredits = disciplineCredits;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public String getDisciplineCode() {
        return disciplineCode;
    }

    public void setDisciplineCode(String disciplineCode) {
        this.disciplineCode = disciplineCode;
    }

    public List<DisciplineClass> getClasses() {
        return classes;
    }

    public void addClasses(DisciplineClass aClass) {
        this.add(aClass);
    }

    public int getDisciplineCredits() {
        return disciplineCredits;
    }

    public void setDisciplineCredits(int disciplineCredits) {
        this.disciplineCredits = disciplineCredits;
    }
}
