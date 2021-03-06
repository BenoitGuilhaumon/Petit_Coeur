/**
 * Projet programmation Android
 * @author GUILHAUMON Benoit, MOUSSET Leana M2 GPhy
 * @version 03/10/2021
 */

/**
 * @Class Hygiene_Vie
 * Cette classe est la cinquième page du questionnaire.
 * Permet à l'utilisateur de renseigner des informations sur les conditions d'hygiènes de vie.
 * Le tout via des RadioButtons.
 * La page permet également d'avoir un lien vers la Federation Francaise de Cardiologie.
 */

package com.example.petitcoeur;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

// Activity 5
public class hygiene_vie extends AppCompatActivity {

    // Declaration du TAG du projet
    public static final String TAG = MainActivity.TAG;

    // Attribution a la classe Person
    private Person person;

    // Declaration des elements graphiques
    private RadioButton yesAlcohol; // L'utilisateur consomme de l'alcohol
    private RadioButton noAlcohol; // L'utilisateur ne consomme pas d'alcohol
    private RadioButton yesEnergyDrink; // L'utilisateur consomme des boissons energisantes
    private RadioButton noEnergyDrink; // L'utilisateur ne consomme pas des boissons energisantes
    private RadioButton yesSleepDisorders; // L'utilisateur a des problemes de sommeil
    private RadioButton noSleepDisorders; // L'utilisateur a pas de problemes de sommeil
    private RadioButton yesSleepHours; // L'utilisateur dors 7H par nuit
    private RadioButton noSleepHours; // L'utilisateur ne dors pas 7H par nuit
    private Button previousStep; // Revien a la page precedente
    private Button nextStep, nextStepLand; // Passe a la suite du questionnaire
    private Button cardiologyFederation, cardiologyFederationLand; // Renvoie vers la page de la federation francaise de cardiologie
    private String namePerson, sexePerson, agePerson;
    private String heartCondition, diabetic, firstDegree, cholesterol, Cardiologist, risk;
    private String CheckUp, consoAlcool, consoEnergyDrink, sleepDisorders, sleepHours;
    private String alccolPerson, eDrinkPerson, disordersPerson, hoursPerson;
    private int selec, selec1, selec2, selec3, selec4;

    @SuppressLint("WrongViewCast")

    // Appele lorsque l'application est creee
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Association a l'activite en layout
        setContentView(R.layout.activity_hygiene_vie);

        // Reference aux elements graphiques
        yesAlcohol = findViewById((R.id.yesAlcohol));
        noAlcohol = findViewById((R.id.noAlcohol));
        yesEnergyDrink = findViewById((R.id.yesEnergyDrink));
        noEnergyDrink = findViewById((R.id.noEnergyDrink));
        yesSleepDisorders = findViewById((R.id.yesSleepDisorders));
        noSleepDisorders = findViewById((R.id.noSleepDisorders));
        yesSleepHours = findViewById((R.id.yesSleepHours));
        noSleepHours = findViewById((R.id.noSleepHours));
        nextStep = findViewById(R.id.nextstep5);
        nextStepLand = findViewById(R.id.nextstep5);
        previousStep = findViewById(R.id.previousstep4);
        cardiologyFederation = findViewById(R.id.buttonfed);
        cardiologyFederationLand = findViewById(R.id.buttonfed);

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
        String consomAlcoolP = intent.getStringExtra("alcool");
        String consomEnergyDrinkP = intent.getStringExtra("energyDrink");
        String sleepDisorderP = intent.getStringExtra("sleepDisorders");
        String sleepHourP = intent.getStringExtra("sleepHours");

