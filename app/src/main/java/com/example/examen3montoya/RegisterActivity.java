package com.example.examen3montoya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    TextView textLogIn;
    MaterialButton registerButton;
    TextInputLayout inputLayoutUsername, inputLayoutEmail, inputLayoutPhoneNumber , inputLayoutPassword;
    TextInputEditText inputUsername, inputEmail,inputPhone,inputPassword;
    String textUsername, textEmail, textPhone, textPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textLogIn = findViewById(R.id.textLogIn);
        inputLayoutUsername = findViewById(R.id.username);
        inputLayoutEmail = findViewById(R.id.email);
        inputLayoutPhoneNumber = findViewById(R.id.number);
        inputLayoutPassword = findViewById(R.id.password);
        registerButton = findViewById(R.id.register_button);
        inputUsername=findViewById(R.id.input_user);
        inputEmail=findViewById(R.id.input_email);
        inputPhone=findViewById(R.id.input_number);
        inputPassword=findViewById(R.id.input_password);

        textLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textUsername=inputUsername.getText().toString();
                textEmail=inputEmail.getText().toString().trim();
                textPhone=inputPhone.getText().toString().trim();
                textPassword=inputPassword.getText().toString().trim();

                if(TextUtils.isEmpty(textUsername) || TextUtils.isEmpty(textEmail) || TextUtils.isEmpty(textPhone) ||  TextUtils.isEmpty(textPassword) ){
                    if(TextUtils.isEmpty(textUsername)) {
                        inputLayoutUsername.setError("You must fill in the field with your name");
                    } else {
                        inputLayoutUsername.setError(null);
                    }
                    if(TextUtils.isEmpty(textEmail)) {
                        inputLayoutEmail.setError("You must fill in the field with your email\n");
                    }
                    else {
                        inputLayoutEmail.setError(null);
                    }
                    if(TextUtils.isEmpty(textPhone)) {
                        inputLayoutPhoneNumber.setError("You must fill in the field with your number\n");
                    }
                    else {
                        inputLayoutPhoneNumber.setError(null);
                    }
                    if(TextUtils.isEmpty(textPassword)) {
                        inputLayoutPassword.setError("You must fill in the field with your password");
                    }
                    else {
                        inputLayoutPassword.setError(null);
                    }
                } else {

                    Snackbar sb = Snackbar.make(view, "Registered user successfully. Now log in",
                            Snackbar.LENGTH_LONG);
                    sb.setDuration(2000);
                    sb.show();
                }
            }
        });
    }
}