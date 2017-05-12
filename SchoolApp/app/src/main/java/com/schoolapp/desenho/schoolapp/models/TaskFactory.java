package com.schoolapp.desenho.schoolapp.models;

public class TaskFactory implements AbstractFactory {

    @Override
    public Event createEvent() {
        return new Task(null, null, null, null, null, null, null);
    }

}
