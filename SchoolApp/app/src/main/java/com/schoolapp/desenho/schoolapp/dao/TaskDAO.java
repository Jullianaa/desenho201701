package com.schoolapp.desenho.schoolapp.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.schoolapp.desenho.schoolapp.databaseHelper.DataBaseHelper;
import com.schoolapp.desenho.schoolapp.databaseHelper.GenericDBDAO;
import com.schoolapp.desenho.schoolapp.models.Task;
import com.schoolapp.desenho.schoolapp.models.AbstractFactory;
import com.schoolapp.desenho.schoolapp.models.TaskFactory;

import java.util.Date;
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

    public ArrayList<Task> getTasks (Integer disciplineClassId) {
        ArrayList<Task> tasks = new ArrayList<>();

        String sql = "SELECT * FROM " + DataBaseHelper.TASK_TABLE +
                " WHERE " + DataBaseHelper.TASK_DISCIPLINECLASSID_COLUMN + " = ?";

        Cursor cursor = database.rawQuery(sql, new String[] {disciplineClassId+""});

        while(cursor.moveToNext()){
          Task.Builder builder = new Task.Builder();
          Task task = builder.setEventId(disciplineClassId)
                  .setDateEvent(new Date(cursor.getLong(2)))
                  .setStartTime(new Date(cursor.getLong(3)))
                  .setEndTime(new Date(cursor.getLong(4)))
                  .setLocalEvent(cursor.getString(5))
                  .setDisciplineClassId(cursor.getInt(6))
                  .setTaskDescription(cursor.getString(1))
                  .createTask();

            tasks.add(task);
        }
        cursor.close();
        return tasks;
    }

    public Task getTask (Integer taskId){
        Task task = null;
        String sql = "SELECT * FROM" + DataBaseHelper.TASK_TABLE +
                " WHERE " + DataBaseHelper.TASK_ID_COLUMN + " = ?";

        Cursor cursor = database.rawQuery(sql, new String[] { taskId + "" });
        if(cursor.moveToNext()) {
          Task.Builder builder = new Task.Builder();
          task = builder.setEventId(taskId)
                  .setDateEvent(new Date(cursor.getLong(2)))
                  .setStartTime(new Date(cursor.getLong(3)))
                  .setEndTime(new Date(cursor.getLong(4)))
                  .setLocalEvent(cursor.getString(5))
                  .setDisciplineClassId(cursor.getInt(6))
                  .setTaskDescription(cursor.getString(1))
                  .createTask();
        }
        cursor.close();
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
