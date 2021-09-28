package com.example.petitcoeur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;


public class Suivi_Cardiaque extends AppCompatActivity {

    public static final String TAG = MainActivity.TAG;

    private Person person; // Attribution a la classe Person

    private EditText risk;
    private Switch cardiacCheckUp;
    private ImageButton yesCardiologist;
    private ImageButton noCardiologist;
    private ImageButton dontKnowCardiologist;
    private Button nextstep;
    private Button previousstep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suivi_cardiaque);

        risk = findViewById((R.id.CardiovascularRisk));
        cardiacCheckUp = findViewById(R.id.checkUp);
        yesCardiologist = findViewById((R.id.YesConsult));
        noCardiologist = findViewById((R.id.NoConsult));
        dontKnowCardiologist = findViewById(R.id.dontKnowConsult);
        nextstep = findViewById(R.id.nextstep3);
        previousstep = findViewById(R.id.previousstep3);

        // Notification lorsque l'utilisateur saisi du texte
        risk.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        // Bouton switch coche ou non
        cardiacCheckUp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.d(TAG, "onCheckedChanged: Etat du switch : " + cardiacCheckUp.isChecked());
            }
        });

        yesCardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ajouter la recuperation de donnees
            }
        });

        noCardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ajouter la recuperation de donnees
            }
        });

        dontKnowCardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ajouter la recuperation de donnees
            }
        });

        processIntentData();



    }

    // Methode pour passer a la page suivante
    public void goToActivity5(){
        Intent activity5Intent = new Intent(this, hygiene_vie.class);
        activity5Intent.putExtra("FromActivity4ToActivity5", this.person);
        startActivity(activity5Intent);
    }

    // Methode pour retourner a la page précedente
    public void goToActivity3(){
        Intent activityIntent = new Intent(this, MonCoeur.class);
        activityIntent.putExtra("FromActivity4ToActivity3", this.person);
        startActivity(activityIntent);
    }

    // Permet de passer à la page suivante du formulaire
    public void action_next_page(View sender){
        Log.d(TAG, "action_next_page: Passage à la suite du formulaire");
        Intent intent = new Intent(this, hygiene_vie.class);
        startActivity(intent);

        goToActivity5();
    }

    // Permet de revenir à la page précédente du formulaire
    public void action_previous_page(View sender){
        Log.d(TAG, "action_previous_page: Passage à la page précédente du formulaire");
        Intent intent = new Intent(this, MonCoeur.class);
        startActivity(intent);

        goToActivity3();
    }

    // Methode appele par la methode onCreate
    private void processIntentData() {
        Intent intent = getIntent();
        if(intent != null) {
            Person transferredPerson = intent.getParcelableExtra("FromActivity3ToActivity4");
            Person transferredPersonPrevious = intent.getParcelableExtra("FromActivity5ToActivity4");
            if (transferredPerson != null) {
                this.person = transferredPerson;
                this.person.print();
            }
            else {
                Log.d(TAG, "No Person found after transfer from Activity3");
            }
            if (transferredPersonPrevious != null) {
                this.person = transferredPersonPrevious;
                this.person.print();
            }
            else {
                Log.d(TAG, "No Person found after transfer from Activity5");
            }
        }
        else {
            Log.d(TAG, "Error when transferring from Activity3");
        }
    }

}