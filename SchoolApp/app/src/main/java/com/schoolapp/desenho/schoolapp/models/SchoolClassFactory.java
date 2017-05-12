package com.schoolapp.desenho.schoolapp.models;

class SchoolClassFactory extends AbstractFactory {

    @Override
    public Event createEvent() {
        return new SchoolClass();
    }

}
