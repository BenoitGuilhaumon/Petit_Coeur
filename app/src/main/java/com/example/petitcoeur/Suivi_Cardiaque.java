/**
 * Projet programmation Android
 * @author GUILHAUMON Benoit, MOUSSET Leana M2 GPhy
 * @version 03/10/2021
 */

/**
 * @Class Suivi_Cardiaque
 * Cette classe est la quatrième page du questionnaire.
 * Permet à l'utilisateur de renseigner des informations sur les visites médicales relatives à la condition cardiaque.
 * Le tout via un EditText, un bouton Switch et des ImagesButtons.
 */

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

// Activity 4
public class Suivi_Cardiaque extends AppCompatActivity {

    public static final String TAG = MainActivity.TAG;

    // Attribution a la classe Person
    private Person person;

    // Declaration des elements graphiques
    private EditText risk;
    private Switch cardiacCheckUp;
    private ImageButton yesCardiologist;
    private ImageButton noCardiologist;
    private ImageButton dontKnowCardiologist;
    private String consultCardiologist;
    private Button nextstep, nextstepLand;
    private Button previousstep, previousstepLand;
    private String namePerson, sexePerson, agePerson;
    private String heartCondition, diabetic, firstDegree, cholesterol, checkUp;
    private String cardioVascularPerson, checkUpPerson, consultPerson;
    private int selec, selec1, selec2, selec3;

    @SuppressLint("WrongViewCast")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suivi_cardiaque);

        // References aux elements de la page
        risk = findViewById((R.id.CardiovascularRisk));
        cardiacCheckUp = findViewById(R.id.checkUp);
        yesCardiologist = findViewById((R.id.YesConsult));
        noCardiologist = findViewById((R.id.NoConsult));
        dontKnowCardiologist = findViewById(R.id.dontKnowConsult);
        nextstep = findViewById(R.id.nextstep3);
        previousstep = findViewById(R.id.previousstep3);
        nextstepLand = findViewById(R.id.nextstep3);
        previousstepLand = findViewById(R.id.previousstep3);

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

        // On recupere la valeur envoyée par la page suivante
        Intent intentP = getIntent();
        String sexeP = intentP.getStringExtra("sexe");
        String ageP = intentP.getStringExtra("age");
        String nameP = intent.getStringExtra("personname");
        String spinnerHeartConditionP = intent.getStringExtra("spinnerHeartCondition");
        String spinnerDiabeticP = intent.getStringExtra("spinnerDiabetic");
        String spinnerFirstDegreeP = intent.getStringExtra("spinnerFirstDegree");
        String spinnerCholesterolP = intent.getStringExtra("spinnerCholesterol");
        String cardiovascularRiskP = intent.getStringExtra("cardiovascularRisk");
        String cardiacCheckUpPrevP = intent.getStringExtra("cardiacCheckUp");
        String consultCardiologistP = intent.getStringExtra("consultCardiologist");
        // Permet d'afficher dans les Log le nom transfere de la page suivante
        Log.d(TAG, "onCreate: Previous Person Informations : " + nameP + ageP + sexeP + spinnerHeartConditionP + spinnerDiabeticP + spinnerFirstDegreeP + spinnerCholesterolP);
        Log.d(TAG, "onCreate: Previous Person Informations : " + cardiovascularRiskP + cardiacCheckUpPrevP + consultCardiologistP);
        // On attribue la valeur pour pouvoir afficher
        cardioVascularPerson = cardiovascularRiskP;
        checkUpPerson = cardiacCheckUpPrevP;
        consultPerson = consultCardiologistP;

        // Bouton desactive tant que l'utilisateur n'a complété toutes les questions
        nextstep.setEnabled(false);

        selec = 0;
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
                selec1 = selec + 1;
            }
        });

        // Bouton switch coche ou non
        cardiacCheckUp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.d(TAG, "onCheckedChanged: Etat du switch : " + cardiacCheckUp.isChecked());
                if (cardiacCheckUp.isChecked()==true) {
                    checkUp = "Yes";
                }else {
                    checkUp = "No";
                }
                selec2 = selec1 + 1;
            }
        });

        yesCardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consultCardiologist = "Yes";
                Log.d(TAG, "onCheckedChanged: Selection Cardiologist : " + consultCardiologist);
                selec3 = selec2 + 1;

                // On verifie si tous les champs sont remplis pour débloquer le bouton Nextstep
                Log.d(TAG, "onItemSelected: Select item " + selec3);
                if (selec3 >= 3) {
                    nextstep.setEnabled(true);
                }
            }
        });

        noCardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consultCardiologist = "No";
                Log.d(TAG, "onCheckedChanged: Selection Cardiologist : " + consultCardiologist);
                selec3 = selec2 + 1;

                // On verifie si tous les champs sont remplis pour débloquer le bouton Nextstep
                Log.d(TAG, "onItemSelected: Select item " + selec3);
                if (selec3 >= 3) {
                    nextstep.setEnabled(true);
                }
            }
        });

        dontKnowCardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consultCardiologist = "Don't know";
                Log.d(TAG, "onCheckedChanged: Selection Cardiologist : " + consultCardiologist);
                selec3 = selec2 + 1;

                // On verifie si tous les champs sont remplis pour débloquer le bouton Nextstep
                Log.d(TAG, "onItemSelected: Select item " + selec3);
                if (selec3 >= 3) {
                    nextstep.setEnabled(true);
                }
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
        intent.putExtra("cardiacCheckUp",checkUp);
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
        Intent intent = new Intent(this, Previous_Mon_Coeur.class);
        intent.putExtra("spinnerHeartCondition",heartCondition);
        intent.putExtra("spinnerDiabetic",diabetic);
        intent.putExtra("spinnerFirstDegree",firstDegree);
        intent.putExtra("spinnerCholesterol",cholesterol);
        intent.putExtra("sexe",sexePerson);
        intent.putExtra("age",agePerson);
        intent.putExtra("personname",namePerson);
        startActivity(intent);

        // goToActivity3();
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