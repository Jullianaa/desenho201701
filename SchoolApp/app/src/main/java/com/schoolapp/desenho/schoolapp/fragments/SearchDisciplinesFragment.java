package com.schoolapp.desenho.schoolapp.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.schoolapp.desenho.schoolapp.R;
import com.schoolapp.desenho.schoolapp.dao.DisciplineDAO;
import com.schoolapp.desenho.schoolapp.models.Discipline;

import java.util.ArrayList;

public class SearchDisciplinesFragment extends ListFragment {

    ArrayAdapter adapter;
    ArrayList<String> disciplinesName;
    DisciplineDAO disciplineDAO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_disciplines, container, false);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.getDisciplinesName();

        adapter = new ArrayAdapter(
                getActivity(),
                android.R.layout.simple_list_item_1,
                disciplinesName
        );
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search_disciplines, menu);
        MenuItem searchItem = menu.findItem(R.id.menuSearchDisciplines);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                return false;
            }
        });

        super.onCreateOptionsMenu(menu, inflater);
    }

    public void getDisciplinesName() {
        disciplineDAO = new DisciplineDAO(SearchDisciplinesFragment.this.getActivity());
        ArrayList<Discipline> allDisciplines = disciplineDAO.getAllDisciplines();
        disciplinesName = new ArrayList<>();
        for( Discipline discipline : allDisciplines) {
            disciplinesName.add(discipline.getDisciplineName());
        }

    }
}
