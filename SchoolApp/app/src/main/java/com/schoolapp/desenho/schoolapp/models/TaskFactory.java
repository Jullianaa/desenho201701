package com.schoolapp.desenho.schoolapp.models;

import java.util.Date;

public class TaskFactory extends AbstractFactory {

    @Override
    public Task createEvent() {
        return new Task();
    }

}