        // Permet d'afficher dans les Log le nom transfere de la page suivante
        Log.d(TAG, "onCreate: Previous Person Informations : " + nameP + ageP + sexeP);
        Log.d(TAG, "onCreate: Previous Person Informations : " + spinnerHeartConditionP + spinnerDiabeticP + spinnerFirstDegreeP + spinnerCholesterolP);
        Log.d(TAG, "onCreate: Previous Person Informations : " + cardiovascularRiskP + cardiacCheckUpPrevP + consultCardiologistP);
        Log.d(TAG, "onCreate: Previous Person Informations : " + consomAlcoolP + consomEnergyDrinkP + sleepDisorderP + sleepHourP);

        // On attribue la valeur pour pouvoir afficher
        alccolPerson = consomAlcoolP;
        eDrinkPerson = consomEnergyDrinkP;
        disordersPerson = sleepDisorderP;
        hoursPerson = sleepHourP;

        // Bouton desactive tant que l'utilisateur n'a complété toutes les questions
        nextStep.setEnabled(false);
        cardiologyFederation.setEnabled(false);

        selec = 0;
        // On attribue pour chaques radio button une valeur si il est coché
        yesAlcohol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consoAlcool = "Yes";
                selec1 = selec + 1;
            }
        });

        noAlcohol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consoAlcool = "No";
                selec1 = selec + 1;
            }
        });

        yesEnergyDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consoEnergyDrink = "Yes";
                selec2 = selec1 + 1;
            }
        });

        noEnergyDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consoEnergyDrink = "No";
                selec2 = selec1 + 1;
            }
        });

        yesSleepDisorders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sleepDisorders = "Yes";
                selec3 = selec2 + 1;
            }
        });

        noSleepDisorders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sleepDisorders = "No";
                selec3 = selec2 + 1;

            }
        });

        yesSleepHours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sleepHours = "Yes";
                selec4 = selec3 + 1;

                // On verifie si tous les champs sont remplis pour débloquer le bouton Nextstep
                Log.d(TAG, "onItemSelected: Select item " + selec4);
                if (selec4 >= 4) {
                    nextStep.setEnabled(true);
                    cardiologyFederation.setEnabled(true);
                }
            }
        });

        noSleepHours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sleepHours = "No";
                selec4 = selec3 + 1;

                // On verifie si tous les champs sont remplis pour débloquer le bouton Nextstep
                Log.d(TAG, "onItemSelected: Select item " + selec4);
                if (selec4 >= 4) {
                    nextStep.setEnabled(true);
                    cardiologyFederation.setEnabled(true);
                }
            }
        });

        // Restauration suite à un OnCreate
        if (savedInstanceState != null && savedInstanceState.containsKey("consoAlcoholYes")) {// On verifie qu'il y ait bien un resultat
            String consoAlcoholYes = savedInstanceState.getString("consoAlcoholYes");
            yesAlcohol.setText(consoAlcoholYes);
        }
        if (savedInstanceState != null && savedInstanceState.containsKey("consoAlcoholNo")) {// On verifie qu'il y ait bien un resultat
            String consoAlcoholNo = savedInstanceState.getString("consoAlcoholNo");
            noAlcohol.setText(consoAlcoholNo);
        }
        if (savedInstanceState != null && savedInstanceState.containsKey("consoEnergyYes")) {// On verifie qu'il y ait bien un resultat
            String consoEnergyYes = savedInstanceState.getString("consoEnergyYes");
            yesEnergyDrink.setText(consoEnergyYes);
        }
        if (savedInstanceState != null && savedInstanceState.containsKey("consoEnergyNo")) {// On verifie qu'il y ait bien un resultat
            String consoEnergyNo = savedInstanceState.getString("consoEnergyNo");
            noEnergyDrink.setText(consoEnergyNo);
        }
        if (savedInstanceState != null && savedInstanceState.containsKey("sleepDisorderYes")) {// On verifie qu'il y ait bien un resultat
            String sleepDisorderYes = savedInstanceState.getString("sleepDisorderYes");
            yesSleepDisorders.setText(sleepDisorderYes);
        }
        if (savedInstanceState != null && savedInstanceState.containsKey("sleepDisorderNo")) {// On verifie qu'il y ait bien un resultat
            String sleepDisorderNo = savedInstanceState.getString("sleepDisorderNo");
            noSleepDisorders.setText(sleepDisorderNo);
        }
        if (savedInstanceState != null && savedInstanceState.containsKey("sleepHoursYes")) {// On verifie qu'il y ait bien un resultat
            String sleepHoursYes = savedInstanceState.getString("sleepHoursYes");
            yesSleepHours.setText(sleepHoursYes);
        }
        if (savedInstanceState != null && savedInstanceState.containsKey("sleepHoursNo")) {// On verifie qu'il y ait bien un resultat
            String sleepHoursNo = savedInstanceState.getString("sleepHoursNo");
            noSleepHours.setText(sleepHoursNo);
        }

        processIntentData();
    }

    @Override // C'est android qui appel cette fonction de sauvegarde
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("consoAlcoholYes", yesAlcohol.getText().toString()); // On sauvegarde la valeur du radiobutton
        outState.putString("consoAlcoholNo", noAlcohol.getText().toString()); // On sauvegarde la valeur du radiobutton
        outState.putString("consoEnergyYes", yesEnergyDrink.getText().toString()); // On sauvegarde la valeur du radiobutton
        outState.putString("consoEnergyNo", noEnergyDrink.getText().toString()); // On sauvegarde la valeur du radiobutton
        outState.putString("sleepDisorderYes", yesSleepDisorders.getText().toString()); // On sauvegarde la valeur du radiobutton
        outState.putString("sleepDisorderNo", noSleepDisorders.getText().toString()); // On sauvegarde la valeur du radiobutton
        outState.putString("sleepHoursYes", yesSleepHours.getText().toString()); // On sauvegarde la valeur du radiobutton
        outState.putString("sleepHoursNo", noSleepHours.getText().toString()); // On sauvegarde la valeur du radiobutton
    }

    @Override // C'est android qui appel cette fonction de restauration
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("consoAlcoholYes")) {// On verifie qu'il y ait bien un resultat
            String consoAlcoholYes = savedInstanceState.getString("consoAlcoholYes");
            yesAlcohol.setText(consoAlcoholYes);
        }
        if (savedInstanceState.containsKey("consoAlcoholNo")) {// On verifie qu'il y ait bien un resultat
            String consoAlcoholNo = savedInstanceState.getString("consoAlcoholNo");
            noAlcohol.setText(consoAlcoholNo);
        }
        if (savedInstanceState.containsKey("consoEnergyYes")) {// On verifie qu'il y ait bien un resultat
            String consoEnergyYes = savedInstanceState.getString("consoEnergyYes");
            yesEnergyDrink.setText(consoEnergyYes);
        }
        if (savedInstanceState.containsKey("consoEnergyNo")) {// On verifie qu'il y ait bien un resultat
            String consoEnergyNo = savedInstanceState.getString("consoEnergyNo");
            noEnergyDrink.setText(consoEnergyNo);
        }
        if (savedInstanceState.containsKey("sleepDisorderYes")) {// On verifie qu'il y ait bien un resultat
            String sleepDisorderYes = savedInstanceState.getString("sleepDisorderYes");
            yesSleepDisorders.setText(sleepDisorderYes);
        }
        if (savedInstanceState.containsKey("sleepDisorderNo")) {// On verifie qu'il y ait bien un resultat
            String sleepDisorderNo = savedInstanceState.getString("sleepDisorderNo");
            noSleepDisorders.setText(sleepDisorderNo);
        }
        if (savedInstanceState.containsKey("sleepHoursYes")) {// On verifie qu'il y ait bien un resultat
            String sleepHoursYes = savedInstanceState.getString("sleepHoursYes");
            yesSleepHours.setText(sleepHoursYes);
        }
        if (savedInstanceState.containsKey("sleepHoursNo")) {// On verifie qu'il y ait bien un resultat
            String sleepHoursNo = savedInstanceState.getString("sleepHoursNo");
            noSleepHours.setText(sleepHoursNo);
        }
    }

    // Creation d'une key pour l'application
    private static final String KEY_COEUR = "coeur";

    // Permet d'acceder a la page de la federation francaise de cardiologie
        public void on_Click (View sender) {
            String url = "https://fedecardio.org";
            Log.d(TAG, "onClick: URL: " + url);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        }

    // Permet de revenir a la page précédente du formulaire
    public void action_previous_page(View sender){
        Log.d(TAG, "action_previous_page: Passage à la page précédente du formulaire");
        Intent intent = new Intent(this, Previous_Suivi_Cardiaque.class);
        intent.putExtra("cardiovascularRisk",risk);
        intent.putExtra("cardiacCheckUp",CheckUp);
        intent.putExtra("consultCardiologist",Cardiologist);
        intent.putExtra("spinnerHeartCondition",heartCondition);
        intent.putExtra("spinnerDiabetic",diabetic);
        intent.putExtra("spinnerFirstDegree",firstDegree);
        intent.putExtra("spinnerCholesterol",cholesterol);
        intent.putExtra("sexe",sexePerson);
        intent.putExtra("age",agePerson);
        intent.putExtra("personname",namePerson);
        startActivity(intent);

        //goToActivity4();
    }

    // Passage de l'activite en cours a la precedente
    public void goToActivity4(){
        Intent activityIntent = new Intent(this, Suivi_Cardiaque.class);
        activityIntent.putExtra("FromActivity5ToActivity4", this.person);
        startActivity(activityIntent);
    }

    // Permet de passer à la page suivante du formulaire
    public void action_next_page(View sender){
        Log.d(TAG, "action_next_page: Passage à la suite du formulaire");
        Intent intent = new Intent(this, bilan.class);
        intent.putExtra("cardiovascularRisk",risk);
        intent.putExtra("cardiacCheckUp",CheckUp);
        intent.putExtra("consultCardiologist",Cardiologist);
        intent.putExtra("spinnerHeartCondition",heartCondition);
        intent.putExtra("spinnerDiabetic",diabetic);
        intent.putExtra("spinnerFirstDegree",firstDegree);
        intent.putExtra("spinnerCholesterol",cholesterol);
        intent.putExtra("sexe",sexePerson);
        intent.putExtra("age",agePerson);
        intent.putExtra("personname",namePerson);
        intent.putExtra("alcool",consoAlcool);
        intent.putExtra("energyDrink",consoEnergyDrink);
        intent.putExtra("sleepDisorders",sleepDisorders);
        intent.putExtra("sleepHours",sleepHours);
        startActivity(intent);

        // goToActivity6();
    }

    // Passage de l'activite en cours a la suivante
    public void goToActivity6(){
        Intent activity6Intent = new Intent(this, bilan.class);
        activity6Intent.putExtra("FromActivity5ToActivity6", this.person);
        startActivity(activity6Intent);
    }

    private void processIntentData() {
        Intent intent = getIntent();
        if(intent != null) {
// intent may store different data. To get the one matching the Person class,
// we need the key "FromActivity1ToActivity2" which was used for transfer
// No need to calls "new()" for allocating memory to transferredPerson
            Person transferredPerson = intent.getParcelableExtra("FromActivity4ToActivity5");
            Person transferredPersonPrevious = intent.getParcelableExtra("FromActivity6ToActivity5");
            if (transferredPerson != null) {
                this.person = transferredPerson;
                this.person.print();
            }
            else {
                Log.d(TAG, "No Person found after transfer from Activity4");
            }
            if (transferredPersonPrevious != null) {
                this.person = transferredPersonPrevious;
                this.person.print();
            }
            else {
                Log.d(TAG, "No Person found after transfer from Activity6");
            }
        }
        else {
            Log.d(TAG, "Error when transferring from Activity4");
        }
    }

}





