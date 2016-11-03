package com.blueeagle.migrainebuddyui.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.blueeagle.migrainebuddyui.ButtonUtil;
import com.blueeagle.migrainebuddyui.Constants.Constants;
import com.blueeagle.migrainebuddyui.R;
import com.blueeagle.migrainebuddyui.SharePreManager;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "LoginActivity";
    private Button btnForgotPassword, btnNext;
    private EditText etUserName, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        btnForgotPassword = (Button) findViewById(R.id.btnForgotPassword);
        btnNext = (Button) findViewById(R.id.btnNext);
        etUserName = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);

        // Set text for button
        setTextButton();

        btnForgotPassword.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        // Listen text change
        etUserName.addTextChangedListener(textWatcher);
        etPassword.addTextChangedListener(textWatcher);

        // Check field empty
        if (checkFieldsForEmpty())
            btnNext.setEnabled(false);
        else
            btnNext.setEnabled(true);
    }

    public TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (checkFieldsForEmpty())
                btnNext.setEnabled(false);
            else
                btnNext.setEnabled(true);
        }
    };

    public boolean checkFieldsForEmpty() {
        return (etUserName.getText().toString().isEmpty() || etPassword.getText().toString().isEmpty());
    }

    // Set button has different font size
    public void setTextButton() {
        ButtonUtil.setTwoLineTextForButton(btnForgotPassword,
                "FORGOT",
                "PASSWORD",
                16,
                9,
                true);

        ButtonUtil.setTwoLineTextForButton(btnNext,
                "NEXT",
                "ACCESS YOUR ACCOUNT",
                16,
                9,
                true);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btnForgotPassword:
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);

                break;

            case R.id.btnNext:
                SharePreManager.saveUser(etUserName.getText().toString(), this);
                Intent intent1 = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent1);
                finish();

                break;
        }
    }
}
