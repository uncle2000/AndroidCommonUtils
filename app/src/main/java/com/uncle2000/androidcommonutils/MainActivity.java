package com.uncle2000.androidcommonutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.uncle2000.androidcommonutils.uitls.system.PermissionUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        PermissionUtil.requestPermissions(this, 0, android
                .Manifest.permission.WRITE_EXTERNAL_STORAGE);


    }
}