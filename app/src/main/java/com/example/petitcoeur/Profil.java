package com.example.petitcoeur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Profil extends AppCompatActivity {

    public static final String TAG = MainActivity.TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        Log.d(TAG, "onCreate: ");
        // On recupere la valeur envoyée par la page précédente
        Intent intent = getIntent();
        String name = intent.getStringExtra("personname");
        Log.d(TAG, "onCreate: Person name : " + name);
    }

    // Permet de passer à la premiere page du formulaire via le bouton start
    public void action_next_page(View sender){
        Log.d(TAG, "action_next_page: Passage à la suite du formulaire");
        Intent intent = new Intent(this, MonCoeur.class);
        startActivity(intent);
    }

    public void action_finish(View v){
        finish(); //Permet de revenir à la page initiale
    }
}