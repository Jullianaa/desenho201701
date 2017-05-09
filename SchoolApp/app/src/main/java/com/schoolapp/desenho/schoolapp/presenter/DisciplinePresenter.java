package com.schoolapp.desenho.schoolapp.presenter;

import android.content.Context;
import com.schoolapp.desenho.schoolapp.dao.DisciplineDAO;
import com.schoolapp.desenho.schoolapp.models.Discipline;

import java.util.ArrayList;
import java.util.List;

public class DisciplinePresenter {
    private Context context;

    public DisciplinePresenter(Context context){
        this.context = context;
    }

    public List<String> getAllDisciplinesName(Integer userId){
        List<Discipline> allDisciplines = this.getAllDisciplines(userId);
        List<String> allDisciplinesNames = new ArrayList<>();

        for(Integer discipline=0; discipline<=allDisciplines.size(); discipline++){
            allDisciplinesNames.add(allDisciplines.get(discipline).getDisciplineName());
        }

        return allDisciplinesNames;
    }

    public List<Discipline> getAllDisciplines(Integer userId) {
        DisciplineDAO disciplineDAO = new DisciplineDAO(this.context);

        ArrayList<Discipline> allDisciplines = disciplineDAO.getAllStudentDisciplines(userId);

        return allDisciplines;

    }
}
