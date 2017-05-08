package com.schoolapp.desenho.schoolapp.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.schoolapp.desenho.schoolapp.R;


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


        return view;
    }

}
