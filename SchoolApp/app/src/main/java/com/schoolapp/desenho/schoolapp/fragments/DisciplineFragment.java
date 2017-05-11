package com.schoolapp.desenho.schoolapp.fragments;
import java.util.ArrayList;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.schoolapp.desenho.schoolapp.R;
import com.schoolapp.desenho.schoolapp.databaseHelper.UserDataHelper;
import com.schoolapp.desenho.schoolapp.models.Student;
import com.schoolapp.desenho.schoolapp.dao.DisciplineDAO;
import com.schoolapp.desenho.schoolapp.models.Discipline;
import com.schoolapp.desenho.schoolapp.models.Student;


public class DisciplineFragment extends ListFragment {

    private Student userData;

    ArrayList<String> disciplinesName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getDisciplines();
        //  Set up the initial state for acessing the DB
        Activity actualActivity = getActivity();
        UserDataHelper userDH = new UserDataHelper(actualActivity);
        userDH.setStudent();
        // Gets the user data
        this.setUserData(userDH.getUserInstance());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_discipline, container, false);
    }


    // Private setters
    private void setUserData(Student userData) {
        this.userData = userData;
    }

    public void getDisciplines() {
        UserDataHelper userDH = new UserDataHelper(this.getActivity());
        Student student = userDH.getUserInstance();
        
        if (student!=null) {
          ArrayList<Discipline> studentDisciplines = student.getStudentDisciplines();
          ArrayList<String>  disciplines = new ArrayList<>();
          for( Discipline discipline : studentDisciplines) {
              disciplines.add(discipline.getDisciplineName());
          }
        }else{
          //nothing to do
        }
    }
}
