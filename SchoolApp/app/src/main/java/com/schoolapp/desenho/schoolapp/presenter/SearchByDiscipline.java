package com.schoolapp.desenho.schoolapp.presenter;


import android.support.v4.app.Fragment;

import com.schoolapp.desenho.schoolapp.models.Discipline;
import com.schoolapp.desenho.schoolapp.models.Exam;

import java.util.ArrayList;
import java.util.List;

public class SearchByDiscipline extends SourceStrategy {

    @Override
    List<Exam> filterExams(List<Exam> allExams, String discipline) {
        List<Exam> exams = new ArrayList<>();

        List<Exam> disciplineExames = allExams.
        return exams;
    }
}
