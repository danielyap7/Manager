package com.mortgagehotline.manager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Profile_Activity extends AppCompatActivity {

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Profile");
        actionBar.setDisplayShowTitleEnabled(true);

        Button pwdupdate = (Button) findViewById(R.id.pwdUpdateButton);

        pwdupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText Chgpwd = (EditText) findViewById(R.id.PasswordEdit);
                EditText ChgConfirmpwd = (EditText) findViewById(R.id.ConfirmPasswordEdit);

                String password = Chgpwd.getText().toString();
                String confirm_password = ChgConfirmpwd.getText().toString();

                Boolean validPassword = passwordvalidation(password, confirm_password);

                if(validPassword){
                    Toast.makeText(getApplicationContext(),"Password Valid " + password, Toast.LENGTH_SHORT).show();
                }
                
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int actionID = item.getItemId();

        switch (actionID){
            case android.R.id.home:
                onBackPressed();
                return true;

            case R.id.miProfile:
                Intent intent = new Intent(Profile_Activity.this, ForgotPasswordActivity.class);
                startActivity(intent);
                return true;
        }

        return false;
    }

    protected boolean passwordvalidation(String password, String confirm_password){

        Boolean isValid = false;
        Pattern pattern;
        Matcher matcher;
        Matcher confirm_matcher;


        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        if(password.equals("") || confirm_password.equals("")){

            alert.setMessage("Please Enter Password/Confirm Password")
                    .setTitle("Invalid Password")
                    .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create()
                    .show();

        } else if(!password.equals(confirm_password)){

            alert.setMessage("Password not match!!")
                    .setTitle("Invalid Password")
                    .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create()
                    .show();

        } else if(password.contains(" ")|| confirm_password.contains(" ")){

            alert.setMessage("Password Could not Contain Spacing")
                    .setTitle("Invalid Password")
                    .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create()
                    .show();

        } else if(password.length() < 7 || confirm_password.length() < 7){
            alert.setMessage("Password must at lease contain 7 characters")
                    .setTitle("Invalid Password")
                    .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create()
                    .show();
        }else{
            Toast.makeText(getApplicationContext(), "Password: " + password + " Validated" ,Toast.LENGTH_SHORT).show();
            isValid = true;
        }


        return isValid;
    }

}
