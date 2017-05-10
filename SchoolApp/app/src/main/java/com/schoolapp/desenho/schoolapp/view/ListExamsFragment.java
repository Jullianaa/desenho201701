package com.schoolapp.desenho.schoolapp.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.schoolapp.desenho.schoolapp.R;
import com.schoolapp.desenho.schoolapp.models.Exam;
import com.schoolapp.desenho.schoolapp.presenter.ExamPresenter;

import java.util.List;


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

}
