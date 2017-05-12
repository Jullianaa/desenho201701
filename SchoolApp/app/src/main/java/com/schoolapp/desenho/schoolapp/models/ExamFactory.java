package com.schoolapp.desenho.schoolapp.models;

class ExamFactory extends AbstractFactory {

    @Override
    public Event createEvent() {
        return new Exam();
    }

}
