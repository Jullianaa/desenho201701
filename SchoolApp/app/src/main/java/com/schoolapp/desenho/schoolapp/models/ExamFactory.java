package com.schoolapp.desenho.schoolapp.models;

import java.util.Date;

public class ExamFactory extends AbstractFactory {

    @Override
    public Exam createEvent() {
        return new Exam();
    }

}
