package com.schoolapp.desenho.schoolapp.fragments.examGrade;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.schoolapp.desenho.schoolapp.R;

public class CreateExamGrade extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_create_exam_grade, container, false);
    }
}
