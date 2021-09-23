package com.example.petitcoeur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class bilan extends AppCompatActivity {

    public static final String TAG = MainActivity.TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilan);
    }

    public void action_finish(View v){
        finish(); //Permet de revenir à la page initiale
    }
}