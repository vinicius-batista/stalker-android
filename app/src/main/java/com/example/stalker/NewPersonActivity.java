package com.example.stalker;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.stalker.data.DAOPerson;
import com.example.stalker.model.Person;
import com.example.stalker.view.GalleryAdapter;
import com.example.stalker.view.PhotoOpenDialogFragment;

import java.util.ArrayList;

public class NewPersonActivity extends AppCompatActivity implements GalleryAdapter.GalleryListener {

    private static final int CAMERA_REQUEST_CODE = 223;

    private EditText ptxtFN;
    private EditText ptxtLN;
    private EditText ptxtAge;
    private EditText ptxtJob;
    private EditText ptxtBD;
    private EditText ptxtPH;
    private EditText ptxtDE;
    private RecyclerView rvGallery;
    private GalleryAdapter galleryAdapter;
    private PhotoOpenDialogFragment photoOpenDialogFragment;
    private ArrayList<Bitmap> pictures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_person);

        this.createGallery();
        this.photoOpenDialogFragment = new PhotoOpenDialogFragment();
        this.pictures = new ArrayList<>();

        this.ptxtFN = findViewById(R.id.ptxtFN);
        this.ptxtLN = findViewById(R.id.ptxtLN);
        this.ptxtAge = findViewById(R.id.ptxtAge);
        this.ptxtJob = findViewById(R.id.ptxtJob);
        this.ptxtBD = findViewById(R.id.ptxtBD);
        this.ptxtPH = findViewById(R.id.ptxtPH);
        this.ptxtDE = findViewById(R.id.ptxtDE);

    }

    private void createGallery() {
        this.rvGallery = (RecyclerView) this.findViewById(R.id.rvGalleryAdd);
        this.galleryAdapter = new GalleryAdapter(this);

        Display display = this.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int spanCount = (int) Math.ceil(dpWidth / 100);

        this.rvGallery.setLayoutManager(new GridLayoutManager(this, spanCount));
        this.rvGallery.setHasFixedSize(true);
        this.rvGallery.setAdapter(this.galleryAdapter);
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
                this.pictures.add(bmp);
                this.galleryAdapter.setPicList(this.pictures);
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

        Person person = new Person(firstName, lastName, job, description, age, birthday, phone, this.pictures);

        DAOPerson.getINSTANCE().addPerson(person);

        finish();
    }

    @Override
    public void onClickPhoto(Bitmap pic) {
        this.photoOpenDialogFragment.setBitmap(pic);
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        this.photoOpenDialogFragment.show(fragmentManager, "showpic");
    }
}
