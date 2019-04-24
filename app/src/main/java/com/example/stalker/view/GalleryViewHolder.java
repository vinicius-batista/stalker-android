package com.example.stalker.view;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.stalker.R;

public class GalleryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ImageView imgPic;
    private GalleryAdapter.GalleryListener galleryListener;
    private Bitmap pic;

    public GalleryViewHolder(@NonNull View itemView, GalleryAdapter.GalleryListener galleryListener) {
        super(itemView);
        this.imgPic = (ImageView) itemView.findViewById(R.id.imgPic);
        itemView.setOnClickListener(this);
        this.galleryListener = galleryListener;
    }


    public void bind(Bitmap pic) {
        this.pic = pic;
        imgPic.setImageBitmap(pic);
    }

    @Override
    public void onClick(View v) {
        this.galleryListener.onClickPhoto(this.pic);
    }
}