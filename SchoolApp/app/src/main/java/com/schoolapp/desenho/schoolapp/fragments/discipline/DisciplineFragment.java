package com.schoolapp.desenho.schoolapp.fragments.discipline;

import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.schoolapp.desenho.schoolapp.R;
import com.schoolapp.desenho.schoolapp.dao.DisciplineClassDAO;
import com.schoolapp.desenho.schoolapp.dao.DisciplineDAO;
import com.schoolapp.desenho.schoolapp.dao.TaskDAO;
import com.schoolapp.desenho.schoolapp.databaseHelper.UserDataHelper;
import com.schoolapp.desenho.schoolapp.models.Discipline;
import com.schoolapp.desenho.schoolapp.models.Student;
import com.schoolapp.desenho.schoolapp.models.DisciplineClass;
import com.schoolapp.desenho.schoolapp.models.Task;


public class DisciplineFragment extends ListFragment {

    private Student userData;
    private ArrayAdapter adapter;
    private ArrayList<String> disciplinesName;
    private ArrayList<DisciplineClass> studentDisciplineClasses;

    // Communication between PhotoFragment and EventMapFragment
    private InterfaceCommunication mListener;

    public interface InterfaceCommunication {
        void getDisciplineClassId(int disciplineClassId);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (InterfaceCommunication) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement " +
                    "OnArticleSelectedListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        studentDisciplineClasses = new ArrayList<DisciplineClass>();
        this.getDisciplinesName();
        //this.getDisciplines();
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
        View view = inflater.inflate(R.layout.fragment_discipline, container, false);

        adapter = new ArrayAdapter(
                getActivity(),
                android.R.layout.simple_list_item_1,
                disciplinesName
        );
        setListAdapter(adapter);

        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
        Log.d("Posicao Disciplina", String.valueOf(position));


        Log.d("Id DisciplineClass", studentDisciplineClasses.get(position).getDisciplineClassId().toString());
        mListener.getDisciplineClassId(studentDisciplineClasses.get(position).getDisciplineClassId());
    }


    // Private setters
    private void setUserData(Student userData) {
        this.userData = userData;
    }


    public void getDisciplinesName() {
        DisciplineDAO disciplineDAO = new DisciplineDAO(getContext());
        Discipline disciplineU = disciplineDAO.getDiscipline(1);
        disciplineU.setStudentId(1);
        disciplineDAO.updateDiscipline(disciplineU);
        Log.d("Discipline StudentId", disciplineDAO.getDiscipline(1).getStudentId().toString());

        DisciplineClassDAO disciplineClassDAO = new DisciplineClassDAO(getContext());
        DisciplineClass disciplineClass = disciplineClassDAO.getDisciplineClass(1);
        disciplineClass.setStudentId(1);
        disciplineClassDAO.updateDisciplineClass(disciplineClass);
        Log.d("DC StudentId", disciplineClassDAO.getDisciplineClass(1).getDisciplineClassId().toString());

        TaskDAO taskDAO = new TaskDAO(getContext());
        Task task = new Task(1,new Date(), new Date(), new Date(), "Inferno", 1, "Cultuar o Demônio");
        taskDAO.saveTask(task);
        Log.d("TaskSaved", taskDAO.getTask(1).getTaskDescription());

        ArrayList<Discipline> allDisciplines = disciplineDAO.getAllStudentDisciplines(1);
        disciplinesName = new ArrayList<>();
        for( Discipline discipline : allDisciplines) {
            disciplinesName.add(discipline.getDisciplineName());
            Log.d("DisciplineId", discipline.getDisciplineId().toString());
            DisciplineClass currentDisciplineClass = disciplineClassDAO.getCurrentStudentDisciplineClass(1,discipline.getDisciplineId());
            studentDisciplineClasses.add(currentDisciplineClass);
        }

    }

//    public void getDisciplines() {
//        UserDataHelper userDH = new UserDataHelper(this.getActivity());
//        Student student = userDH.getUserInstance();
//
//        if (student!=null) {
//          ArrayList<Discipline> studentDisciplines = student.getStudentDisciplines();
//          ArrayList<String>  disciplines = new ArrayList<>();
//          for( Discipline discipline : studentDisciplines) {
//              disciplines.add(discipline.getDisciplineName());
//          }
//        }else{
//          //nothing to do
//        }
//    }
}
