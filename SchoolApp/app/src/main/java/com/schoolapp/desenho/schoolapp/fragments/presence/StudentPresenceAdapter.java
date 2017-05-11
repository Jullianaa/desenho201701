package com.schoolapp.desenho.schoolapp.fragments.presence;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.schoolapp.desenho.schoolapp.R;
import com.schoolapp.desenho.schoolapp.models.StudentPresence;

import java.util.ArrayList;

public class StudentPresenceAdapter extends ArrayAdapter<StudentPresence> {
    public StudentPresenceAdapter (Context context, ArrayList<StudentPresence> presenceData) {
        super(context, 0, presenceData);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        StudentPresence presence = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_presence, parent, false);
        }

        // Lookup view for data population
        TextView disciplineName = (TextView) convertView.findViewById(R.id.discipline_name);
        TextView missedCount = (TextView) convertView.findViewById(R.id.missed_count);

        // Populate the data into the template view using the data object
        disciplineName.setText(presence.getDisciplineName());
        missedCount.setText(presence.getClassesMissed().toString());

        // Return the completed view to render on screen
        return convertView;
    }
}