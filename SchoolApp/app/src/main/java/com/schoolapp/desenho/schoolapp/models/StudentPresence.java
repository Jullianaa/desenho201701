package com.schoolapp.desenho.schoolapp.models;

public class StudentPresence {
    private Integer classesMissed;
    private String disciplineName;

    public StudentPresence(String name, Integer missed){
        this.setDisciplineName(name);
        this.setClassesMissed(missed);
    }

    // Public getters and setters
    public Integer getClassesMissed() {
        return classesMissed;
    }

    public void setClassesMissed(Integer classesMissed) {
        this.classesMissed = classesMissed;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }
}
