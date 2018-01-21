package com.mortgagehotline.manager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login_Activity extends AppCompatActivity {

    Button loginbtn;
    TextView forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginbtn = findViewById(R.id.lgnbtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activityChangeIntent = new Intent(Login_Activity.this, MainActivity.class);
                Login_Activity.this.startActivity(activityChangeIntent);
            }
        });

        forgotPassword = findViewById(R.id.fgtPass);
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent fPassword_intent = new Intent(Login_Activity.this, ForgotPasswordActivity.class);
                startActivity(fPassword_intent);
            }
        });

    }


}
