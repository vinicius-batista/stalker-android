package com.example.stalker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.stalker.model.Person;
import com.example.stalker.view.PeopleListAdapter;

public class PeopleActivity extends AppCompatActivity implements PeopleListAdapter.PersonListener {

    private RecyclerView rvPeopleList;
    private PeopleListAdapter peopleListAdapter;
    public static final String PERSON_KEY = "com.example.stalker.PeopleActivity.PERSON";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

        rvPeopleList = (RecyclerView) findViewById(R.id.rvPeopleList);
        rvPeopleList.setLayoutManager(new LinearLayoutManager(this));
        rvPeopleList.setHasFixedSize(true);

        peopleListAdapter = new PeopleListAdapter(this);
        rvPeopleList.setAdapter(peopleListAdapter);
    }

    @Override
    public void onClickPersonListener(Person p) {
        Intent intent = new Intent(getBaseContext(), ShowPersonActivity.class);
        intent.putExtra(PERSON_KEY, p);
        startActivity(intent);
    }
}
