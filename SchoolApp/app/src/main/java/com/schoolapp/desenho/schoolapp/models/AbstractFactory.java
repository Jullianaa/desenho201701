package com.schoolapp.desenho.schoolapp.models;


abstract class AbstractFactory {
    private static final Task task = new Task();
    private static final SchoolClass schoolClass = new SchoolClass();
    private static final Exam exam = new Exam();

    static AbstractFactory getFactory(String architecture) {
        AbstractFactory factory = null;
        switch (architecture) {
            case 'Task':
                factory = task;
            case 'SchoolClass':
                factory = schoolClass;
            case 'Exam':
                factory = exam;
        }
        return factory;
    }

    public abstract Task createTask();

    public abstract SchoolClass createSchoolClass();

    public abstract Exam createExam();

}
