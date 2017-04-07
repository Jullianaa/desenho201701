package com.schoolep.desenho.schoolep.models;

import java.util.List;

public class DisciplineClass {
    private String className;
    private String classProfessor;
    private List<SchoolClass> days;

    public DisciplineClass(String className, String classProfessor, List<SchoolClass> days) {
        setClassName(className);
        setClassProfessor(classProfessor);
        setDays(days);
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

    public List<SchoolClass> getDays() {
        return this.days;
    }

    public void setDays(List<SchoolClass> days) {
        this.days = days;
    }
}
