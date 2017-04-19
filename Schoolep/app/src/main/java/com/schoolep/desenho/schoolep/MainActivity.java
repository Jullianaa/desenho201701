package com.schoolep.desenho.schoolep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    // JSON String
    private static String jsonString = null;

    // JSON Node names
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
