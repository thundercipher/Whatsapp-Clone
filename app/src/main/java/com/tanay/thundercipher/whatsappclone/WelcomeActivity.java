package com.tanay.thundercipher.whatsappclone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.tanay.thundercipher.whatsappclone.R;

public class WelcomeActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button mBtAgreeTos = findViewById(R.id.btn_agree_tos);

        mFirebaseAuth = FirebaseAuth.getInstance();

        mBtAgreeTos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, InputPhoneNumberActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        // check if already authenticated
        if (mFirebaseAuth.getCurrentUser() != null) {
            onAuthSuccess();
        }
    }

    private void onAuthSuccess() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
