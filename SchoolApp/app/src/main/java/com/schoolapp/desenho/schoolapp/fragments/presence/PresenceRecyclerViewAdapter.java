package com.schoolapp.desenho.schoolapp.fragments.presence;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.schoolapp.desenho.schoolapp.R;
import com.schoolapp.desenho.schoolapp.fragments.presence.PresenceFragment.OnListFragmentInteractionListener;
import com.schoolapp.desenho.schoolapp.models.StudentPresence;

import java.util.ArrayList;


public class PresenceRecyclerViewAdapter extends RecyclerView.Adapter<PresenceRecyclerViewAdapter.ViewHolder> {

    private final ArrayList<StudentPresence> mValues;
    private final OnListFragmentInteractionListener mListener;

    public PresenceRecyclerViewAdapter(ArrayList<StudentPresence> presence, OnListFragmentInteractionListener listener) {
        mValues = presence;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_presence, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getDisciplineName());
        holder.mContentView.setText(mValues.get(position).getClassesMissed());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public StudentPresence mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
