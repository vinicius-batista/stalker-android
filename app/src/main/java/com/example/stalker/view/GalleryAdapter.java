package com.example.stalker.view;


import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.stalker.R;

import java.util.ArrayList;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryViewHolder> {

    private ArrayList<Bitmap> picList;
    private GalleryListener galleryListener;

    public GalleryAdapter(GalleryListener galleryListener) {
        this.galleryListener = galleryListener;
        this.picList = new ArrayList<>();
    }

    public void setPicList(ArrayList<Bitmap> picList) {
        this.picList = picList;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.view_holder_gallery, viewGroup, false);
        return new GalleryViewHolder(view, this.galleryListener);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder galleryViewHolder, int i) {
        galleryViewHolder.bind(this.picList.get(i));
    }

    @Override
    public int getItemCount() {
        return this.picList.size();
    }

    public interface GalleryListener {
        void onClickPhoto(Bitmap pic);
    }
}