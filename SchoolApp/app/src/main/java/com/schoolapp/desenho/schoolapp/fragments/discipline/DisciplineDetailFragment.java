package com.schoolapp.desenho.schoolapp.fragments.discipline;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.schoolapp.desenho.schoolapp.R;
import com.schoolapp.desenho.schoolapp.Utils.TaskListAdapter;
import com.schoolapp.desenho.schoolapp.dao.TaskDAO;
import com.schoolapp.desenho.schoolapp.databaseHelper.UserDataHelper;
import com.schoolapp.desenho.schoolapp.models.Student;
import com.schoolapp.desenho.schoolapp.models.Task;

import java.util.ArrayList;
import java.util.List;

public class DisciplineDetailFragment extends ListFragment{

    private View view;
    private ArrayList<Task> tasks;
    private int disciplineClassId;


    public DisciplineDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_discipline_detail, container, false);

        Bundle disciplineClassArguments = getArguments();
        if (disciplineClassArguments != null) {

            disciplineClassId = disciplineClassArguments.getInt("disciplineClassId");
            Log.d("DisciplineDetail Data", String.valueOf(disciplineClassId));
        }

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        TaskDAO taskDAO = new TaskDAO(getContext());

        tasks = taskDAO.getTasks(disciplineClassId);
        Log.d("TaskDescription", tasks.get(0).getTaskDescription());

        TaskListAdapter adapter = new TaskListAdapter(getActivity(), tasks);

        setListAdapter(adapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
