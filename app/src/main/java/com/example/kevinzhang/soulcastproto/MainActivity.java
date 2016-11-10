package com.example.kevinzhang.soulcastproto;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @NeedsPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    void setUpLocation(){

    }

    @NeedsPermission(Manifest.permission.RECORD_AUDIO)
    void setUpAudioRecorder(){

    }

    @NeedsPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void setUpStorage(){

    }

    @OnPermissionDenied(Manifest.permission.ACCESS_FINE_LOCATION)
    void showLocationPermissionDenied(){

    }

    @OnPermissionDenied(Manifest.permission.RECORD_AUDIO)
    void showAudioPermissionDenied(){

    }

    @OnPermissionDenied(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void showStoragePermissionDenied(){

    }

}
