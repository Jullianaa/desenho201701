package com.schoolapp.desenho.schoolapp.fragments.presence;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.schoolapp.desenho.schoolapp.R;
import com.schoolapp.desenho.schoolapp.models.StudentPresence;

import java.util.ArrayList;

public class PresenceListFragment extends Fragment implements AdapterView.OnItemClickListener {
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
        fakeData.add(new StudentPresence("Disciplina 2", 0));
        fakeData.add(new StudentPresence("Disciplina 3", 0));

        // Clean the discipline data
        final ArrayList<StudentPresence> cleanedList = this.getClassesWithMiss(fakeData);

        // Get the ListView
        ListView list = (ListView)getActivity().findViewById(R.id.presence_list);

        // Create and set the custom adapter for the listview
        final StudentPresenceAdapter adapter =
                new StudentPresenceAdapter(getActivity(), cleanedList);
        list.setAdapter(adapter);

        // Set a listener for each item
        list.setOnItemClickListener(this);

        // Set Layout View according to the data
        this.setLayoutByMisses(cleanedList);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
    }

    /* This function gets an StudentPresence ArrayList and return a new ArrayList with only disciplines
     * that has misses on it.
     *
     * @param ArrayList<StudentPresence> presenceList
     * @return ArrayList<StudentPresence> newList
     */
    private ArrayList<StudentPresence> getClassesWithMiss(ArrayList<StudentPresence> presenceList){
        assert presenceList != null : "NULLPOINTER found! Check getClassesWithMiss...";

        // Creates a empty presence arraylist
        ArrayList<StudentPresence> newList = new ArrayList<>();

        // Interate over the presenceList
        for(StudentPresence presenceData : presenceList){
            // If the discipline has more than 0 misses, add to the new array
            if(presenceData.getClassesMissed() > 0){
                newList.add(presenceData);
            } else{
                // DO NOTHING
            }
        }

        return newList;
    }


    /* This function defines the visibility for the ListView and TextView on the fragment, depending
     * on the available data.
     *
     * @param ArrayList<StudentPresence> presenceList
     */
    private void setLayoutByMisses (ArrayList<StudentPresence> presenceList){
        assert presenceList != null : "NULLPOINTER found! Check setLayoutByMisses...";

        // Getting the list size to define the layout
        final Integer listSize = presenceList.size();
        assert listSize >= 0 : "Invalid ArrayList size! Check setLayoutByMisses...";

        // Get the layout items to be set
        ListView list = (ListView)getActivity().findViewById(R.id.presence_list);
        TextView infoText = (TextView)getActivity().findViewById(R.id.presence_text_info);

        // Disable the info text if the data size is greater than 0
        if(listSize > 0){
            infoText.setVisibility(View.INVISIBLE);
            list.setVisibility(View.VISIBLE);
        } else {
            infoText.setVisibility(View.VISIBLE);
            list.setVisibility(View.INVISIBLE);
        }
    }
}
