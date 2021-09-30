package com.example.petitcoeur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class bilan extends AppCompatActivity {

    public static final String TAG = MainActivity.TAG;

    private Person person;
    private Button finish;
    private String namePerson;
    private String sexePerson;
    private String agePerson;
    private String heartCondition;
    private String diabetic;
    private String firstDegree;
    private String cholesterol;
    private String Cardiologist;
    private String risk;
    private String CheckUp;
    private String consoAlcool;
    private String consoEnergyDrink;
    private String sleepDisorders;
    private String sleepHours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Association a l'activite en layout
        setContentView(R.layout.activity_bilan);

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
        String cardiovascularRisk = intent.getStringExtra("cardiovascularRisk");
        String cardiacCheckUp = intent.getStringExtra("cardiacCheckUp");
        String consultCardiologist = intent.getStringExtra("consultCardiologist");
        String consomAlcool = intent.getStringExtra("alcool");
        String consomEnergyDrink = intent.getStringExtra("energyDrink");
        String sleepDisorder = intent.getStringExtra("sleepDisorders");
        String sleepHour = intent.getStringExtra("sleepHours");
        // Permet d'afficher dans les Log des infos transfere de la page precedente
        Log.d(TAG, "onCreate: Person name : " + name);
        Log.d(TAG, "onCreate: Person sexe : " + sexe);
        Log.d(TAG, "onCreate: Person age : " + age);
        Log.d(TAG, "onCreate: Person heart condition ? : " + spinnerHeartCondition);
        Log.d(TAG, "onCreate: Person diabetic ? : " + spinnerDiabetic);
        Log.d(TAG, "onCreate: Person first degree relative ? : " + spinnerFirstDegree);
        Log.d(TAG, "onCreate: Person cholesterol ? : " + spinnerCholesterol);
        Log.d(TAG, "onCreate: Person Cardiovascular Risk ? : " + cardiovascularRisk);
        Log.d(TAG, "onCreate: Person Cardiac Check Up ? : " + cardiacCheckUp);
        Log.d(TAG, "onCreate: Person Consult Cardiologist ? : " + consultCardiologist);
        Log.d(TAG, "onCreate: Person Conso Alcool ? : " + consomAlcool);
        Log.d(TAG, "onCreate: Person Conso Energy Drink ? : " + consomEnergyDrink);
        Log.d(TAG, "onCreate: Person Sleep Disorders ? : " + sleepDisorder);
        Log.d(TAG, "onCreate: Person Sleep 7 Hours ? : " + sleepHour);
        // J'attribue les valeurs recuperees pour pouvoir les retransferrer
        namePerson = name;
        sexePerson = sexe;
        agePerson = age;
        heartCondition = spinnerHeartCondition;
        diabetic = spinnerDiabetic;
        firstDegree = spinnerFirstDegree;
        cholesterol = spinnerCholesterol;
        CheckUp = cardiacCheckUp;
        Cardiologist = consultCardiologist;
        risk = cardiovascularRisk;
        consoAlcool = consomAlcool;
        consoEnergyDrink = consomEnergyDrink;
        sleepDisorders = sleepDisorder;
        sleepHours = sleepHour;

        finish = findViewById(R.id.finish);
    }

    private void processIntentData() {
        Intent intent = getIntent();
        if(intent != null) {
// intent may store different data. To get the one matching the Person class,
// we need the key "FromActivity1ToActivity2" which was used for transfer
// No need to calls "new()" for allocating memory to transferredPerson
            Person transferredPerson = intent.getParcelableExtra("FromActivity5ToActivity6");
            if (transferredPerson != null) {
                this.person = transferredPerson;
                this.person.print();
            }
            else {
                Log.d(TAG, "No Person found after transfer from Activity5");
            }
        }
        else {
            Log.d(TAG, "Error when transferring from Activity4");
        }
    }

    //public void action_finish(View v){finish();//Permet de revenir à la page initiale
    public void onClickExit(View view) {
        finish();
    }
}
