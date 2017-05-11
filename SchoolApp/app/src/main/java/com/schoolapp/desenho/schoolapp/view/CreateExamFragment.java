package com.schoolapp.desenho.schoolapp.view;

import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.schoolapp.desenho.schoolapp.R;
import com.schoolapp.desenho.schoolapp.models.Discipline;
import com.schoolapp.desenho.schoolapp.models.Exam;
import com.schoolapp.desenho.schoolapp.presenter.DisciplinePresenter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CreateExamFragment extends Fragment {
    private Spinner spinner;
    private TextView dateField;
    private Button saveExam;
    private EditText examTitle;
    private EditText examDescription;

    public CreateExamFragment() {
        // Required empty public constructor
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        getViews();

        // DisciplinePresenter disciplinePresenter = new DisciplinePresenter(getContext());
        // List<String> allUserDisciplinesName = disciplinePresenter.getAllDisciplinesName(0);
        List<String> allUserDisciplinesName = new ArrayList<>();
        allUserDisciplinesName.add("Orientação a Objetos");
        allUserDisciplinesName.add("Técnicas de Programação");
        allUserDisciplinesName.add("Desenvolvimento Avançado de Software");
        allUserDisciplinesName.add("Interação Humano Computador");

        ArrayAdapter testAdapter = new ArrayAdapter(this.getContext(), R.layout.spinner, allUserDisciplinesName);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(),
                android.R.layout.simple_spinner_item, allUserDisciplinesName);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(testAdapter);
        setListenerToSpinner(spinner);
        setCurrentDate(dateField);

        dateField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePickerFragment = new DatePickerFragment();

                datePickerFragment.show(getFragmentManager(), "DatePicker");
            }
        });

        saveExam.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String discipline = spinner.getSelectedItem().toString();
                String title = examTitle.getText().toString();
                String description = examDescription.getText().toString();

                DisciplinePresenter disciplinePresenter = new DisciplinePresenter(getContext());
                Discipline examDiscipline = disciplinePresenter.getDisciplineByName(userId);

                Integer disciplineId = examDiscipline.getDisciplineId();

                DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                Date date = null;
                try {
                    date = formatter.parse(dateField.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                Exam exam = new Exam(1, date, date, date, title, discipline, disciplineId, 0F, description);

            }
        });
    }

    private void getViews() {
        spinner = (Spinner) getView().findViewById(R.id.discipline_field);
        dateField = (TextView) getView().findViewById(R.id.date_field);
        saveExam = (Button) getView().findViewById(R.id.button_save_exam);
        examTitle = (EditText) getView().findViewById(R.id.title_field);
        examDescription = (EditText) getView().findViewById(R.id.description_field);
    }

    private void setCurrentDate(TextView dateField) {
        final Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);

        dateField.setText(String.format("%02d", day) + " / " + String.format("%02d", month) +
                " / " + String.format("%02d", year));
    }

    public void setListenerToSpinner(Spinner spinner){
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String discipline = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "You selected: " + discipline,
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_create_exam, container, false);
    }
}
