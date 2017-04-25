package com.schoolapp.desenho.schoolapp.models;

import java.util.List;

public class Student {
    private String studentName;
    private List<Discipline> studentDisciplines;
    private List<Monitory> studentMonitories;
    private List<Task> studentTasks;
    private List<Exam> studentExames;

    public Student(String studentName, List<Discipline> studentDisciplines, List<Monitory> studentMonitories, List<Task> studentTasks, List<Exam> studentExames) {
        setStudentName(studentName);
        setStudentDisciplines(studentDisciplines);
        setStudentMonitories(studentMonitories);
        setStudentTasks(studentTasks);
        setStudentExames(studentExames);
        setStudentTasks(studentTasks);
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Discipline> getStudentDisciplines() {
        return this.studentDisciplines;
    }

    public void setStudentDisciplines(List<Discipline> studentDisciplines) {
        this.studentDisciplines = studentDisciplines;
    }

    public List<Monitory> getStudentMonitories() {
        return this.studentMonitories;
    }

    public void setStudentMonitories(List<Monitory> studentMonitories) {
        this.studentMonitories = studentMonitories;
    }

    public List<Task> getStudentTasks() {
        return this.studentTasks;
    }

    public void setStudentTasks(List<Task> studentTasks) {
        this.studentTasks = studentTasks;
    }

    public List<Exam> getStudentExames() {
        return this.studentExames;
    }

    public void setStudentExames(List<Exam> studentExames) {
        this.studentExames = studentExames;
    }
}
