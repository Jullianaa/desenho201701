package com.schoolapp.desenho.schoolapp.presenter;

import com.schoolapp.desenho.schoolapp.models.Exam;

import java.util.ArrayList;
import java.util.List;

public class SearchByDate extends SourceStrategy {

    @Override
    List<Exam> filterExams(List<Exam> allExams) {
        List<Exam> lista = new ArrayList<>();
        return lista;
    }
}
