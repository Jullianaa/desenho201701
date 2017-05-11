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
        DisciplineDAO disciplineDAO = new DisciplineDAO(this.context);

        ArrayList<Discipline> allDisciplines = disciplineDAO.getAllStudentDisciplines(userId);
        List<String> allDisciplinesNames = new ArrayList<>();

        for(Integer discipline=0; discipline<=allDisciplines.size(); discipline++){
            allDisciplinesNames.add(allDisciplines.get(discipline).getDisciplineName());
        }

        return allDisciplinesNames;
    }

    public Discipline getDisciplineByName(Integer userId, String disciplineName){
        Discipline theDiscipline = null;
        DisciplineDAO disciplineDAO = new DisciplineDAO(this.context);
        ArrayList<Discipline> allDisciplines = disciplineDAO.getAllStudentDisciplines(userId);

        for(int discipline=0; discipline<allDisciplines.size(); discipline++){
            if(allDisciplines.get(discipline).getDisciplineName().equals(disciplineName))
                theDiscipline = allDisciplines.get(discipline);
        }
        return theDiscipline;
    }

    public List<Discipline> allUserDisciplines(Integer userId){
        DisciplineDAO disciplineDAO = new DisciplineDAO(this.context);
        ArrayList<Discipline> userDisciplines = disciplineDAO.getAllStudentDisciplines(userId);

        return userDisciplines;
    }
}
