package com.itroots.android_tests.Fragments;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.itroots.android_tests.R;

import static android.content.ContentValues.TAG;

public class BluetoothFragment extends Fragment {

    Button btnBluetoothFragment;
    private static final int REQUEST_ENABLE_BT = 0;
    private static final int REQUEST_DISCOVERABLE_BT = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_bluetooth, container, false);
        btnBluetoothFragment=(Button) root.findViewById(R.id.btnBluetoothFragment);
        btnBluetoothFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                if (mBluetoothAdapter == null) {
                    Toast.makeText(getActivity().getApplicationContext(), "device not supported" , Toast.LENGTH_LONG);
                }
                else {
                    if (!mBluetoothAdapter.isEnabled()) {
                        Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                        startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
                    }
                    //
                    if (!mBluetoothAdapter.isDiscovering()) {
                        //out.append("MAKING YOUR DEVICE DISCOVERABLE");
                        Toast.makeText(getActivity().getApplicationContext(), "MAKING YOUR DEVICE DISCOVERABLE", Toast.LENGTH_LONG);

                        Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                        final BroadcastReceiver mReceiver = new BroadcastReceiver() {
                            @Override
                            public void onReceive(Context context, Intent intent) {
                                String action = intent.getAction();

                                // When discovery finds a device
                                if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                                    //do something
                                } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
                                    Log.v(TAG, "Entered the Finished ");
                                    mBluetoothAdapter.startDiscovery();
                                }
                            }
                        };


                        startActivityForResult(enableBtIntent, REQUEST_DISCOVERABLE_BT);

                    }
                }


            }
        });

        return root;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
