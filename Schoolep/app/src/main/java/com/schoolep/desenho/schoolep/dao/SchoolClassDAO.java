package com.schoolep.desenho.schoolep.dao;


import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import com.schoolep.desenho.schoolep.databaseHelper.DataBaseHelper;
import com.schoolep.desenho.schoolep.databaseHelper.GenericDBDAO;
import com.schoolep.desenho.schoolep.models.SchoolClass;

import java.util.ArrayList;
import java.sql.Date;

public class SchoolClassDAO extends GenericDBDAO{

    private DisciplineDAO disciplineDAO;
    private DisciplineClassDAO disciplineClassDAO;

    public SchoolClassDAO(Context context) {
        super(context);
        disciplineDAO = new DisciplineDAO(context);
        disciplineClassDAO = new DisciplineClassDAO(context);
    }

    public ArrayList <SchoolClass> getSchoolClasses (Integer disciplineClassId) {
        ArrayList <SchoolClass> schoolClasses = new ArrayList<>();

        String sql = "SELECT * FROM " + DataBaseHelper.SCHOOLCLASS_TABLE +
                " INNER JOIN " + DataBaseHelper.DISCIPLINE_TABLE + " ON " +
                DataBaseHelper.SCHOOLCLASS_TABLE+ "." + DataBaseHelper.SCHOOLCLASS_DISCIPLINECLASSID_COLUMN +
                "=" + DataBaseHelper.DISCIPLINE_TABLE + "." + DataBaseHelper.DISCIPLINE_ID_COLUMN + " WHERE " +
                DataBaseHelper.SCHOOLCLASS_DISCIPLINECLASSID_COLUMN + " = ?";

        Cursor cursor = database.rawQuery(sql, new String[] {disciplineClassId+""});

        while(cursor.moveToNext()){
            SchoolClass schoolClass = new SchoolClass(
                    new Date(cursor.getLong(2)),
                    new Date(cursor.getLong(3)),
                    new Date(cursor.getLong(4)),
                    cursor.getString(5),
                    disciplineDAO.getDiscipline(disciplineClassDAO.getDisciplineClass(cursor.getInt(1)).getDisciplineId()).getDisciplineName(),
                    cursor.getInt(6)
            );
            schoolClasses.add(schoolClass);
        }

        return schoolClasses;
    }
    /*
    public SchoolClass getSchoolClass(Integer id){
        SchooClass schooClass = null;

        String sql = "SELECT * FROM" + DataBaseHelper.SCHOOLCLASS_TABLE +
                " WHERE " + DataBaseHelper.SCHOOLCLASS_ID_COLUMN + " = ?";
    }
    */
}
