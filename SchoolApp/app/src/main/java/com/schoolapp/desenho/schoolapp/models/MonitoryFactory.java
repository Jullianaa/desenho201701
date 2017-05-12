package com.schoolapp.desenho.schoolapp.models;

import java.util.Date;

public class MonitoryFactory extends AbstractFactory {

    @Override
    public Monitory createEvent() {
        return new Monitory();
    }

}
