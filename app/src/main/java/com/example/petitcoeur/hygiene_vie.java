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
import android.widget.EditText;
import android.widget.RadioButton;

public class hygiene_vie extends AppCompatActivity {

    // Déclaration du TAG du projet
    public static final String TAG = MainActivity.TAG;

    // Attribution a la classe Person
    private Person person;

    // Déclaration des elements graphiques
    private RadioButton yesAlcohol; // L'utilisateur consomme de l'alcohol
    private RadioButton noAlcohol; // L'utilisateur ne consomme pas d'alcohol
    private RadioButton yesEnergyDrink; // L'utilisateur consomme des boissons energisantes
    private RadioButton noEnergyDrink; // L'utilisateur ne consomme pas des boissons energisantes
    private RadioButton yesSleepDisorders; // L'utilisateur a des problemes de sommeil
    private RadioButton noSleepDisorders; // L'utilisateur a pas de problemes de sommeil
    private RadioButton yesSleepHours; // L'utilisateur dors 7H par nuit
    private RadioButton noSleepHours; // L'utilisateur ne dors pas 7H par nuit
    private Button previousStep; // Revien a la page precedente
    private Button nextStep; // Passe a la suite du questionnaire
    private Button cardiologyFederation; // Renvoie vers la page de la federation francaise de cardiologie

    @SuppressLint("WrongViewCast")

    // Appele lorsque l'application est creee
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Association a l'activite en layout
        setContentView(R.layout.activity_hygiene_vie);

        // Reference aux elements graphiques
        yesAlcohol = findViewById((R.id.radioButton20));
        noAlcohol = findViewById((R.id.radioButton19));
        yesEnergyDrink = findViewById((R.id.radioButton14));
        noEnergyDrink = findViewById((R.id.radioButton13));
        yesSleepDisorders = findViewById((R.id.radioButton16));
        noSleepDisorders = findViewById((R.id.radioButton15));
        yesSleepHours = findViewById((R.id.radioButton18));
        noSleepHours = findViewById((R.id.radioButton17));
        nextStep = findViewById(R.id.nextstep5);
        previousStep = findViewById(R.id.previousstep4);
        cardiologyFederation = findViewById(R.id.buttonfed);
        nextStep.setEnabled(false); // Bouton desactive tant que l'utilisateur n'a pas entre les informations

        Log.d(TAG, "onCreate: ");
        // On recupere la valeur envoyée par la page précédente
        Intent intent = getIntent();
        String name = intent.getStringExtra("coeur");
        Log.d(TAG, "onCreate: Person name : " + name);

        // Restauration suite à un OnCreate
        if(savedInstanceState != null && savedInstanceState.containsKey("personname")){
            String personname = savedInstanceState.getString("personname");
            editName.setText(personname);
        }

        processIntentData();
    }

    @Override // C'est android qui appel cette fonction de sauvegarde
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("consoAlcoholYes", yesAlcohol.getCheckedRadioButtonId()); // On sauvegarde le nom du patient
        outState.putString("consoAlcoholNo", noAlcohol.getText().toString()); // On sauvegarde le nom du patient
        outState.putString("consoEnergyYes", yesEnergyDrink.getText().toString()); // On sauvegarde le nom du patient
        outState.putString("consoEnergyNo", noEnergyDrink.getText().toString()); // On sauvegarde le nom du patient
        outState.putString("sleepDisorderYes", yesSleepDisorders.getText().toString()); // On sauvegarde le nom du patient
        outState.putString("sleepDisorderNo", noSleepDisorders.getText().toString()); // On sauvegarde le nom du patient
        outState.putString("sleepHoursYes", yesSleepHours.getText().toString()); // On sauvegarde le nom du patient
        outState.putString("sleepHoursNo", noSleepHours.getText().toString()); // On sauvegarde le nom du patient
    }

    @Override // C'est android qui appel cette fonction de restauration
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("personname")) {// On verifie qu'il y ait bien un resultat
            String personname = savedInstanceState.getString("personname");
            editName.setText(personname);
        }
    }

    // Permet d'acceder a la page de la federation francaise de cardiologie
        public void on_Click (View sender) {
            String url = "https://fedecardio.org";
            Log.d(TAG, "onClick: URL: " + url);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        }

    // Permet de revenir à la page précédente du formulaire
    public void action_previous_page(View sender){
        Log.d(TAG, "action_previous_page: Passage à la page précédente du formulaire");
        Intent intent = new Intent(this, Suivi_Cardiaque.class);
        startActivity(intent);

        goToActivity4();
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
        startActivity(intent);

        goToActivity6();
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





