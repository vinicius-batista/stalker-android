package com.example.stalker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.stalker.data.DAOPerson;
import com.example.stalker.model.Person;

public class PeopleActivity extends AppCompatActivity {

    private LinearLayout lnvPeopleList;
    public static final String PERSON_KEY = "com.example.stalker.PeopleActivity.PERSON";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

        this.lnvPeopleList = (LinearLayout) findViewById(R.id.lmvPeopleList);

        this.createList();
    }

    public void createList() {
        DAOPerson daoPerson = DAOPerson.getINSTANCE();

        for (final Person person: daoPerson.getPeople()) {
            LinearLayout lnvPersonResume = (LinearLayout) getLayoutInflater().inflate(R.layout.person_resume, null);

            TextView txtFullName = lnvPersonResume.findViewById(R.id.txtFullName);
            txtFullName.setText(person.getFirstName() + " " + person.getLastName());

            TextView txtAge = lnvPersonResume.findViewById(R.id.txtAge);
            txtAge.setText(Integer.toString(person.getAge()) + R.string.years_old);

            lnvPersonResume.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
//                    Intent intent = new Intent(getBaseContext(), ShowPersonActivity.class);
//                    intent.putExtra(PERSON_KEY, person);
//                    startActivity(intent);
                }
            });

            this.lnvPeopleList.addView(lnvPersonResume);
        }
    }
}
