package com.example.hans_xiao.stuff_exchanger;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Signup extends AppCompatActivity {

    private EditText User_name;
    private EditText User_email;
    private EditText User_password;
    private Button Sign_up;
    // private FirebaseAuth MyAuth;
    // private DatabaseReference MyDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        User_name=(EditText) findViewById(R.id.signup_email);
        User_email=(EditText) findViewById(R.id.login_password);


        ActionBar actionbar=getSupportActionBar();
        if(actionbar != null) {
            actionbar.hide();
        }
    }
}
