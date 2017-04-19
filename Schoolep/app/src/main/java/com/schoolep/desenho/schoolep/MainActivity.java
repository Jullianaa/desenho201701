package com.schoolep.desenho.schoolep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> disciplinesList = new ArrayList<>();

    // JSON String
    private static String jsonString = null;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jsonString = generateJsonString();

        //GETTING JSON CONTACTS

        if(jsonString != null){
            JSONObject jsonObj = null;
            try {
                jsonObj = new JSONObject(jsonString);
                //GETTING JSON ARRAY NODE
                JSONArray disciplines = jsonObj.getJSONArray(TAG_DISCIPLINES_NAME);

                //LOOPING THROUGH ALL CONTACTS
                for (int indexDisciplines = 0; indexDisciplines < disciplines.length(); indexDisciplines++) {
                    JSONObject disciplinesJson = disciplines.getJSONObject(indexDisciplines);

                    String class_name = disciplinesJson.getString(TAG_CLASS_NAME);
                    String class_code = disciplinesJson.getString(TAG_CLASS_CODE);

                    // Data node is JSON Object
                    JSONArray class_data = disciplinesJson.getJSONArray(TAG_CLASS_DATA);
                    for (int indexData = 0; indexData < class_data.length(); indexData++) {
                        JSONObject dataJson = class_data.getJSONObject(indexData);

                        String class_n = dataJson.getString(TAG_CLASS_NAME);
                        String professor = dataJson.getString(TAG_PROFESSOR);

                        JSONArray days = disciplinesJson.getJSONArray(TAG_DAYS);

                        for (int indexDays = 0; indexDays < days.length(); indexDays++) {
                            JSONObject dayJson = days.getJSONObject(indexDays);

                            String day = dayJson.getString(TAG_DAY);
                            String start_time = dayJson.getString(TAG_START_TIME);
                            String end_time = dayJson.getString(TAG_END_TIME);
                            String local = dayJson.getString(TAG_LOCAL);
                        }
                    }

                int dataLength = class_data.length();
                String stringDataLength = String.valueOf(dataLength);

                String discipline = class_name.concat(class_code.concat(stringDataLength));

                //adding contact to contact list
                this.disciplinesList.add(discipline);
            }

            } catch (final JSONException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Json parsing error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        } else {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "Couldn't get json from server. Check LogCat for possible errors!", Toast.LENGTH_LONG).show();
                }
            });
        }

        //iterate hash

        
    }

    public String generateJsonString() {
        String json = null;

        try {
            InputStream is = getAssets().open("ofertaDataV3.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Log.d("JSON: ", json);

        return json;
    }
}
