package com.schoolapp.desenho.schoolapp.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.schoolapp.desenho.schoolapp.R;
import com.schoolapp.desenho.schoolapp.models.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskListAdapter extends ArrayAdapter<Task> {

    private ArrayList<Task> tasks;

    public TaskListAdapter(Context context, ArrayList<Task> tasks) {
        super(context, 0, tasks);
        this.tasks = tasks;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.task_list, parent, false);
        }

        TextView tvTask = (TextView) convertView.findViewById(R.id.tl_task_name);
        TextView tvDate = (TextView) convertView.findViewById(R.id.tl_task_date);

        tvTask.setText(tasks.get(position).getTaskDescription());
        tvDate.setText(tasks.get(position).getDateEvent().toString());

        return convertView;
    }
}
