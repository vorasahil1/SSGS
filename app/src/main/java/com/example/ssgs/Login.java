package com.example.ssgs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    private Button sbmt;
    private TextInputLayout logtxtInputUserName;
    private TextInputLayout logtxtInputPassword;
    private TextInputLayout logtxtInputEmail;
    private TextView tvregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tvregister=findViewById(R.id.tvgotoregister);
        tvregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private boolean validateUsername() {
        String usernameInput = logtxtInputUserName.getEditText().getText().toString().trim();

        if (usernameInput.isEmpty()) {
            logtxtInputUserName.setError("Field can't be empty");
            return false;
        } else if (usernameInput.length() > 15) {
            logtxtInputUserName.setError("Username too long");
            return false;
        } else {
            logtxtInputUserName.setError(null);
            return true;
        }
    }
}
