package com.itroots.android_tests;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.itroots.android_tests.Fragments.cameraFragment;

public class MainActivity extends AppCompatActivity {

    Button btnCamera;
    Button btnBluetooth;
    public static int showSuitableFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        btnCamera = (Button) findViewById(R.id.btnCamera);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSuitableFragment = 1;
                OpenHomeActivity();
            }
        });
        //
        btnBluetooth = (Button) findViewById(R.id.btnBluetooth);
        btnBluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSuitableFragment = 2;
                OpenHomeActivity();
            }
        });
        //

    }

    public void OpenHomeActivity(){
        Intent intent = new Intent(MainActivity.this , HomeActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume(){
        super.onResume();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
