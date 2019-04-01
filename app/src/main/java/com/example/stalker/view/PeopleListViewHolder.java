package com.example.stalker.view;

import android.support.annotation.NonNull;
import android.view.View;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.stalker.R;
import com.example.stalker.model.Person;

public class PeopleListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView txtName;
    private TextView txtAge;
    private Person person;
    private PeopleListAdapter.PersonListener listener;

    public PeopleListViewHolder(@NonNull View itemView, PeopleListAdapter.PersonListener listener) {
        super(itemView);
        this.txtName = (TextView) itemView.findViewById(R.id.txtFullName);
        this.txtAge = (TextView) itemView.findViewById(R.id.txtAge);
        this.listener = listener;
        itemView.setOnClickListener(this);
    }

    public void bind (Person p) {
        this.txtName.setText(p.getFirstName() + " " + p.getLastName());
        this.txtAge.setText(Integer.toString(p.getAge()));
        this.person = p;
    }

    @Override
    public void onClick(View v) {
        listener.onClickPersonListener(this.person);
    }
}
