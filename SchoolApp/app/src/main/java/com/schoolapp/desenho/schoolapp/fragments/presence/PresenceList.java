package com.schoolapp.desenho.schoolapp.fragments.presence;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.schoolapp.desenho.schoolapp.R;
import com.schoolapp.desenho.schoolapp.databaseHelper.UserDataHelper;
import com.schoolapp.desenho.schoolapp.models.SchoolClass;
import com.schoolapp.desenho.schoolapp.models.Student;
import com.schoolapp.desenho.schoolapp.models.StudentPresence;

import java.util.ArrayList;

public class PresenceList extends ListFragment implements AdapterView.OnItemClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_presence_list, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /*
        final UserDataHelper userDH = new UserDataHelper(getActivity());
        final ArrayList<StudentPresence> studentMissedClasses= userDH.getPresenceList();

        ArrayAdapter<StudentPresence> adapter =
        new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, studentMissedClasses);

        */

        // Use fakeData for debug process
        ArrayList<StudentPresence> fakeData = new ArrayList<>();
        fakeData.add(new StudentPresence("Disciplina 1", 0));
        fakeData.add(new StudentPresence("Disciplina 2", 3));
        fakeData.add(new StudentPresence("Disciplina 3", 5));

        StudentPresenceAdapter adapter =
                new StudentPresenceAdapter(getActivity(), fakeData);

        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
    }

}
