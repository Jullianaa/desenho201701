package com.schoolapp.desenho.schoolapp.presenter;

import android.content.Context;

import com.schoolapp.desenho.schoolapp.models.Exam;

import java.util.ArrayList;
import java.util.List;

public class SearchByDate extends SourceStrategy {

    @Override
    List<Exam> filterExams(List<Exam> allExams, String param, Context context) {
        List<Exam> list = new ArrayList<>();
        return list;
    }
}