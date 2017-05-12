package com.schoolapp.desenho.schoolapp.models;

import java.util.Date;

public class SchoolClassFactory extends AbstractFactory {

    @Override
    public SchoolClass createEvent() {
        return new SchoolClass();
    }

}
