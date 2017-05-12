package com.schoolapp.desenho.schoolapp.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.schoolapp.desenho.schoolapp.databaseHelper.DataBaseHelper;
import com.schoolapp.desenho.schoolapp.databaseHelper.GenericDBDAO;
import com.schoolapp.desenho.schoolapp.models.Monitory;
import com.schoolapp.desenho.schoolapp.models.AbstractFactory;
import com.schoolapp.desenho.schoolapp.models.MonitoryFactory;

import java.util.ArrayList;
import java.util.Date;

public class MonitoryDAO extends GenericDBDAO {
    private static final String WHERE_ID_EQUALS = DataBaseHelper.MONITORY_ID_COLUMN + " =?";

    private DisciplineDAO disciplineDAO;
    private DisciplineClassDAO disciplineClassDAO;

    public MonitoryDAO(Context context) {
        super(context);

        disciplineDAO = new DisciplineDAO(context);
        disciplineClassDAO = new DisciplineClassDAO(context);
    }

    public ArrayList <Monitory> getMonitories (Integer disciplineClassId) {
        ArrayList<Monitory> monitories = new ArrayList<>();

        String sql = "SELECT * FROM " + DataBaseHelper.MONITORY_TABLE +
                " WHERE " + DataBaseHelper.MONITORY_DISCIPLINECLASSID_COLUMN + " = ?";

        Cursor cursor = database.rawQuery(sql, new String[] {disciplineClassId+""});

        while(cursor.moveToNext()){
          AbstractFactory factory = AbstractFactory.getFactory("Monitory");
          Monitory monitory = factory.createEvent(
                    cursor.getInt(0),
                    new Date(cursor.getLong(2)),
                    new Date(cursor.getLong(3)),
                    new Date(cursor.getLong(4)),
                    cursor.getString(5),
                    cursor.getInt(1),
                    cursor.getString(6)
            );
            monitories.add(monitory);
        }
        cursor.close();
        return monitories;
    }

    public Monitory getMonitory(Integer monitoryId){

        String sql = "SELECT * FROM" + DataBaseHelper.MONITORY_TABLE +
                " WHERE " + DataBaseHelper.MONITORY_ID_COLUMN + " = ?";

        Cursor cursor = database.rawQuery(sql, new String[] { monitoryId + "" });
        if(cursor.moveToNext()) {
          AbstractFactory factory = AbstractFactory.getFactory("Monitory");
          Monitory monitory = factory.createEvent();
          (
                    monitoryId,
                    new Date(cursor.getLong(2)),
                    new Date(cursor.getLong(3)),
                    new Date(cursor.getLong(4)),
                    cursor.getString(5),
                    cursor.getInt(1),
                    cursor.getString(6)
            );
        }
        cursor.close();
        return monitory;
    }

    public long saveMonitory (Monitory monitory){
        ContentValues values = new ContentValues();

        values.put(DataBaseHelper.MONITORY_DISCIPLINECLASSID_COLUMN, monitory.getDisciplineClassId());
        values.put(DataBaseHelper.MONITORY_DATEEVENT_COLUMN, monitory.getDateEvent().toString());
        values.put(DataBaseHelper.MONITORY_STARTTIME_COLUMN, monitory.getDateEvent().toString());
        values.put(DataBaseHelper.MONITORY_ENDTIME_COLUMN, monitory.getEndTime().toString());
        values.put(DataBaseHelper.MONITORY_LOCALEVENT_COLUMN, monitory.getLocalEvent());
        values.put(DataBaseHelper.MONITORY_MONITOR_COLUMN, monitory.getMonitor());

        return database.insert(DataBaseHelper.MONITORY_TABLE, null, values);
    }

    public long updateMonitory(Monitory monitory){
        ContentValues values = new ContentValues();

        values.put(DataBaseHelper.MONITORY_DISCIPLINECLASSID_COLUMN, monitory.getDisciplineClassId());
        values.put(DataBaseHelper.MONITORY_DATEEVENT_COLUMN, monitory.getDateEvent().toString());
        values.put(DataBaseHelper.MONITORY_STARTTIME_COLUMN, monitory.getDateEvent().toString());
        values.put(DataBaseHelper.MONITORY_ENDTIME_COLUMN, monitory.getEndTime().toString());
        values.put(DataBaseHelper.MONITORY_LOCALEVENT_COLUMN, monitory.getLocalEvent());
        values.put(DataBaseHelper.MONITORY_MONITOR_COLUMN, monitory.getMonitor());

        long result = database.update(DataBaseHelper.MONITORY_TABLE, values,
                WHERE_ID_EQUALS,
                new String[] { String.valueOf(monitory.getEventId())});
        Log.d("Update Result:", "=" + result);
        return result;
    }

    public int deleteMonitory(Monitory monitory) {
        return database.delete(DataBaseHelper.MONITORY_TABLE, WHERE_ID_EQUALS,
                new String[] { monitory.getEventId() + "" });
    }
}
