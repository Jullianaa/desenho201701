package com.schoolapp.desenho.schoolapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

import com.schoolapp.desenho.schoolapp.databaseHelper.DataBaseHelper;
import com.schoolapp.desenho.schoolapp.databaseHelper.GenericDBDAO;
import com.schoolapp.desenho.schoolapp.models.Discipline;


public class DisciplineDAO extends GenericDBDAO{
    private static final String WHERE_ID_EQUALS = DataBaseHelper.DISCIPLINE_ID_COLUMN + " =?";

    private DisciplineClassDAO disciplineClassDAO;

    public DisciplineDAO(Context context) {
        super(context);

        disciplineClassDAO = new DisciplineClassDAO(context);
    }

    public ArrayList<Discipline> getAllStudentDisciplines(Integer studentId) {
        ArrayList<Discipline> disciplines = new ArrayList<>();

        String sql = "SELECT * FROM " + DataBaseHelper.DISCIPLINE_TABLE +
                " WHERE " + DataBaseHelper.DISCIPLINE_STUDENTID_COLUMN + " = ?";

        Cursor cursor = database.rawQuery(sql, new String[] {studentId+""});
        while(cursor.moveToNext()){
            Discipline discipline = new Discipline(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3),
                    disciplineClassDAO.getDisciplineClasses(cursor.getInt(0)),
                    studentId
            );
            disciplines.add(discipline);
        }

        return disciplines;
    }

    public ArrayList<Discipline> getAllDisciplines() {
        ArrayList<Discipline> disciplines = new ArrayList<Discipline>();

        Cursor cursor = database.query(DataBaseHelper.DISCIPLINE_TABLE,
                new String[] { DataBaseHelper.DISCIPLINE_ID_COLUMN,
                        DataBaseHelper.DISCIPLINE_NAME_COLUMN,
                        DataBaseHelper.DISCIPLINE_CODE_COLUMN,
                        DataBaseHelper.DISCIPLINE_CREDITS_COLUMN,
                        DataBaseHelper.DISCIPLINE_STUDENTID_COLUMN,
                }, null, null, null, null, null);

        while (cursor.moveToNext()) {
            Discipline discipline = new Discipline(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3),
                    disciplineClassDAO.getDisciplineClasses(cursor.getInt(0)),
                    cursor.getInt(4)
            );
            disciplines.add(discipline);
        }
        return disciplines;
    }

    public Discipline getDiscipline(Integer id) {

        Discipline discipline = null;

        String sql = "SELECT * FROM " + DataBaseHelper.DISCIPLINE_TABLE
                + " WHERE " + DataBaseHelper.DISCIPLINE_ID_COLUMN + " = ?";

        Cursor cursor = database.rawQuery(sql, new String[] { id + "" });
        if(cursor.moveToNext()) {
           discipline = new Discipline(
                   cursor.getInt(0),
                   cursor.getString(1),
                   cursor.getString(2),
                   cursor.getInt(3),
                   disciplineClassDAO.getDisciplineClasses(id),
                   cursor.getInt(4)
           );
        }

        if(discipline == null) {
            Log.d("DisciplineDAO", "discipline is null");
        }

        return discipline;
    }

    public long saveDiscipline(Discipline discipline) {
        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.DISCIPLINE_NAME_COLUMN, discipline.getDisciplineName());
        values.put(DataBaseHelper.DISCIPLINE_CODE_COLUMN, discipline.getDisciplineCode());
        values.put(DataBaseHelper.DISCIPLINE_CREDITS_COLUMN, discipline.getDisciplineCredits());
        values.put(DataBaseHelper.DISCIPLINE_STUDENTID_COLUMN, discipline.getStudentId());

        Log.d("Status Discipline:", "SAVED");

        return database.insert(DataBaseHelper.DISCIPLINE_TABLE, null, values);
    }

    public long updateDiscipline(Discipline discipline) {
        ContentValues values = new ContentValues();

        values.put(DataBaseHelper.DISCIPLINE_NAME_COLUMN, discipline.getDisciplineName());
        values.put(DataBaseHelper.DISCIPLINE_CODE_COLUMN, discipline.getDisciplineCode());
        values.put(DataBaseHelper.DISCIPLINE_CREDITS_COLUMN, discipline.getDisciplineCredits());
        values.put(DataBaseHelper.DISCIPLINE_STUDENTID_COLUMN, discipline.getStudentId());

        long result = database.update(DataBaseHelper.DISCIPLINE_TABLE, values,
                WHERE_ID_EQUALS,
                new String[] { String.valueOf(discipline.getDisciplineId())});
        Log.d("Update Result:", "=" + result);
        return result;
    }

    public int deleteDiscipline(Discipline discipline) {
        return database.delete(DataBaseHelper.DISCIPLINE_TABLE, WHERE_ID_EQUALS,
                new String[] { discipline.getDisciplineId() + "" });
    }
}
