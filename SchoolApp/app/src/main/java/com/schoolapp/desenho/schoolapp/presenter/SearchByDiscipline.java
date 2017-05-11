package com.schoolapp.desenho.schoolapp.presenter;


import android.content.Context;
import android.support.v4.app.Fragment;

import com.schoolapp.desenho.schoolapp.models.Discipline;
import com.schoolapp.desenho.schoolapp.models.Exam;

import java.util.ArrayList;
import java.util.List;

public class SearchByDiscipline extends SourceStrategy {

    @Override
    List<Exam> filterExams(List<Exam> allExams, String discipline, Context context) {
        List<Exam> exams = new ArrayList<>();
        return exams;
    }
}