package com.schoolapp.desenho.schoolapp.models;

import java.util.Date;

public abstract class AbstractFactory {
    private static TaskFactory task = new TaskFactory();
    private static SchoolClassFactory schoolClass = new SchoolClassFactory();
    private static ExamFactory exam = new ExamFactory();
    private static MonitoryFactory monitory = new MonitoryFactory();

    public static AbstractFactory getFactory(String architecture) {
        AbstractFactory factory = null;
        switch (architecture) {
            case "Task":
                factory = task;
            case "SchoolClass":
                factory = schoolClass;
            case "Exam":
                factory = exam;
            case "Monitory":
                factory = monitory;
        }
        return factory;
    }

    public abstract Event createEvent();

}
