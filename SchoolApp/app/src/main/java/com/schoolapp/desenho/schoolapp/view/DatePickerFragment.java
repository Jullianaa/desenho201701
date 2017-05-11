package com.schoolapp.desenho.schoolapp.view;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import com.schoolapp.desenho.schoolapp.R;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        TextView examDate = (TextView) getActivity().findViewById(R.id.date_field);
        examDate.setText(String.format("%02d", view.getDayOfMonth()) + " / " +
                String.format("%02d", view.getMonth()) + " / " +
                String.format("%02d", view.getYear()));
    }
}