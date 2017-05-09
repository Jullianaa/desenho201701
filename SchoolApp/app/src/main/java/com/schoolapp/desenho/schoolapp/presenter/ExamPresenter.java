package com.schoolapp.desenho.schoolapp.presenter;

import android.content.Context;

import com.schoolapp.desenho.schoolapp.dao.ExamDAO;
import com.schoolapp.desenho.schoolapp.models.Exam;

import java.util.List;

public class ExamPresenter {
    private Context context;

    public ExamPresenter(Context context){
        this.context = context;
    }

    public List<Exam> getAllExams(Integer disciplineId){
        ExamDAO examDAO = new ExamDAO(context);
        List<Exam> allExams = examDAO.getAllExams(disciplineId);
        return allExams;
    }
}
