package com.schoolapp.desenho.schoolapp.presenter;

import com.schoolapp.desenho.schoolapp.models.Exam;

import java.util.ArrayList;
import java.util.List;

public class SearchByDate extends SourceStrategy {

    List<Exam> filterExams(List<Exam> allExams) {
        return new ArrayList<>();
    }

    @Override
    List<Exam> filterExams(List<Exam> allExams, String param) {
        return null;
    }
}