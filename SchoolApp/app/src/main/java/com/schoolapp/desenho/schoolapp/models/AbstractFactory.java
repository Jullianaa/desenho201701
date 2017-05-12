package com.schoolapp.desenho.schoolapp.models;


abstract class AbstractFactory {
    private static final TaskFactory task = new TaskFactory();
    private static final SchoolClassFactory schoolClass = new SchoolClassFactory();
    private static final ExamFactory exam = new ExamFactory();
    private static final MonitoryFactory monitory = new MonitoryFactory();

    static AbstractFactory getFactory(String architecture) {
        AbstractFactory factory = null;
        switch (architecture) {
            case 'Task':
                factory = task;
            case 'SchoolClass':
                factory = schoolClass;
            case 'Exam':
                factory = exam;
            case 'Monitory':
                factory = monitory;
        }
        return factory;
    }

    public abstract Event createEvent();

}
