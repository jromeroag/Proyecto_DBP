package com.example.dbpandroidfinal.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dbpandroidfinal.R;

public class HomeActivity extends AppCompatActivity {
    private Button btnCardio;
    private Button btnDerma;
    private Button btnGine;
    private Button btnOftal;
    private Button btnNeuro;
    private Button btnGeneral;
    private Button btnPediatria;
    private Button btnOnco;

    private Button btngoLogin;

    private Button btnDoctores;

    private Button btnCitas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnCardio = findViewById(R.id.btnCardio);
        btnDerma = findViewById(R.id.btnDerma);
        btnGine = findViewById(R.id.btnGine);
        btnOftal = findViewById(R.id.btnOftal);
        btnNeuro = findViewById(R.id.btnNeuro);
        btnGeneral = findViewById(R.id.btnGeneral);
        btnPediatria = findViewById(R.id.btnPediatria);
        btnOnco = findViewById(R.id.btnOnco);
        btngoLogin = findViewById(R.id.btngoLogin);
        btnDoctores = findViewById(R.id.btnDoctores);
        btnCitas = findViewById(R.id.btnCitas);

        btngoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnCardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CardioActivity.class);
                startActivity(intent);
            }
        });


        btnDerma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, DermaActivity.class);
                startActivity(intent);
            }
        });

        btnGine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,GineActivity.class);
                startActivity(intent);
            }
        });

        btnOftal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, OftalActivity.class);
                startActivity(intent);
            }
        });

        btnNeuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, NeuroActivity.class);
                startActivity(intent);
            }
        });

        btnGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, GeneralActivity.class);
                startActivity(intent);
            }
        });

        btnPediatria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, PediActivity.class);
                startActivity(intent);
            }
        });

        btnOnco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, OncoActivity.class);
                startActivity(intent);
            }
        });

        btnDoctores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, DoctoresActivity.class);
                startActivity(intent);
            }
        });

        btnCitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, CitasActivity.class);
                startActivity(intent);
            }
        });


    }
}