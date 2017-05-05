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

    // get JSON String from a JSON file
    public static String generateJsonString(Context context) {
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
    public static void populateDatabase(final Activity activity, String jsonString){

        disciplineDAO = new DisciplineDAO(activity);
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

                    // create a discipline
                    Discipline discipline = new Discipline(disciplineId, disciplineName, disciplineCode, 0, disciplineClassList, 0);

                    disciplineDAO.saveDiscipline(discipline);

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


}
