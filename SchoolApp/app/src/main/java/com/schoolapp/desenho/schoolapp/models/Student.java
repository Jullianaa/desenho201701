package com.schoolapp.desenho.schoolapp.models;

import java.util.ArrayList;

public class Student {
    private Integer studentId;
    private String studentName;
    private ArrayList<Discipline> studentDisciplines;
    private ArrayList<DisciplineClass> studentDisciplinesClasses;
    private ArrayList<ArrayList<SchoolClass>> studentSchoolClasses;
    private ArrayList<ArrayList<Monitory>> studentMonitories;
    private ArrayList<ArrayList<Task>> studentTasks;
    private ArrayList<ArrayList<Exam>> studentExames;

    public Student(Integer studentId, String studentName, ArrayList<Discipline> studentDisciplines,
                   ArrayList<DisciplineClass> studentDisciplinesClasses,
                   ArrayList<ArrayList<SchoolClass>> studentSchoolClasses,
                   ArrayList<ArrayList<Monitory>> studentMonitories,
                   ArrayList<ArrayList<Task>> studentTasks, ArrayList<ArrayList<Exam>> studentExames) {

        setStudentId(studentId);
        setStudentName(studentName);
        setStudentDisciplines(studentDisciplines);
        setStudentDisciplinesClasses(studentDisciplinesClasses);
        setStudentSchoolClasses(studentSchoolClasses);
        setStudentMonitories(studentMonitories);
        setStudentTasks(studentTasks);
        setStudentExames(studentExames);
        setStudentTasks(studentTasks);
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public ArrayList<Discipline> getStudentDisciplines() {
        return this.studentDisciplines;
    }

    public void setStudentDisciplines(ArrayList<Discipline> studentDisciplines) {
        this.studentDisciplines = studentDisciplines;
    }

    public ArrayList<ArrayList<Monitory>> getStudentMonitories() {
        return this.studentMonitories;
    }

    public void setStudentMonitories(ArrayList<ArrayList<Monitory>> studentMonitories) {
        this.studentMonitories = studentMonitories;
    }

    public ArrayList<ArrayList<Task>> getStudentTasks() {
        return this.studentTasks;
    }

    public void setStudentTasks(ArrayList<ArrayList<Task>> studentTasks) {
        this.studentTasks = studentTasks;
    }

    public ArrayList<ArrayList<Exam>> getStudentExames() {
        return this.studentExames;
    }

    public void setStudentExames(ArrayList<ArrayList<Exam>> studentExames) {
        this.studentExames = studentExames;
    }

    public ArrayList<DisciplineClass> getStudentDisciplinesClasses() {
        return studentDisciplinesClasses;
    }

    public void setStudentDisciplinesClasses(ArrayList<DisciplineClass> studentDisciplinesClasses) {
        this.studentDisciplinesClasses = studentDisciplinesClasses;
    }

    public ArrayList<ArrayList<SchoolClass>> getStudentSchoolClasses() {
        return studentSchoolClasses;
    }

    public void setStudentSchoolClasses(ArrayList<ArrayList<SchoolClass>> studentSchoolClasses) {
        this.studentSchoolClasses = studentSchoolClasses;
    }

}
