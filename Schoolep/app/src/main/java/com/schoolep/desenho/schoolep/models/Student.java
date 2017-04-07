package com.schoolep.desenho.schoolep.models;

import java.util.List;

public class Student {
    private String studentName;
    private List<Discipline> studentDisciplines;
    private List<Monitory> studentMonitories;
    private List<Task> studentTasks;
    private List<Exam> studentExames;

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Discipline> getStudentDisciplines() {
        return studentDisciplines;
    }

    public void addStudentDiscipline(Discipline discipline) {
        this.studentDisciplines.add(discipline);
    }

    public List<Monitory> getStudentMonitories() {
        return studentMonitories;
    }

    public void addStudentMonitory(Monitory monitory) {
        this.studentMonitories.add(monitory);
    }

    public List<Task> getStudentTasks() {
        return studentTasks;
    }

    public void addStudentTask(Task task) {
        this.studentTasks.add(task);
    }

    public List<Exam> getStudentExames() {
        return studentExames;
    }

    public void addStudentExam(Exam exam) {
        this.studentExames.add(exam);
    }
}
