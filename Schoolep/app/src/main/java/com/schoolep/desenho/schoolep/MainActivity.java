package com.schoolep.desenho.schoolep;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(
                R.layout.activity_main);
    }

    public void dialog(){
        new AlertDialog.Builder(this)
                .setTitle("Confirmação de Turma")
                .setMessage("Hey, você participa mesmo dessa turma?")
                .setNegativeButton("Não", null)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //chamar tela listSubject.xml
                    }
                }).create().show();
    }
}
