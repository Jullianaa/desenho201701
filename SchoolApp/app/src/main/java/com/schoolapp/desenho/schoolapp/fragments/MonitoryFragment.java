package com.schoolapp.desenho.schoolapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.schoolapp.desenho.schoolapp.R;
import com.schoolapp.desenho.schoolapp.dao.MonitoryDAO;
import com.schoolapp.desenho.schoolapp.models.Monitory;

import java.util.List;

import static com.schoolapp.desenho.schoolapp.dao.MonitoryDAO.*;

public class MonitoryFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        List<Monitory> monitories = MonitoryDAO.getMonitory() ;

        ListView Monitory = (ListView) findViewById(R.id.lista);
        ArrayAdapter<Monitory> adapter = new ArrayAdapter<Monitory>(this,
                android.R.layout.fragment_monitory, Monitory);

        listMonitory.setAdapter(adapter);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_monitory, container, false);
    }
}


