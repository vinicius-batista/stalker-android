package com.example.stalker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickNew (View v) {
        Intent intent = new Intent(getBaseContext(), NewPersonActivity.class);
        startActivity(intent);
    }

    public void onClickList (View v) {
        Intent intent = new Intent(getBaseContext(), PeopleActivity.class);
        startActivity(intent);
    }
}
