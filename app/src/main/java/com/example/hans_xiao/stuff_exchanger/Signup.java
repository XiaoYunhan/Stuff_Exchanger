package com.example.hans_xiao.stuff_exchanger;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ActionBar actionbar=getSupportActionBar();
        if(actionbar != null) {
            actionbar.hide();
        }
    }
}
