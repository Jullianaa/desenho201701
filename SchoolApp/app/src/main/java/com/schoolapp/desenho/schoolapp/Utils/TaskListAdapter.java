package com.schoolapp.desenho.schoolapp.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.schoolapp.desenho.schoolapp.R;
import com.schoolapp.desenho.schoolapp.models.Task;

import java.util.List;

public class TaskListAdapter extends ArrayAdapter<Task> {

    private final Context context;
    private List<Task> tasks;
    private LayoutInflater inflater;

    public TaskListAdapter(Context context, List<Task> tasks) {
        super(context, R.layout.task_list, tasks);

        this.context = context;
        this.tasks = tasks;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View taskListViewItem = inflater.inflate(R.layout.task_list,null,true);

        TextView tvTask = (TextView) taskListViewItem.findViewById(R.id.tl_task_name);
        TextView tvDate = (TextView) taskListViewItem.findViewById(R.id.tl_task_date);

        tvTask.setText(tasks.get(position).getTaskDescription());
        tvDate.setText(tasks.get(position).getDateEvent().toString());

        return convertView;
    }
}
