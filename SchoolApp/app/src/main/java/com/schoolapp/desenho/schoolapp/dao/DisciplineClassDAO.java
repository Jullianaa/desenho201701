package com.schoolep.desenho.schoolapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.schoolep.desenho.schoolapp.databaseHelper.DataBaseHelper;
import com.schoolep.desenho.schoolapp.databaseHelper.GenericDBDAO;
import com.schoolep.desenho.schoolapp.models.DisciplineClass;

import java.util.ArrayList;


public class DisciplineClassDAO extends GenericDBDAO {
    private static final String WHERE_ID_EQUALS = DataBaseHelper.DISCIPLINECLASS_ID_COLUMN +
            " =?";

    private SchoolClassDAO schoolClassDAO;
    private ExamDAO examDAO;

    public DisciplineClassDAO(Context context) {
        super(context);

        schoolClassDAO = new SchoolClassDAO(context);
        examDAO = new ExamDAO(context);
    }
    /* Corrigir a maneira de selecionar da tabela (Como no SchoolClassDAO)*/

    public ArrayList<DisciplineClass> getDisciplineClasses (Integer disciplineId) {
        ArrayList<DisciplineClass> disciplineClasses = new ArrayList<DisciplineClass>();

        String sql = "SELECT * FROM " + DataBaseHelper.DISCIPLINECLASS_TABLE +
                " WHERE " + DataBaseHelper.DISCIPLINECLASS_ID_COLUMN + " = ?";

        Cursor cursor = database.query(DataBaseHelper.DISCIPLINECLASS_TABLE,
                new String[] { DataBaseHelper.DISCIPLINECLASS_CLASSNAME_COLUMN,
                        DataBaseHelper.DISCIPLINECLASS_CLASSPROFESSOR_COLUMN,
                }, null, null,null,null,null);

        while (cursor.moveToNext()){
            DisciplineClass disciplineClass = new DisciplineClass(
                    cursor.getInt(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    schoolClassDAO.getSchoolClasses((cursor.getInt(0))),
                    examDAO.getExam(cursor.getInt(0)));

            disciplineClasses.add(disciplineClass);
        }
        return disciplineClasses;
    }

    public DisciplineClass getDisciplineClass(Integer id){
        DisciplineClass disciplineClass = null;

        String sql = "SELECT * FROM " + DataBaseHelper.DISCIPLINECLASS_TABLE +
                " WHERE " + DataBaseHelper.DISCIPLINECLASS_ID_COLUMN + " = ?";

        Cursor cursor = database.rawQuery(sql, new String[] { id + ""});
        if(cursor.moveToNext()){
            disciplineClass = new DisciplineClass(
                    cursor.getInt(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    schoolClassDAO.getSchoolClasses((cursor.getInt(0))),
                    examDAO.getExam(cursor.getInt(0)));
        }

        if (disciplineClass == null){
            Log.d("DisciplineClassDAO", "disciplineClass is null");
        }
        return disciplineClass;
    }

    public long saveDisciplineClass (DisciplineClass disciplineClass){
        ContentValues values = new ContentValues();

        values.put(DataBaseHelper.DISCIPLINECLASS_DISCIPLINEID_COLUMN, disciplineClass.getDisciplineId());
        values.put(DataBaseHelper.DISCIPLINECLASS_CLASSNAME_COLUMN, disciplineClass.getClassName());
        values.put(DataBaseHelper.DISCIPLINECLASS_CLASSPROFESSOR_COLUMN, disciplineClass.getClassProfessor());

        return database.insert(DataBaseHelper.DISCIPLINECLASS_TABLE, null, values);
    }

    public long updateDisciplineClass (DisciplineClass disciplineClass){
        ContentValues values = new ContentValues();

        values.put(DataBaseHelper.DISCIPLINECLASS_DISCIPLINEID_COLUMN, disciplineClass.getDisciplineId());
        values.put(DataBaseHelper.DISCIPLINECLASS_CLASSNAME_COLUMN, disciplineClass.getClassName());
        values.put(DataBaseHelper.DISCIPLINECLASS_CLASSPROFESSOR_COLUMN, disciplineClass.getClassProfessor());

        long result = database.update(DataBaseHelper.DISCIPLINECLASS_TABLE, values,
                WHERE_ID_EQUALS,
                new String[] {String.valueOf(disciplineClass.getDisciplineId())});

        Log.d("Update result:", "=" + result);
        return result;
    }

    public int deleteDisciplineClass(DisciplineClass disciplineClass){
        return database.delete(DataBaseHelper.DISCIPLINECLASS_TABLE, WHERE_ID_EQUALS,
                new String[]{ disciplineClass.getDisciplineId() + "" });
    }
}
