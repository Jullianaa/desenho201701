package com.schoolapp.desenho.schoolapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private JSONParser jsonParser;
    private String jsonString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jsonString = jsonParser.generateJsonString(this);
        jsonParser.populateDatabase(this, jsonString);

    }
}
