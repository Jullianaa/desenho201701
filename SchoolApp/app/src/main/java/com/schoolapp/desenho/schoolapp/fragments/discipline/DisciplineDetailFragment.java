package com.schoolapp.desenho.schoolapp.fragments.discipline;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.schoolapp.desenho.schoolapp.R;
import com.schoolapp.desenho.schoolapp.Utils.TaskListAdapter;
import com.schoolapp.desenho.schoolapp.dao.TaskDAO;
import com.schoolapp.desenho.schoolapp.databaseHelper.UserDataHelper;
import com.schoolapp.desenho.schoolapp.models.Student;
import com.schoolapp.desenho.schoolapp.models.Task;

import java.util.List;

public class DisciplineDetailFragment extends Fragment implements AdapterView.OnItemClickListener{

    private View view;
    private List<Task> tasks;
    private ListView tasksListView;
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
        view = inflater.inflate(R.layout.fragment_task, container, false);

        Bundle disciplineClassArguments = getArguments();
        if (disciplineClassArguments != null) {

            disciplineClassId = disciplineClassArguments.getInt("disciplineClassId");
            Log.d("DisciplineDetail Data", String.valueOf(disciplineClassId));
        }

        TaskDAO taskDAO = new TaskDAO(getContext());

        tasks = taskDAO.getTasks(disciplineClassId);
        Log.d("TaskDescription", tasks.get(0).getTaskDescription());

        TaskListAdapter taskListAdapter = new TaskListAdapter(getContext(), tasks);

        tasksListView = (ListView) container.findViewById(R.id.lv_tasks);
        tasksListView.setAdapter(taskListAdapter);

        tasksListView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> list, View view, int position, long id) {
        Task task = (Task) list.getItemAtPosition(position);
    }
}
