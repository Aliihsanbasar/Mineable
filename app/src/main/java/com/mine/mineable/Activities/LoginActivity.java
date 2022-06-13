package com.mine.mineable.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.content.res.AppCompatResources;

import com.google.firebase.auth.FirebaseAuth;
import com.mine.mineable.R;

public class LoginActivity extends AppCompatActivity {

    Button login;
    EditText edtEmail, edtPassword;
    TextView txtForgotPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        initComponents();

        mAuth = FirebaseAuth.getInstance();
    }

    private void initComponents() {
        login = findViewById(R.id.btnLogin);
        edtEmail = findViewById(R.id.edtMail);
        edtPassword = findViewById(R.id.edtPassword);
        txtForgotPassword = findViewById(R.id.txtForgotPassword);

        txtForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin(edtEmail.getText().toString(), edtPassword.getText().toString());
            }
        });

        edtEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    edtEmail.setBackground(AppCompatResources.getDrawable(LoginActivity.this, R.drawable.editttext_frame));
                }else{
                    edtEmail.setBackground(AppCompatResources.getDrawable(LoginActivity.this, R.drawable.disabled_frame));
                }
            }
        });

        edtPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    edtPassword.setBackground(AppCompatResources.getDrawable(LoginActivity.this, R.drawable.editttext_frame));
                }else{
                    edtPassword.setBackground(AppCompatResources.getDrawable(LoginActivity.this, R.drawable.disabled_frame));
                }
            }
        });
    }

    private void handleLogin(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Log.d("Mineable", "signInWithEmail:success");
                        //FirebaseUser user = mAuth.getCurrentUser();

                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);

                    } else {
                        Log.w("Mineable", "signInWithEmail:failure", task.getException());
                        Toast.makeText(LoginActivity.this, "Authentication failed.", Toast.LENGTH_LONG).show();
                    }
                });


    }
}