package com.schoolapp.desenho.schoolapp.presenter;


import android.content.Context;

import com.schoolapp.desenho.schoolapp.dao.ExamDAO;
import com.schoolapp.desenho.schoolapp.models.Discipline;
import com.schoolapp.desenho.schoolapp.models.Exam;

import java.util.ArrayList;
import java.util.List;

public abstract class SourceStrategy {
    private List<Exam> allExams;

    public void search(Integer userId, Context context){
        this.allExams = findExams(userId, context);
        this.allExams = filterExams(this.allExams, "");
    }

    List<Exam> findExams(Integer userId, Context context){
        DisciplinePresenter disciplinePresenter = new DisciplinePresenter(context);
        List<Discipline> studentDisciplines = disciplinePresenter.getAllDisciplines(userId);
        List<Exam> allExams = new ArrayList<Exam>();

        for(Integer discipline = 0; discipline < studentDisciplines.size(); discipline++){
            Integer disciplineId = studentDisciplines.get(discipline).getDisciplineId();

            ExamDAO examDAO = new ExamDAO(context);
            List<Exam> exams = examDAO.getAllExams(disciplineId);

            allExams.addAll(exams);
        }

        return allExams;
    }

    abstract List<Exam> filterExams(List<Exam> allExams, String param);


}