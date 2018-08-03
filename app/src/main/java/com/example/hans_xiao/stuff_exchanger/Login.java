package com.example.hans_xiao.stuff_exchanger;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class Login extends AppCompatActivity {

    private static final int RC_SIGN_IN = 123;
    private FirebaseAuth MyAuth = (FirebaseAuth) FirebaseAuth.getInstance();
    private EditText login_email = (EditText) findViewById(R.id.login_email);
    private  EditText login_password = (EditText) findViewById(R.id.login_password);
    private  Button button_login =(Button) findViewById(R.id.login_button);
    private  Button button_signup = (Button) findViewById(R.id.signup_button);
    private  ProgressBar login_progress = (ProgressBar)findViewById(R.id.progress_bar);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //ActionBar actionbar=getSupportActionBar();
        //if(actionbar != null) {
        //    actionbar.hide();
        //}



        login_progress.setVisibility(View.INVISIBLE);

        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(Login.this, Signup.class);
            }
        });
        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(Login.this, MainActivity.class);

            }
        });
        // Choose authentication providers
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.PhoneBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build(),
                new AuthUI.IdpConfig.FacebookBuilder().build(),
                new AuthUI.IdpConfig.TwitterBuilder().build());

// Create and launch sign-in intent
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                RC_SIGN_IN);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                // ...
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
    }


    private void startSignIn() {
        String email = login_email.getText().toString();
        String password = login_password.getText().toString();
        //prevent user from leaving the text-field blank
        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            login_progress.setVisibility(View.GONE);
            Toast.makeText(Login.this, "Email and password can not be empty", Toast.LENGTH_LONG).show();
        } else {
            //proceed sign in operation
            MyAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!task.isSuccessful()) {
                        login_progress.setVisibility(View.GONE);
                        Toast.makeText(Login.this, "Sign In Problem", Toast.LENGTH_LONG).show();
                    }
                    login_progress.setVisibility(View.GONE);
                    Intent mainIntent = new Intent(Login.this, MainActivity.class);
                    mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(mainIntent);
                }
            });
        }

    }
}