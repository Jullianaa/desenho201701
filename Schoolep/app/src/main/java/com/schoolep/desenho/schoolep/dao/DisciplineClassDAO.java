package com.schoolep.desenho.schoolep.dao;

import android.content.Context;

import com.schoolep.desenho.schoolep.databaseHelper.GenericDBDAO;
import com.schoolep.desenho.schoolep.models.DisciplineClass;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucas on 09/04/17.
 */

public class DisciplineClassDAO extends GenericDBDAO {

    public DisciplineClassDAO(Context context) {
        super(context);
    }

    public ArrayList<DisciplineClass> getDisciplineClasses (Integer disciplineId) {
        ArrayList<DisciplineClass> disciplineClasses = new ArrayList<DisciplineClass>();


        return disciplineClasses;
    }
}
