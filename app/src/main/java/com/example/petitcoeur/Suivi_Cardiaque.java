package com.example.petitcoeur;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
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
    private String consultCardiologist;
    private Button nextstep, nextstepLand;
    private Button previousstep, previousstepLand;
    private String namePerson;
    private String sexePerson;
    private String agePerson;
    private String heartCondition;
    private String diabetic;
    private String firstDegree;
    private String cholesterol;
    private String checkUp;

    @SuppressLint("WrongViewCast")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suivi_cardiaque);

        // On recupere les valeurs des pages precedentes
        // On recupere la valeur envoyée par la page précédente
        Intent intent = getIntent();
        String name = intent.getStringExtra("personname");
        String sexe = intent.getStringExtra("sexe");
        String age = intent.getStringExtra("age");
        String spinnerHeartCondition = intent.getStringExtra("spinnerHeartCondition");
        String spinnerDiabetic = intent.getStringExtra("spinnerDiabetic");
        String spinnerFirstDegree = intent.getStringExtra("spinnerFirstDegree");
        String spinnerCholesterol = intent.getStringExtra("spinnerCholesterol");
        // Permet d'afficher dans les Log des infos transfere de la page precedente
        Log.d(TAG, "onCreate: Person name : " + name);
        Log.d(TAG, "onCreate: Person sexe : " + sexe);
        Log.d(TAG, "onCreate: Person age : " + age);
        Log.d(TAG, "onCreate: Person heart condition ? : " + spinnerHeartCondition);
        Log.d(TAG, "onCreate: Person diabetic ? : " + spinnerDiabetic);
        Log.d(TAG, "onCreate: Person first degree relative ? : " + spinnerFirstDegree);
        Log.d(TAG, "onCreate: Person cholesterol ? : " + spinnerCholesterol);
        // J'attribue les valeurs recuperees pour pouvoir les retransferrer
        namePerson = name;
        sexePerson = sexe;
        agePerson = age;
        heartCondition = spinnerHeartCondition;
        diabetic = spinnerDiabetic;
        firstDegree = spinnerFirstDegree;
        cholesterol = spinnerCholesterol;

        risk = findViewById((R.id.CardiovascularRisk));
        cardiacCheckUp = findViewById(R.id.checkUp);
        yesCardiologist = findViewById((R.id.YesConsult));
        noCardiologist = findViewById((R.id.NoConsult));
        dontKnowCardiologist = findViewById(R.id.dontKnowConsult);
        nextstep = findViewById(R.id.nextstep3);
        previousstep = findViewById(R.id.previousstep3);
        nextstepLand = findViewById(R.id.nextstep3);
        previousstepLand = findViewById(R.id.previousstep3);

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
                if (cardiacCheckUp.isChecked()==true) {
                    checkUp = "Yes";
                }else checkUp = "No";
            }
        });

        yesCardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consultCardiologist = "Yes";
            }
        });

        noCardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consultCardiologist = "No";
            }
        });

        dontKnowCardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consultCardiologist = "Don't know";
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
        intent.putExtra("cardiovascularRisk",risk.getText().toString());
        intent.putExtra("cardiacCheckUp",checkUp); // A VERIFIER
        intent.putExtra("consultCardiologist",consultCardiologist);
        intent.putExtra("spinnerHeartCondition",heartCondition);
        intent.putExtra("spinnerDiabetic",diabetic);
        intent.putExtra("spinnerFirstDegree",firstDegree);
        intent.putExtra("spinnerCholesterol",cholesterol);
        intent.putExtra("sexe",sexePerson);
        intent.putExtra("age",agePerson);
        intent.putExtra("personname",namePerson);
        startActivity(intent);

        //goToActivity5();
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