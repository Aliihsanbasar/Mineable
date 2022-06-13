package com.mine.mineable.Activities;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.content.res.AppCompatResources;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.mine.mineable.R;

public class ForgotPasswordActivity extends AppCompatActivity {

    Button reset;
    EditText edtEmail;
    TextView txtAlreadyHaveAnAccount;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        mAuth = FirebaseAuth.getInstance();
        initComponents();
        handleSpan();

    }

    private void handleSpan() {
        SpannableString ss = new SpannableString(getResources().getString(R.string.already_have_an_account_login_here));
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                onBackPressed();
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
                ds.setColor(Color.BLUE);
            }
        };
        ss.setSpan(clickableSpan, 25, 35, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        txtAlreadyHaveAnAccount.setText(ss);
        txtAlreadyHaveAnAccount.setMovementMethod(LinkMovementMethod.getInstance());
        txtAlreadyHaveAnAccount.setHighlightColor(Color.TRANSPARENT);
    }

    private void initComponents() {
        reset = findViewById(R.id.btnReset);
        edtEmail = findViewById(R.id.edtMail);
        txtAlreadyHaveAnAccount = findViewById(R.id.txtAlreadyHaveAccount);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleResetPassword();
            }
        });

        edtEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    edtEmail.setBackground(AppCompatResources.getDrawable(ForgotPasswordActivity.this, R.drawable.editttext_frame));
                } else {
                    edtEmail.setBackground(AppCompatResources.getDrawable(ForgotPasswordActivity.this, R.drawable.disabled_frame));
                }
            }
        });
    }

    private void handleResetPassword() {
        mAuth.sendPasswordResetEmail(edtEmail.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(ForgotPasswordActivity.this, "Şifreniz sıfırlanmıştır. Lütfen mail adresinizi kontrol ediniz", Toast.LENGTH_LONG).show();
            }
        });
    }
}