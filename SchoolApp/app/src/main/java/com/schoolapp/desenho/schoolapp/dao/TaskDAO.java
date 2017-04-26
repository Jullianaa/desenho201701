package com.schoolapp.desenho.schoolapp.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.schoolapp.desenho.schoolapp.databaseHelper.DataBaseHelper;
import com.schoolapp.desenho.schoolapp.databaseHelper.GenericDBDAO;
import com.schoolapp.desenho.schoolapp.models.Task;

import java.sql.Date;
import java.util.ArrayList;

public class TaskDAO extends GenericDBDAO{
    private static final String WHERE_ID_EQUALS = DataBaseHelper.TASK_ID_COLUMN + " =?";

    private DisciplineDAO disciplineDAO;
    private DisciplineClassDAO disciplineClassDAO;

    public TaskDAO (Context context) {
        super(context);

        disciplineDAO = new DisciplineDAO(context);
        disciplineClassDAO = new DisciplineClassDAO(context);
    }

    public ArrayList<Task> getTasks (Integer taskId) {
        ArrayList<Task> tasks = new ArrayList<>();

        String sql = "SELECT * FROM " + DataBaseHelper.TASK_TABLE +
                " WHERE " + DataBaseHelper.TASK_ID_COLUMN + " = ?";

        Cursor cursor = database.rawQuery(sql, new String[] {taskId+""});

        while(cursor.moveToNext()){
            Task task = new Task(
                    cursor.getInt(0),
                    new Date(cursor.getLong(2)),
                    new Date(cursor.getLong(3)),
                    new Date(cursor.getLong(4)),
                    cursor.getString(5),
                    disciplineDAO.getDiscipline(disciplineClassDAO.getDisciplineClass(cursor.
                            getInt(1)).getDisciplineId()).getDisciplineName(),
                    cursor.getInt(6),
                    cursor.getString(7)
            );
            tasks.add(task);
        }

        return tasks;
    }

    public Task getTask (Integer taskId){
        Task task = null;

        String sql = "SELECT * FROM" + DataBaseHelper.TASK_TABLE +
                " WHERE " + DataBaseHelper.TASK_ID_COLUMN + " = ?";

        Cursor cursor = database.rawQuery(sql, new String[] { taskId + "" });
        if(cursor.moveToNext()) {
            task = new Task(
                    taskId,
                    new Date(cursor.getLong(2)),
                    new Date(cursor.getLong(3)),
                    new Date(cursor.getLong(4)),
                    cursor.getString(5),
                    disciplineDAO.getDiscipline(disciplineClassDAO.getDisciplineClass(cursor.
                            getInt(1)).getDisciplineId()).getDisciplineName(),
                    cursor.getInt(6),
                    cursor.getString(1)
            );
        }
        return task;
    }

    public long saveTask (Task task){
        ContentValues values = new ContentValues();

        values.put(DataBaseHelper.TASK_ID_COLUMN, task.getDisciplineClassId());
        values.put(DataBaseHelper.TASK_DISCIPLINECLASSID_COLUMN, task.getDateEvent().toString());
        values.put(DataBaseHelper.TASK_DATEEVENT_COLUMN, task.getDateEvent().toString());
        values.put(DataBaseHelper.TASK_STARTTIME_COLUMN, task.getEndTime().toString());
        values.put(DataBaseHelper.TASK_ENDTIME_COLUMN, task.getLocalEvent());
        values.put(DataBaseHelper.TASK_LOCALEVENT_COLUMN, task.getLocalEvent());
        values.put(DataBaseHelper.TASK_DESCRIPTION_COLUMN, task.getTaskDescription());

        return database.insert(DataBaseHelper.TASK_TABLE, null, values);
    }

    public long updateTask (Task task){
        ContentValues values = new ContentValues();

        values.put(DataBaseHelper.TASK_ID_COLUMN, task.getDisciplineClassId());
        values.put(DataBaseHelper.TASK_DISCIPLINECLASSID_COLUMN, task.getDateEvent().toString());
        values.put(DataBaseHelper.TASK_DATEEVENT_COLUMN, task.getDateEvent().toString());
        values.put(DataBaseHelper.TASK_STARTTIME_COLUMN, task.getEndTime().toString());
        values.put(DataBaseHelper.TASK_ENDTIME_COLUMN, task.getLocalEvent());
        values.put(DataBaseHelper.TASK_LOCALEVENT_COLUMN, task.getLocalEvent());
        values.put(DataBaseHelper.TASK_DESCRIPTION_COLUMN, task.getTaskDescription());

        long result = database.update(DataBaseHelper.TASK_TABLE, values,
                WHERE_ID_EQUALS,
                new String[] { String.valueOf(task.getEventId())});
        Log.d("Update Result:", "=" + result);
        return result;
    }

    public int deleteTask (Task task) {
        return database.delete(DataBaseHelper.TASK_TABLE, WHERE_ID_EQUALS,
                new String[] { task.getEventId() + "" });
    }
}
