package com.example.stalker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.stalker.data.DAOPerson;
import com.example.stalker.model.Person;

public class NewPersonActivity extends AppCompatActivity {

    private EditText ptxtFN;
    private EditText ptxtLN;
    private EditText ptxtAge;
    private EditText ptxtJob;
    private EditText ptxtBD;
    private EditText ptxtPH;
    private EditText ptxtDE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_person);

        this.ptxtFN = findViewById(R.id.ptxtFN);
        this.ptxtLN = findViewById(R.id.ptxtLN);
        this.ptxtAge = findViewById(R.id.ptxtAge);
        this.ptxtJob = findViewById(R.id.ptxtJob);
        this.ptxtBD = findViewById(R.id.ptxtBD);
        this.ptxtPH = findViewById(R.id.ptxtPH);
        this.ptxtDE = findViewById(R.id.ptxtDE);
    }

    public void addPerson (View v) {
        String firstName = this.ptxtFN.getText().toString();
        String lastName = this.ptxtLN.getText().toString();
        String job = this.ptxtJob.getText().toString();
        String description = this.ptxtDE.getText().toString();
        int age = Integer.parseInt(this.ptxtAge.getText().toString());
        String birthday = this.ptxtBD.getText().toString();
        String phone = this.ptxtPH.getText().toString();

        Person person = new Person(firstName, lastName, job, description, age, birthday, phone);

        DAOPerson.getINSTANCE().addPerson(person);

        finish();
    }
}
