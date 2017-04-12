package com.schoolep.desenho.schoolep.dao;


import android.content.Context;

import com.schoolep.desenho.schoolep.databaseHelper.GenericDBDAO;
import com.schoolep.desenho.schoolep.models.SchoolClass;

import java.util.ArrayList;

public class SchoolClassDAO extends GenericDBDAO{

    public SchoolClassDAO(Context context) {
        super(context);

    }

    public ArrayList <SchoolClass> getSchoolClasses (Integer disciplineCLassId) {
        ArrayList <SchoolClass> schoolClasses = new ArrayList<>();
        return schoolClasses;
    }
}
