package com.schoolapp.desenho.schoolapp.models;

public class MonitoryFactory implements AbstractFactory {

    @Override
    public Event createEvent() {
        return new Monitory(null, null, null, null, null, null, null);
    }

}
