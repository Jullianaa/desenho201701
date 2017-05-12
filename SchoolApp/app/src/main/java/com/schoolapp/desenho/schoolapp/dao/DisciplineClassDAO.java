package com.schoolapp.desenho.schoolapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.schoolapp.desenho.schoolapp.databaseHelper.DataBaseHelper;
import com.schoolapp.desenho.schoolapp.databaseHelper.GenericDBDAO;
import com.schoolapp.desenho.schoolapp.models.DisciplineClass;
import com.schoolapp.desenho.schoolapp.models.SchoolClass;

import java.util.ArrayList;


public class DisciplineClassDAO extends GenericDBDAO {
    private static final String WHERE_ID_EQUALS = DataBaseHelper.DISCIPLINECLASS_ID_COLUMN +
            " =?";

    private SchoolClassDAO schoolClassDAO;
    private ExamDAO examDAO;
    private Context context;

    public DisciplineClassDAO(Context context) {
        super(context);

        this.context = context;

    }
    /* Corrigir a maneira de selecionar da tabela (Como no SchoolClassDAO)*/

    public ArrayList<DisciplineClass> getAllStudentDisciplineClasses(Integer studentId) {
        ArrayList<DisciplineClass> disciplineClasses = new ArrayList<>();
        schoolClassDAO = new SchoolClassDAO(context);
        examDAO = new ExamDAO(context);

        String sql = "SELECT * FROM " + DataBaseHelper.DISCIPLINECLASS_TABLE +
                " WHERE " + DataBaseHelper.DISCIPLINECLASS_STUDENTID_COLUMN + " = ?";

        Cursor cursor = database.rawQuery(sql, new String[]{studentId + ""});
        while (cursor.moveToNext()) {
            DisciplineClass disciplineClass = new DisciplineClass(
                    cursor.getInt(1),
                    cursor.getString(3),
                    cursor.getString(4),
                    schoolClassDAO.getSchoolClasses(cursor.getInt(0)),
                    examDAO.getAllExams(cursor.getInt(0)),
                    cursor.getInt(0),
                    cursor.getInt(2));

            disciplineClasses.add(disciplineClass);
        }
        cursor.close();
        return disciplineClasses;
    }

    public DisciplineClass getCurrentStudentDisciplineClass(Integer studentId, Integer disciplineClassId) {
        DisciplineClass disciplineClass = null;
        schoolClassDAO = new SchoolClassDAO(context);
        examDAO = new ExamDAO(context);

        String sql = "SELECT * FROM " + DataBaseHelper.DISCIPLINECLASS_TABLE +
                " WHERE " + DataBaseHelper.DISCIPLINECLASS_STUDENTID_COLUMN + " = " + studentId +
                " AND " + DataBaseHelper.DISCIPLINECLASS_DISCIPLINEID_COLUMN + " = " + disciplineClassId;

        Cursor cursor = database.rawQuery(sql,null);
        if(cursor.moveToNext()){
            disciplineClass = new DisciplineClass(
                    cursor.getInt(1),
                    cursor.getString(3),
                    cursor.getString(4),
                    schoolClassDAO.getSchoolClasses(cursor.getInt(0)),
                    examDAO.getAllExams(cursor.getInt(0)),
                    cursor.getInt(0),
                    cursor.getInt(2));
        }

        if (disciplineClass == null){
            Log.d("DisciplineClassDAO", "disciplineClass is null");
        }
        else {
            Log.d("DisciplineClassDAO", disciplineClass.getDisciplineClassId().toString());
        }
        cursor.close();
        return disciplineClass;
    }

    public ArrayList<DisciplineClass> getDisciplineClasses (Integer disciplineId) {
        ArrayList<DisciplineClass> disciplineClasses = new ArrayList<DisciplineClass>();
        schoolClassDAO = new SchoolClassDAO(context);
        examDAO = new ExamDAO(context);

        String sql = "SELECT * FROM " + DataBaseHelper.DISCIPLINECLASS_TABLE +
                " WHERE " + DataBaseHelper.DISCIPLINECLASS_DISCIPLINEID_COLUMN + " = ?";

        Cursor cursor = database.rawQuery(sql, new String[] {disciplineId+""});

        while (cursor.moveToNext()){
            DisciplineClass disciplineClass = new DisciplineClass(
                    cursor.getInt(1),
                    cursor.getString(3),
                    cursor.getString(4),
                    schoolClassDAO.getSchoolClasses(cursor.getInt(0)),
                    examDAO.getAllExams(cursor.getInt(0)),
                    cursor.getInt(0),
                    cursor.getInt(2));

            disciplineClasses.add(disciplineClass);
        }
        cursor.close();
        return disciplineClasses;
    }

    public DisciplineClass getDisciplineClass(Integer id){
        DisciplineClass disciplineClass = null;
        schoolClassDAO = new SchoolClassDAO(context);
        examDAO = new ExamDAO(context);

        String sql = "SELECT * FROM " + DataBaseHelper.DISCIPLINECLASS_TABLE +
                " WHERE " + DataBaseHelper.DISCIPLINECLASS_ID_COLUMN + " = ?";

        Cursor cursor = database.rawQuery(sql, new String[] { id + ""});
        if(cursor.moveToNext()){
            disciplineClass = new DisciplineClass(
                    cursor.getInt(1),
                    cursor.getString(3),
                    cursor.getString(4),
                    schoolClassDAO.getSchoolClasses(id),
                    examDAO.getAllExams(cursor.getInt(0)),
                    cursor.getInt(0),
                    cursor.getInt(2));
        }

        if (disciplineClass == null){
            Log.d("DisciplineClassDAO", "disciplineClass is null");
        }
        cursor.close();
        return disciplineClass;
    }

    public long saveDisciplineClass (DisciplineClass disciplineClass){
        ContentValues values = new ContentValues();

        values.put(DataBaseHelper.DISCIPLINECLASS_DISCIPLINEID_COLUMN, disciplineClass.getDisciplineId());
        values.put(DataBaseHelper.DISCIPLINECLASS_STUDENTID_COLUMN, disciplineClass.getStudentId());
        values.put(DataBaseHelper.DISCIPLINECLASS_CLASSNAME_COLUMN, disciplineClass.getClassName());
        values.put(DataBaseHelper.DISCIPLINECLASS_CLASSPROFESSOR_COLUMN, disciplineClass.getClassProfessor());

        Log.d("Status DisciplineClass:", "SAVED");

        long result = database.insert(DataBaseHelper.DISCIPLINECLASS_TABLE, null, values);

        return result;
    }

    public long updateDisciplineClass (DisciplineClass disciplineClass){
        ContentValues values = new ContentValues();

        values.put(DataBaseHelper.DISCIPLINECLASS_DISCIPLINEID_COLUMN, disciplineClass.getDisciplineId());
        values.put(DataBaseHelper.DISCIPLINECLASS_STUDENTID_COLUMN, disciplineClass.getStudentId());
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
