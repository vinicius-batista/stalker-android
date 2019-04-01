package com.example.stalker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stalker.model.Person;

public class ShowPersonActivity extends AppCompatActivity {

    private TextView txtFNR;
    private TextView txtLNR;
    private TextView txtBDR;
    private TextView txtJR;
    private TextView txtAR;
    private TextView txtDER;
    private TextView txtPHR;
    private ImageView imgPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_person);

        this.txtFNR = findViewById(R.id.txtFNR);
        this.txtLNR = findViewById(R.id.txtLNR);
        this.txtBDR = findViewById(R.id.txtBDR);
        this.txtJR = findViewById(R.id.txtJR);
        this.txtAR = findViewById(R.id.txtAR);
        this.txtDER = findViewById(R.id.txtDER);
        this.txtPHR = findViewById(R.id.txtPHR);
        this.imgPic = findViewById(R.id.imgPic);

        Person person = getIntent().getParcelableExtra(PeopleActivity.PERSON_KEY);

        this.txtFNR.setText(person.getFirstName());
        this.txtLNR.setText(person.getLastName());
        this.txtBDR.setText(person.getBirthday());
        this.txtAR.setText(Integer.toString(person.getAge()));
        this.txtJR.setText(person.getJob());
        this.txtDER.setText(person.getDescription());
        this.txtPHR.setText(person.getPhone());
        this.imgPic.setImageBitmap(person.getPic());
    }
}
