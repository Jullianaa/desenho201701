package com.schoolapp.desenho.schoolapp.dao;


import android.content.Context;

import com.schoolapp.desenho.schoolapp.databaseHelper.GenericDBDAO;
import com.schoolapp.desenho.schoolapp.models.Exam;

import java.util.ArrayList;

public class ExamDAO extends GenericDBDAO{
    public ExamDAO(Context context) {
        super(context);
    }

    public ArrayList <Exam> getExam (Integer disciplineCLassId) {
        ArrayList<Exam> exams = new ArrayList<>();
        return exams;
    }
}
