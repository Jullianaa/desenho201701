package com.schoolapp.desenho.schoolapp.models;

class MonitoryFactory extends AbstractFactory {

    @Override
    public Event createEvent() {
        return new Monitory();
    }

}
