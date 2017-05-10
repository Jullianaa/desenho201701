package com.schoolapp.desenho.schoolapp;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.schoolapp.desenho.schoolapp.dao.DisciplineDAO;
import com.schoolapp.desenho.schoolapp.models.Discipline;
import com.schoolapp.desenho.schoolapp.models.DisciplineClass;
import com.schoolapp.desenho.schoolapp.models.Exam;
import com.schoolapp.desenho.schoolapp.models.SchoolClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class JSONParser {

    // Discipline Class DAO
    private static DisciplineDAO disciplineDAO;

    // JSON Node names
    private static final String TAG_DISCIPLINES_NAME = "disciplines";
    private static final String TAG_CLASS_NAME = "class_name";
    private static final String TAG_CLASS_CODE = "class_code";
    private static final String TAG_CLASS_DATA = "class_data";
    private static final String TAG_PROFESSOR = "professor";
    private static final String TAG_DAYS = "days";
    private static final String TAG_DAY = "day";
    private static final String TAG_START_TIME = "start_time";
    private static final String TAG_END_TIME = "end_time";
    private static final String TAG_LOCAL = "local";

    // class id's
    private static int disciplineId = -1;
    private static int disciplineClassId = -1;
    private static int eventId = -1;

    // check if the database is already populated
    public void insertDisciplines(Activity activity){
        disciplineDAO = new DisciplineDAO(activity);
        ArrayList<Discipline> disciplines = disciplineDAO.getAllDisciplines();
        if(disciplines.size() == 0) {
            String jsonString = this.generateJsonString(activity);
            this.populateDatabase(activity, jsonString);
        } else {
            // nothing to do
        }
    }

    // get JSON String from a JSON file
    private String generateJsonString(Context context) {
        String json = null;

        try {
            InputStream is = context.getAssets().open("ofertaDataV3.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return json;
    }

    //populate the database
    private void populateDatabase(final Activity activity, String jsonString){

        //getting JSON disciplines

        if(jsonString != null){
            JSONObject jsonObj = null;
            try {
                jsonObj = new JSONObject(jsonString);

                //getting json array node
                JSONArray disciplines = jsonObj.getJSONArray(TAG_DISCIPLINES_NAME);

                //looping through all disciplines
                for (int indexDisciplines = 0; indexDisciplines < disciplines.length(); indexDisciplines++) {

                    JSONObject disciplinesJson = disciplines.getJSONObject(indexDisciplines);
                    ArrayList<DisciplineClass> disciplineClassList = new ArrayList<>();
                    disciplineId++;

                    Log.d("     JSON: ", "disciplines");

                    String disciplineName = disciplinesJson.getString(TAG_CLASS_NAME);
                    String disciplineCode = disciplinesJson.getString(TAG_CLASS_CODE);

                    Log.d("     Nome - Cod: ", disciplineName.concat(" - ".concat(disciplineCode)));

                    JSONArray class_data = disciplinesJson.getJSONArray(TAG_CLASS_DATA);

                    // looping through the classes
                    for (int indexData = 0; indexData < class_data.length(); indexData++) {

                        // disciplineClass JSON object
                        JSONObject dataJson = class_data.getJSONObject(indexData);
                        ArrayList<SchoolClass> daysList = new ArrayList<>();
                        disciplineClassId++;

                        String class_name = dataJson.getString(TAG_CLASS_NAME);
                        String professor = dataJson.getString(TAG_PROFESSOR);

                        Log.d("     Turma/Professor: ", class_name.concat(" - ".concat(professor)));

                        JSONArray days = dataJson.getJSONArray(TAG_DAYS);

                        // looping through the days
                        for (int indexDays = 0; indexDays < days.length(); indexDays++) {

                            // getting the day object
                            JSONObject dayJson = days.getJSONObject(indexDays);
                            eventId++;

                            // getting the day attributes
                            String day = dayJson.getString(TAG_DAY);
                            switch (day){
                                case "Segunda":
                                    day = "Mon";
                                    break;
                                case "Terça":
                                    day = "Tue";
                                    break;
                                case "Quarta":
                                    day = "Wed";
                                    break;
                                case "Quinta":
                                    day = "Thu";
                                    break;
                                case "Sexta":
                                    day = "Fri";
                                    break;
                                case "Sábado":
                                    day = "Sat";
                                    break;
                                case "Domingo":
                                    day = "Sun";
                                    break;
                                default:
                            }
                            String start_time = dayJson.getString(TAG_START_TIME);
                            String end_time = dayJson.getString(TAG_END_TIME);
                            String localEvent = dayJson.getString(TAG_LOCAL);

                            SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");
                            SimpleDateFormat weekFormat = new SimpleDateFormat("E", Locale.US);
                            Date dateEvent = new Date();
                            Date startTime = new Date();
                            Date endTime = new Date();

                            //parse string to Date
                            try {
                                //All your parse Operations
                                dateEvent = weekFormat.parse(day);
                                startTime = hourFormat.parse(start_time);
                                endTime = hourFormat.parse(end_time);
                            } catch (ParseException e) {
                                //Handle exception here, most of the time you will just log it.
                                e.printStackTrace();
                            }

                            // creating a SchoolClass object
                            SchoolClass schoolClass = new SchoolClass(eventId, dateEvent, startTime, endTime, localEvent, disciplineName, disciplineClassId, 0);

                            // add the SchoolClass created to the list
                            daysList.add(schoolClass);

                            Log.d("     Dia - local: ", day.concat(" - ".concat(localEvent)));
                        }

                        ArrayList<Exam> exams = new ArrayList<>();

                        // create the discipline class object
                        DisciplineClass disciplineClass = new DisciplineClass(disciplineId, class_name, professor, daysList, exams);

                        // add the DisciplineClass object to the list
                        disciplineClassList.add(disciplineClass);

                    }

                    /* get the days from a school class to calculate the number of credits
                    from the time of each class */
                    ArrayList<SchoolClass> days = disciplineClassList.get(0).getDays();
                    Integer numberOfCredits = calculateNumberOfCredits(days);

                    // create a discipline
                    Discipline discipline = new Discipline(disciplineId, disciplineName, disciplineCode, numberOfCredits, disciplineClassList, 0);

                    disciplineDAO.saveDiscipline(discipline);

                    Log.d("Credits: ", numberOfCredits.toString());
                    Log.d(" - ", "----------------------------------------------------------");
                }

            } catch (final JSONException e) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(activity.getApplicationContext(), "Json parsing error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        } else {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity.getApplicationContext(), "Couldn't get json. Check LogCat for possible errors!", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    private int calculateNumberOfCredits(ArrayList<SchoolClass> days){

        // the total minutes of six, four or two credits disciplines
        final int SIX_CREDITS_MINUTES = 330;
        final int FIVE_CREDITS_MINUTES = 275;
        final int FOUR_CREDITS_MINUTES = 220;
        final int THREE_CREDITS_MINUTES = 165;
        final int TWO_CREDITS_MINUTES = 110;

        int totalClassTime = 0;
        int numberOfCredits = 0;
        long rangeInMilliseconds = 0;
        long rangeInMinutes = 0;
        Date startTime;
        Date endTime;

        // count the number of minutes of each class
        for(SchoolClass day : days){
            startTime = day.getStartTime();
            endTime = day.getEndTime();
            rangeInMilliseconds = endTime.getTime()-startTime.getTime();
            rangeInMinutes = TimeUnit.MILLISECONDS.toMinutes(rangeInMilliseconds);
            totalClassTime += rangeInMinutes;
        }

        // assign the number of credits depending on the class time in minutes
        if (totalClassTime >= SIX_CREDITS_MINUTES) {
            numberOfCredits = 6;
        } else if (totalClassTime >= FIVE_CREDITS_MINUTES) {
            numberOfCredits = 5;
        } else if (totalClassTime >= FOUR_CREDITS_MINUTES) {
            numberOfCredits = 4;
        } else if (totalClassTime >= THREE_CREDITS_MINUTES) {
            numberOfCredits = 3;
        } else if (totalClassTime >= TWO_CREDITS_MINUTES){
            numberOfCredits = 2;
        } else {
            numberOfCredits = 1;
        }

        return numberOfCredits;
    }

}
