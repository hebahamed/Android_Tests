package com.itroots.android_tests;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.itroots.android_tests.Fragments.BluetoothFragment;
import com.itroots.android_tests.Fragments.cameraFragment;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //
        if(MainActivity.showSuitableFragment == 1){
            cameraFragment cam_fragment = new cameraFragment();
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.contentFragment, cam_fragment).commit();
        }
        else if(MainActivity.showSuitableFragment == 2){
            BluetoothFragment bluetooth_fragment = new BluetoothFragment();
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.contentFragment, bluetooth_fragment).commit();
        }
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
