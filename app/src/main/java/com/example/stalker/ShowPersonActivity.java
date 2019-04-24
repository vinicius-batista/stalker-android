package com.example.stalker;

import android.graphics.Bitmap;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stalker.model.Person;
import com.example.stalker.view.GalleryAdapter;
import com.example.stalker.view.PhotoOpenDialogFragment;

public class ShowPersonActivity extends AppCompatActivity implements GalleryAdapter.GalleryListener {

    private TextView txtFNR;
    private TextView txtLNR;
    private TextView txtBDR;
    private TextView txtJR;
    private TextView txtAR;
    private TextView txtDER;
    private TextView txtPHR;
    private RecyclerView rvGallery;
    private PhotoOpenDialogFragment photoOpenDialogFragment;
    private GalleryAdapter galleryAdapter;

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

        this.createGallery();
        this.photoOpenDialogFragment = new PhotoOpenDialogFragment();

        Person person = getIntent().getParcelableExtra(PeopleActivity.PERSON_KEY);

        this.txtFNR.setText(person.getFirstName());
        this.txtLNR.setText(person.getLastName());
        this.txtBDR.setText(person.getBirthday());
        this.txtAR.setText(Integer.toString(person.getAge()));
        this.txtJR.setText(person.getJob());
        this.txtDER.setText(person.getDescription());
        this.txtPHR.setText(person.getPhone());
        this.galleryAdapter.setPicList(person.getPictures());
    }

    private void createGallery() {
        this.rvGallery = (RecyclerView) this.findViewById(R.id.rvGalleryShow);
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

    @Override
    public void onClickPhoto(Bitmap pic) {
        this.photoOpenDialogFragment.setBitmap(pic);
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        this.photoOpenDialogFragment.show(fragmentManager, "showpic");
    }
}
