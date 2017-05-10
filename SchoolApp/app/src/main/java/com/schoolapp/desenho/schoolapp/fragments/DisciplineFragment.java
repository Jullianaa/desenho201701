package com.schoolapp.desenho.schoolapp.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.schoolapp.desenho.schoolapp.R;
import com.schoolapp.desenho.schoolapp.databaseHelper.UserDataHelper;
import com.schoolapp.desenho.schoolapp.models.Student;

public class DisciplineFragment extends Fragment {
    private Student userData;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  Set up the initial state for acessing the DB
        Activity actualActivity = getActivity();
        UserDataHelper userDH = new UserDataHelper(actualActivity);

        // Gets the user data
        this.setUserData(userDH.getUserInstance());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_discipline, container, false);
    }


    // Private setters
    private void setUserData(Student userData) {
        this.userData = userData;
    }
}
