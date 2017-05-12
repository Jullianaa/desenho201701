package com.schoolapp.desenho.schoolapp.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.schoolapp.desenho.schoolapp.R;
import com.schoolapp.desenho.schoolapp.fragments.discipline.DisciplineDetailFragment;
import com.schoolapp.desenho.schoolapp.fragments.discipline.DisciplineFragment;
import com.schoolapp.desenho.schoolapp.fragments.examGrade.CreateExamGrade;
import com.schoolapp.desenho.schoolapp.fragments.HomeFragment;
import com.schoolapp.desenho.schoolapp.fragments.discipline.SearchDisciplinesFragment;
import com.schoolapp.desenho.schoolapp.fragments.TaskFragment;
import com.schoolapp.desenho.schoolapp.fragments.presence.PresenceListFragment;
import com.schoolapp.desenho.schoolapp.view.CreateExamFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, DisciplineFragment.InterfaceCommunication {

    private Fragment newFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        HomeFragment firstFragment = new HomeFragment();
        newFragment = firstFragment;

        // Add the fragment to the 'fragment_container' FrameLayout
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, firstFragment).commit();
    }

    @Override
    public void onBackPressed() {

        // The count below is never used
        //int count = getFragmentManager().getBackStackEntryCount();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Bundle is used to send data to the current fragment
        Bundle args = new Bundle();

        newFragment = null;

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            newFragment = new SearchDisciplinesFragment();
        } else if (id == R.id.nav_gallery) {
            newFragment = new CreateExamFragment();
        } else if (id == R.id.nav_slideshow) {
            newFragment = new TaskFragment();
        } else if (id == R.id.nav_manage) {
            newFragment = new DisciplineFragment();
        } else if (id == R.id.nav_exams_grade){
            newFragment = new CreateExamGrade();
        } else if(id == R.id.nav_presence){
            newFragment = new PresenceListFragment();
        } else {
            // Nothing to do.
        }

        newFragment.setArguments(args);
        transaction.replace(R.id.fragment_container, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void getDisciplineClassId(int disciplineClassId){
        DisciplineDetailFragment disciplineDetailFragment = new DisciplineDetailFragment();

        Bundle disciplineClassArguments = new Bundle();

        disciplineClassArguments.putInt("disciplineClassId", disciplineClassId);
        disciplineDetailFragment.setArguments(disciplineClassArguments);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, disciplineDetailFragment);
        transaction.commit();
    }
}
