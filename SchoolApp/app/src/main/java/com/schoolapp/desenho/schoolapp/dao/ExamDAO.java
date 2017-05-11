package com.schoolapp.desenho.schoolapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.schoolapp.desenho.schoolapp.databaseHelper.DataBaseHelper;
import com.schoolapp.desenho.schoolapp.databaseHelper.GenericDBDAO;
import com.schoolapp.desenho.schoolapp.models.Exam;

import java.util.Date;
import java.util.ArrayList;

public class ExamDAO extends GenericDBDAO{
    private static final String WHERE_ID_EQUALS = DataBaseHelper.EXAM_ID_COLUMN + " =?";

    private DisciplineDAO disciplineDAO;
    private DisciplineClassDAO disciplineClassDAO;

    public ExamDAO (Context context) {
        super(context);

        disciplineDAO = new DisciplineDAO(context);
        disciplineClassDAO = new DisciplineClassDAO(context);
    }

    public ArrayList<Exam> getAllExams (Integer disciplineClassId) {
        ArrayList<Exam> exams = new ArrayList<>();

        String sql = "SELECT * FROM " + DataBaseHelper.EXAM_TABLE +
                " WHERE " + DataBaseHelper.EXAM_DISCIPLINECLASSID_COLUMN + " = ?";

        Cursor cursor = database.rawQuery(sql, new String[] {disciplineClassId+""});

        while(cursor.moveToNext()){
            Exam exam = new Exam(
                    cursor.getInt(0),
                    new Date(cursor.getLong(2)),
                    new Date(cursor.getLong(3)),
                    new Date(cursor.getLong(4)),
                    cursor.getString(5),
                    cursor.getInt(1),
                    cursor.getFloat(6),
                    cursor.getString(7)
            );
            exams.add(exam);
        }

        cursor.close();
        return exams;
    }

    public Exam getExam (Integer examId){
        Exam exam = null;

        String sql = "SELECT * FROM" + DataBaseHelper.EXAM_TABLE +
                " WHERE " + DataBaseHelper.EXAM_ID_COLUMN + " = ?";

        Cursor cursor = database.rawQuery(sql, new String[] { examId + "" });
        if(cursor.moveToNext()) {
            exam = new Exam(
                    examId,
                    new Date(cursor.getLong(2)),
                    new Date(cursor.getLong(3)),
                    new Date(cursor.getLong(4)),
                    cursor.getString(5),
                    cursor.getInt(1),
                    cursor.getFloat(6),
                    cursor.getString(7)
            );
        }
        cursor.close();
        return exam;
    }

    public long saveExam (Exam exam){
        ContentValues values = new ContentValues();

        values.put(DataBaseHelper.EXAM_ID_COLUMN, exam.getDisciplineClassId());
        values.put(DataBaseHelper.EXAM_DISCIPLINECLASSID_COLUMN, exam.getDisciplineClassId());
        values.put(DataBaseHelper.EXAM_DATEEVENT_COLUMN, exam.getDateEvent().toString());
        values.put(DataBaseHelper.EXAM_STARTTIME_COLUMN, exam.getDateEvent().toString());
        values.put(DataBaseHelper.EXAM_ENDTIME_COLUMN, exam.getEndTime().toString());
        values.put(DataBaseHelper.EXAM_LOCALEVENT_COLUMN, exam.getLocalEvent());
        values.put(DataBaseHelper.EXAM_GRADE_COLUMN, exam.getGrade());
        values.put(DataBaseHelper.EXAM_CONTENT_COLUMN, exam.getContentExam());

        return database.insert(DataBaseHelper.EXAM_TABLE, null, values);
    }

    public long updateExam (Exam exam){
        ContentValues values = new ContentValues();

        values.put(DataBaseHelper.EXAM_ID_COLUMN, exam.getDisciplineClassId());
        values.put(DataBaseHelper.EXAM_DISCIPLINECLASSID_COLUMN, exam.getDisciplineClassId());
        values.put(DataBaseHelper.EXAM_DATEEVENT_COLUMN, exam.getDateEvent().toString());
        values.put(DataBaseHelper.EXAM_STARTTIME_COLUMN, exam.getDateEvent().toString());
        values.put(DataBaseHelper.EXAM_ENDTIME_COLUMN, exam.getEndTime().toString());
        values.put(DataBaseHelper.EXAM_LOCALEVENT_COLUMN, exam.getLocalEvent());
        values.put(DataBaseHelper.EXAM_GRADE_COLUMN, exam.getGrade());
        values.put(DataBaseHelper.EXAM_CONTENT_COLUMN, exam.getContentExam());

        long result = database.update(DataBaseHelper.EXAM_TABLE, values,
                WHERE_ID_EQUALS,
                new String[] { String.valueOf(exam.getEventId())});
        Log.d("Update Result:", "=" + result);
        return result;
    }

    public int deleteExam (Exam exam) {
        return database.delete(DataBaseHelper.EXAM_TABLE, WHERE_ID_EQUALS,
                new String[] { exam.getEventId() + "" });
    }
}
