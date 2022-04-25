package com.example.ssgs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.text.TextUtils.isEmpty;

public class MainActivity extends AppCompatActivity {
    private static final String PASSWORD_PATTERN = "^" +
            "(?=.*[0-9])" +
            "(?=.*[a-z])" +
            "(?=.*[A-Z])" +
            "(?=.*[a-zA-Z])" +
            "(?=.*[@#$%^&+=])" +
            "(?=\\S+$)" +
            ".{8,}" +
            "$";

    private Button sbmt;
    private TextInputLayout txtInputUserName;
    private TextInputLayout txtInputPassword;
    private TextInputLayout txtInputEmail;
    private TextInputLayout txtInputPhoeno;
    private TextView tvlogin;
    private TextView tvskip;
    DatabaseReference refrence;
    Register register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            getWindow().setStatusBarColor(getResources().getColor(android.R.color.white));
        sbmt = (Button) findViewById(R.id.btn_register);
        txtInputUserName = findViewById(R.id.username_login);
        txtInputPassword = findViewById(R.id.password_login_text);
        txtInputEmail = findViewById(R.id.email_login);
        tvlogin =findViewById(R.id.tvgotologin);
        tvskip =findViewById(R.id.tvgotoscheme);
        register=new Register();
        refrence = FirebaseDatabase.getInstance().getReference().child("Register");
        sbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String User=(txtInputUserName.getEditText().toString().trim());
                String Pass=(txtInputPassword.getEditText().toString().trim());
                String phoe=(txtInputPhoeno.getEditText().toString().trim());
                String Ema=(txtInputEmail.getEditText().toString().trim());
                refrence.push().setValue(register);
                Toast.makeText(MainActivity.this,"Data Inserted Succesfully",Toast.LENGTH_LONG).show();


            }
        });

//        txtInputPhoeno =findViewById(R.id.phone_no_text);

        sbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateEmail();
                validatePassword();
               validateUsername();
               validatePhoneno();
                /*if (isEmpty(txtInputEmail.getEditText().getText().toString())){
                    Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();
                    sbmt.setEnabled(false);
                }*/
                Intent intent = new Intent(MainActivity.this, Schemes.class);
                startActivity(intent);
            }
        });

        tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });

        tvskip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Schemes.class);
                startActivity(intent);
            }
        });
    }

    private boolean validateEmail() {
        String emailInput = txtInputEmail.getEditText().getText().toString().trim();
        if (emailInput.isEmpty()) {
            txtInputEmail.setError("Field Can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            txtInputEmail.setError("Please Enter Valid Email Address");
            return false;
        } else {
            txtInputEmail.setError(null);
            return true;
        }
    }

    private boolean validateUsername() {
        String usernameInput = txtInputUserName.getEditText().getText().toString().trim();

        if (usernameInput.isEmpty()) {
            txtInputUserName.setError("Field can't be empty");
            return false;
        } else if (usernameInput.length() > 15) {
            txtInputUserName.setError("Username too long");
            return false;
        } else {
            txtInputUserName.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = txtInputPassword.getEditText().getText().toString().trim();
        if (passwordInput.isEmpty()) {
            txtInputPassword.setError("Field can't be empty");
            return false;
        }
        else if ( passwordInput.length()> 8 || passwordInput.length() < 8 ){
            txtInputPassword.setError("Password must be 8 Character!!");
            return false;
        } else if (passwordInput.matches(PASSWORD_PATTERN)) {
            //txtInputPassword.setError("Password is Weak");
            return true;
        }  else {
            txtInputPassword.setError(null);
            return true;
        }
    }

    private boolean validatePhoneno() {
        String phonenoInput = txtInputPhoeno.getEditText().getText().toString().trim();

        if (phonenoInput.isEmpty()) {
            txtInputUserName.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(phonenoInput).matches()) {
            txtInputUserName.setError("Please Enter Valid Phone Number");
            return false;
        } else {
            txtInputUserName.setError(null);
            return true;
        }
    }

   public void confirmInput(View v) {
        if (!validateEmail() | !validateUsername() | !validatePassword()) {
            return;
        }
        String input = "Email: " + txtInputEmail.getEditText().getText().toString();
        input += "\n";
        input += "Username: " + txtInputUserName.getEditText().getText().toString();
        input += "\n";
        input += "Password: " + txtInputPassword.getEditText().getText().toString();

        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }

}