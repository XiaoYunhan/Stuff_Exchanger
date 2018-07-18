package com.example.hans_xiao.stuff_exchanger;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionbar=getSupportActionBar();
        if(actionbar != null) {
            actionbar.hide();
        }
        Button button_signup = (Button) findViewById(R.id.signup_button);
        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent();
            }
        });
    }
}
