package com.schoolapp.desenho.schoolapp.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.schoolapp.desenho.schoolapp.R;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.schoolapp.desenho.schoolapp.models.Exam;
import com.schoolapp.desenho.schoolapp.presenter.ExamPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class ListExamsFragment extends Fragment {

    public ListExamsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_exams, container, false);

        ListView examList = (ListView) view.findViewById(R.id.lista);
        ExamPresenter examPresenter = new ExamPresenter(getContext());
        List<Exam> allDisciplines = examPresenter.getAllExams(1);
        ArrayAdapter<Exam> adapter = new ArrayAdapter<Exam>(this.getContext(),
                android.R.layout.simple_list_item_1, allDisciplines);
        examList.setAdapter(adapter);
        return view;
    }

    // Create dropdown for choose filter to find exams
    public void onClick(View clicked){
        Spinner spinner = (Spinner) clicked.findViewById(R.id.filteroption_field);

        List<String> filterOptions = new ArrayList<String>();
        filterOptions.add("Por Data");
        filterOptions.add("Por Disciplina");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(),
                android.R.layout.simple_spinner_dropdown_item, filterOptions);


    }

}
