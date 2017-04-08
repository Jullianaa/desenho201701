package com.schoolep.desenho.schoolep.databaseHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper{

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // Database Name
    private static final String DATABASE_NAME = "esculepi";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Table Names
    private static final String DISCIPLINE_TABLE = "discipline";
    private static final String DISCIPLINECLASS_TABLE = "disciplineclass";
    private static final String EVENT_TABLE = "event";
    private static final String SCHOOLCLASS_TABLE = "schoolclass";
    private static final String EXAM_TABLE = "exam";
    private static final String MONITORY_TABLE = "monitory";
    private static final String STUDENT_TABLE = "student";
    private static final String TASK_TABLE = "task";

    // Discipline Column Names
    private static final String DISCIPLINE_ID_COLUMN = "disciplineId";
    private static final String DISCIPLINE_DISCIPLINECLASSID_COLUMN = "disciplineDisciplineClassId";
    private static final String DISCIPLINE_NAME_COLUMN = "disciplineName";
    private static final String DISCIPLINE_CODE_COLUMN = "disciplineCode";
    private static final String DISCIPLINE_CREDITS_COLUMN = "disciplineCredits";

    // DisciplineClass Column Names
    private static final String DISCIPLINECLASS_ID_COLUMN = "disciplineclassId";
    private static final String DISCIPLINECLASS_SCHOOLCLASSID_COLUMN = "disciplineclassSchoolClassId";
    private static final String DISCIPLINECLASS_CLASSNAME_COLUMN = "disciplineclassClassname";
    private static final String DISCIPLINECLASS_CLASSPROFESSOR_COLUMN = "disciplineclassClassprofessor";

    // Exam Column Names
    private static final String EXAM_ID_COLUMN = "examId";
    private static final String EXAM_DISCIPLINECLASSID_COLUMN = "examDisciplineClassId";
    private static final String EXAM_DATEEVENT_COLUMN = "examDateevent";
    private static final String EXAM_STARTTIME_COLUMN = "examStarttime";
    private static final String EXAM_ENDTIME_COLUMN = "examEndtime";
    private static final String EXAM_LOCALEVENT_COLUMN = "examLocalevent";
    private static final String EXAM_DISCIPLINE_COLUMN = "examDiscipline";

    // Monitory Column Names
    private static final String MONITORY_ID_COLUMN = "monitoryId";
    private static final String MONITORY_DATEEVENT_COLUMN = "monitoryDateEvent";
    private static final String MONITORY_STARTTIME_COLUMN = "monitoryStartTime";
    private static final String MONITORY_ENDTIME_COLUMN = "monitoryEndTime";
    private static final String MONITORY_LOCALEVENT_COLUMN = "monitoryLocalEvent";
    private static final String MONITORY_DISCIPLINE_COLUMN = "monitoryDiscipline";
    private static final String MONITORY_MONITOR_COLUMN = "monitoryMonitor";

    // SchoolClass Column Names
    private static final String SCHOOLCLASS_ID_COLUMN = "schoolClassId";
    private static final String SCHOOLCLASS_DATEEVENT_COLUMN = "schoolClassDateEvent";
    private static final String SCHOOLCLASS_STARTTIME_COLUMN = "schoolClassStartTime";
    private static final String SCHOOLCLASS_ENDTIME_COLUMN = "schoolClassEndTime";
    private static final String SCHOOLCLASS_LOCALEVENT_COLUMN = "schoolClassLocalEvent";
    private static final String SCHOOLCLASS_DISCIPLINE_COLUMN = "schoolClassDiscipline";
    private static final String SCHOOLCLASS_ABSENTCLASS_COLUMN = "schoolClassAbsentClass";

    // Task Column Names
    private static final String TASK_ID_COLUMN = "taskClassId";
    private static final String TASK_DATEEVENT_COLUMN = "taskClassDateEvent";
    private static final String TASK_STARTTIME_COLUMN = "taskClassStartTime";
    private static final String TASK_ENDTIME_COLUMN = "taskClassEndTime";
    private static final String TASK_LOCALEVENT_COLUMN = "taskClassLocalEvent";
    private static final String TASK_DISCIPLINE_COLUMN = "taskClassDiscipline";
    private static final String TASK_DESCRIPTION_COLUMN = "taskClassDescription";

    // Student Column Names
    private static final String STUDENT_ID_COLUMN = "studentId";
    private static final String STUDENT_NAME_COLUMN = "studentName";

    // Creating Discipline Data
    private static final String CREATE_DISCIPLINE_TABLE = "CREATE TABLE " +
            DISCIPLINE_TABLE + "(" + DISCIPLINE_ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            DISCIPLINE_DISCIPLINECLASSID_COLUMN + " INTEGER, " +
            DISCIPLINE_NAME_COLUMN + " TEXT, " + DISCIPLINE_CODE_COLUMN + " TEXT, " +
            DISCIPLINE_CREDITS_COLUMN + " INTEGER, " + "FOREIGN KEY (" +
            DISCIPLINE_DISCIPLINECLASSID_COLUMN + ") REFERENCES " + DISCIPLINECLASS_TABLE +
            "(" + DISCIPLINECLASS_ID_COLUMN + "));";

    // Creating DisciplineClass Data
    private static final String CREATE_DISCIPLINECLASS_TABLE = "CREATE TABLE " +
            DISCIPLINECLASS_TABLE + "(" + DISCIPLINECLASS_ID_COLUMN + " INTEGER PRIMARY KEY " +
            "AUTOINCREMENT, " + DISCIPLINE_DISCIPLINECLASSID_COLUMN + " INTEGER, " +
            DISCIPLINECLASS_CLASSNAME_COLUMN + " TEXT, " + DISCIPLINECLASS_CLASSPROFESSOR_COLUMN +
            " TEXT, " + "FOREIGN KEY (" + DISCIPLINECLASS_SCHOOLCLASSID_COLUMN + ") REFERENCES " +
            SCHOOLCLASS_TABLE + "(" + SCHOOLCLASS_ID_COLUMN + "));";

    // Creating Exam Data
    private static final String CREATE_EXAM_TABLE = "CREATE TABLE " +
            EXAM_TABLE + "(" + EXAM_ID_COLUMN + " INTEGER PRIMARY KEY " +
            "AUTOINCREMENT, " + EXAM_DISCIPLINECLASSID_COLUMN + " INTEGER, " +
            EXAM_DATEEVENT_COLUMN + " TEXT, " + EXAM_STARTTIME_COLUMN +
            " TEXT, " + EXAM_ENDTIME_COLUMN + " TEXT, " + EXAM_LOCALEVENT_COLUMN + " TEXT, " +
            "FOREIGN KEY (" + EXAM_DISCIPLINECLASSID_COLUMN + ") REFERENCES " + DISCIPLINECLASS_TABLE +
            "(" + DISCIPLINECLASS_ID_COLUMN + "));";



    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
