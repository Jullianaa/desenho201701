package com.schoolapp.desenho.schoolapp.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.schoolapp.desenho.schoolapp.databaseHelper.DataBaseHelper;
import com.schoolapp.desenho.schoolapp.databaseHelper.GenericDBDAO;
import com.schoolapp.desenho.schoolapp.models.Discipline;
import com.schoolapp.desenho.schoolapp.models.DisciplineClass;
import com.schoolapp.desenho.schoolapp.models.Exam;
import com.schoolapp.desenho.schoolapp.models.Monitory;
import com.schoolapp.desenho.schoolapp.models.SchoolClass;
import com.schoolapp.desenho.schoolapp.models.Student;
import com.schoolapp.desenho.schoolapp.models.Task;

import java.util.ArrayList;

public class StudentDAO extends GenericDBDAO{
    private static final String WHERE_ID_EQUALS = DataBaseHelper.STUDENT_ID_COLUMN + " =?";

    private DisciplineDAO disciplineDAO;
    private DisciplineClassDAO disciplineClassDAO;
    private SchoolClassDAO schoolClassDAO;
    private MonitoryDAO monitoryDAO;
    private ExamDAO examDAO;
    private TaskDAO taskDAO;

    public StudentDAO (Context context) {
        super(context);

        disciplineDAO = new DisciplineDAO(context);
        disciplineClassDAO = new DisciplineClassDAO(context);
        schoolClassDAO = new SchoolClassDAO(context);
        monitoryDAO = new MonitoryDAO(context);
        examDAO = new ExamDAO(context);
        taskDAO = new TaskDAO(context);
    }

    public Student getDefaultStudent(){
        // Defines the default student id - Which is 1
        final Integer defaultStudentId = new Integer(1);

        Student foundStudent = null;

        // Uses the DAO to retrieve the student from database
        foundStudent = this.getStudent(defaultStudentId);

        return foundStudent;
    }

    public Student getStudent(Integer studentId){
        Student student = null;

        String sql = "SELECT * FROM " + DataBaseHelper.STUDENT_TABLE +
                " WHERE " + DataBaseHelper.STUDENT_ID_COLUMN + " = ?";

        Cursor cursor = database.rawQuery(sql, new String[] { studentId + "" });
        if(cursor.moveToNext()) {
            ArrayList<DisciplineClass> disciplineClasses = disciplineClassDAO.getAllStudentDisciplineClasses(cursor.getInt(0));
            ArrayList<ArrayList<SchoolClass>> disciplineSchoolClasses = new ArrayList<ArrayList<SchoolClass>>();
            ArrayList<ArrayList<Monitory>> disciplineMonitories = new ArrayList<ArrayList<Monitory>>();
            ArrayList<ArrayList<Task>> disciplineTasks = new ArrayList<ArrayList<Task>>();
            ArrayList<ArrayList<Exam>> disciplineExams = new ArrayList<ArrayList<Exam>>();

            for(DisciplineClass disciplineClass : disciplineClasses){
                ArrayList<SchoolClass> schoolClasses = schoolClassDAO.getSchoolClasses(disciplineClass.getDisciplineId());
                disciplineSchoolClasses.add(schoolClasses);

                ArrayList<Monitory> monitories = monitoryDAO.getMonitories(disciplineClass.getDisciplineId());
                disciplineMonitories.add(monitories);

                ArrayList<Task> tasks = taskDAO.getTasks(disciplineClass.getDisciplineId());
                disciplineTasks.add(tasks);

                ArrayList<Exam> exams = examDAO.getAllExams(disciplineClass.getDisciplineId());
                disciplineExams.add(exams);
            }
            student = new Student(
                    cursor.getString(0),
                    disciplineDAO.getAllStudentDisciplines(cursor.getInt(0)),
                    disciplineClassDAO.getAllStudentDisciplineClasses(cursor.getInt(0)),
                    disciplineSchoolClasses,
                    disciplineMonitories,
                    disciplineTasks,
                    disciplineExams
            );
        }

        return student;
    }

    // Saving student's name, disciplines and discipline classes.
    public long saveStudent(Student student) {
        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.STUDENT_NAME_COLUMN, student.getStudentName());

        ArrayList<Discipline> studentDisciplines = student.getStudentDisciplines();
        for(Discipline discipline : studentDisciplines) {
            discipline.setStudentId(1);
            disciplineDAO.updateDiscipline(discipline);
        }

        ArrayList<DisciplineClass> studentDisciplineClasses = student.getStudentDisciplinesClasses();
        for(DisciplineClass disciplineClass : studentDisciplineClasses) {
            disciplineClass.studentId = 1;
            disciplineClassDAO.updateDisciplineClass(disciplineClass);
        }

        Log.d("Status Student:", "SAVED");

        return database.insert(DataBaseHelper.STUDENT_TABLE, null, values);
    }
}
