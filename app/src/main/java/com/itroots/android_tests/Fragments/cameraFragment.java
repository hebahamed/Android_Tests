package com.itroots.android_tests.Fragments;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.itroots.android_tests.Classes.ImagePicker;
import com.itroots.android_tests.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class cameraFragment extends Fragment {

    Button btnCameraFragment;
    ImageView iv;
    int PICK_IMAGE_ID = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        Log.i("heba = " ,"onCreateView");
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_camera, container, false);
        btnCameraFragment=(Button) root.findViewById(R.id.btnCameraFragment);
        iv=(ImageView) root.findViewById(R.id.imageViewCameraFragment);

        btnCameraFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent chooseImageIntent = ImagePicker.getPickImageIntent(getActivity().getApplicationContext());
                startActivityForResult(chooseImageIntent, PICK_IMAGE_ID);
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        Log.i("heba = " ,"onActivityCreated");
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("heba = " ,"onActivityResult");
        if (requestCode == PICK_IMAGE_ID){
            Bitmap bitmap = ImagePicker.getImageFromResult(getActivity().getApplicationContext(), resultCode, data);
            iv.setImageBitmap(bitmap);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onResume(){
        super.onResume();
        Log.i("heba = " ,"onResumeFragment");
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

}
