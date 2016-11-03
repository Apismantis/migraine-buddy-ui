package com.blueeagle.migrainebuddyui.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.blueeagle.migrainebuddyui.ButtonUtil;
import com.blueeagle.migrainebuddyui.R;

public class SignUpActivity extends AppCompatActivity {

    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().hide();

        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        ButtonUtil.setTwoLineTextForButton(btnSignUp,
                "NEXT",
                "CREATE YOUR ACCOUNT",
                16,
                9,
                true);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
