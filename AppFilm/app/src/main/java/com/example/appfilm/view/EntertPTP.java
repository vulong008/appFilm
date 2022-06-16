package com.example.appfilm.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appfilm.R;

public class EntertPTP extends AppCompatActivity {
    EditText edtNumberVerify;
    Button btnGuiOTP;
    TextView txtGuilaiotp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entert_ptp);
        edtNumberVerify = findViewById(R.id.edtNumberVerify);
        btnGuiOTP = findViewById(R.id.btnGuiOTP);
        txtGuilaiotp = findViewById(R.id.txtGuilaiotp);

        btnGuiOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strOTP = edtNumberVerify.getText().toString().trim();
                openOTPcode(strOTP);
            }
        });
        setTitleToolbar();
        txtGuilaiotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickSendOTPAgain();
            }
        });
    }
    private void openOTPcode(String strOTP) {

    }
    private void onClickSendOTPAgain() {


    }


    private void setTitleToolbar(){
        if (getSupportActionBar()!=null){
            getSupportActionBar().setTitle("EnterOTP");
        }
    }
}