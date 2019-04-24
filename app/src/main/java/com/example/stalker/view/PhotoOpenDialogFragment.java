package com.example.stalker.view;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.stalker.R;

public class PhotoOpenDialogFragment extends DialogFragment {
    private ImageView imgOpenPic;
    private Bitmap bmp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_fragment_photo_open, container, false);
        imgOpenPic = view.findViewById(R.id.imgOpenPic);
        imgOpenPic.setImageBitmap(this.bmp);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = this.getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }
    }

    public void setBitmap(Bitmap bmp) {
        this.bmp = bmp;
    }
}