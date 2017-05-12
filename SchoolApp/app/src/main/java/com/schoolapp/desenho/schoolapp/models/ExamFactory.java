package com.schoolapp.desenho.schoolapp.models;

import java.util.Date;

public class ExamFactory implements AbstractFactory {

    @Override
    public Event createEvent() {
        Exam exam = new Exam(null, null, null, null, null, null, null, null);
        return exam;
    }

}
