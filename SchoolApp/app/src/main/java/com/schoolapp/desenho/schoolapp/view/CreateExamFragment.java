package com.schoolapp.desenho.schoolapp.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import com.schoolapp.desenho.schoolapp.R;
import com.schoolapp.desenho.schoolapp.models.Discipline;
import com.schoolapp.desenho.schoolapp.presenter.DisciplinePresenter;

import java.util.List;

public class CreateExamFragment extends Fragment {

    public CreateExamFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_exam, container, false);
    }

    public void onClick(View clicked){
        if(clicked.getId() == R.id.discipline_field) {
            Spinner spinner = (Spinner) clicked.findViewById(R.id.discipline_field);

            DisciplinePresenter disciplinePresenter = new DisciplinePresenter(getContext());
            List<String> allUserDisciplinesName = disciplinePresenter.getAllDisciplinesName(userId);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(),
                    android.R.layout.simple_spinner_dropdown_item, allUserDisciplinesName);

            spinner.setAdapter(adapter);
            spinner.setVisibility(View.VISIBLE);

            spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String discipline = parent.getItemAtPosition(position).toString();
                    Toast.makeText(parent.getContext(), discipline, Toast.LENGTH_LONG).show();
                }
            });
        }
        else if(clicked.getId() == R.id.send_exame){

        }
    }
}
