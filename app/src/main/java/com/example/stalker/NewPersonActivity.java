package com.example.stalker;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.stalker.data.DAOPerson;
import com.example.stalker.model.Person;

public class NewPersonActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST_CODE = 223;

    private EditText ptxtFN;
    private EditText ptxtLN;
    private EditText ptxtAge;
    private EditText ptxtJob;
    private EditText ptxtBD;
    private EditText ptxtPH;
    private EditText ptxtDE;
    private ImageView imgPic;
    private Bitmap pic;

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
        this.imgPic = findViewById(R.id.imgPic);
    }

    public void takePic (View v) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, CAMERA_REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            if (extras != null && extras.containsKey("data")) {
                Bitmap bmp = (Bitmap) extras.get("data");
                imgPic.setImageBitmap(bmp);
                this.pic = bmp;
            }
        }
    }

    public void addPerson (View v) {
        String firstName = this.ptxtFN.getText().toString();
        String lastName = this.ptxtLN.getText().toString();
        String job = this.ptxtJob.getText().toString();
        String description = this.ptxtDE.getText().toString();
        int age = Integer.parseInt(this.ptxtAge.getText().toString());
        String birthday = this.ptxtBD.getText().toString();
        String phone = this.ptxtPH.getText().toString();

        Person person = new Person(firstName, lastName, job, description, age, birthday, phone, this.pic);

        DAOPerson.getINSTANCE().addPerson(person);

        finish();
    }
}
