package com.schoolep.desenho.schoolep.models;

import java.util.List;

public class DisciplineClass {
    private String className;
    private String classProfessor;
    private List<SchoolClass> days;

    public DisciplineClass(String className, String classProfessor) {
        this.className = className;
        this.classProfessor = classProfessor;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassProfessor() {
        return classProfessor;
    }

    public void setClassProfessor(String classProfessor) {
        this.classProfessor = classProfessor;
    }

    public List<SchoolClass> getDays() {
        return days;
    }

    public void addDay(SchoolClass classDay) {
        this.days.add(classDay);
    }
}
