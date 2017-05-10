package com.schoolapp.desenho.schoolapp.fragments.discipline;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.schoolapp.desenho.schoolapp.R;
import com.schoolapp.desenho.schoolapp.Utils.TaskListAdapter;
import com.schoolapp.desenho.schoolapp.models.Task;

import java.util.List;

public class DisciplineDetailFragment extends Fragment {

    private View view;
    private List<Task> tasks;
    private ListView tasksListView;

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

        TaskListAdapter taskListAdapter = new TaskListAdapter(getContext(), tasks);

        return view;
    }
}
