package com.schoolapp.desenho.schoolapp.models;

public class SchoolClassFactory implements AbstractFactory {

    @Override
    public Event createEvent() {
        return new SchoolClass(null, null, null, null, null, null, null);
    }

}
