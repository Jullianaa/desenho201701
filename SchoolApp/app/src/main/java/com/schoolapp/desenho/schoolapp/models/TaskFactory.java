package com.schoolapp.desenho.schoolapp.models;

class TaskFactory extends AbstractFactory {

    @Override
    public Event createEvent() {
        return new Task();
    }

}
