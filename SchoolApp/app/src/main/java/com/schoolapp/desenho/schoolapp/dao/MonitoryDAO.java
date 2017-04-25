package com.schoolapp.desenho.schoolapp.dao;


import android.content.Context;

import com.schoolapp.desenho.schoolapp.databaseHelper.DataBaseHelper;
import com.schoolapp.desenho.schoolapp.databaseHelper.GenericDBDAO;
import com.schoolapp.desenho.schoolapp.models.Monitory;

public class MonitoryDAO extends GenericDBDAO {
    private static final String WHERE_ID_EQUALS = DataBaseHelper.MONITORY_ID_COLUMN + " =?";

    public MonitoryDAO(Context context) {
        super(context);
    }
}
