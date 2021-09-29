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
import android.widget.EditText;
import android.widget.RadioButton;

public class Profil extends AppCompatActivity {

    // Declaration du tag du projet
    public static final String TAG = MainActivity.TAG;

    // Attribution a la classe Person
    private Person person;

    // Delcaration des elements graphiques
    private RadioButton genre; // Sexe de l'utilisateur
    private EditText age; // Age de l'utilisateur
    private String namePerson;
    private Button nextstep; // Bouton pour passer à la page suivante
    private Button previousstep; // Bouton pour revenir à la page precedente

    @SuppressLint("WrongViewCast")

    // Appele a la creation de la page
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Association a l'activite en layout
        setContentView(R.layout.activity_profil);
        Log.d(TAG, "onCreate: ");

        // On recupere la valeur envoyée par la page précédente
        Intent intent = getIntent();
        String name = intent.getStringExtra("personname");
        // Permet d'afficher dans les Log le nom transfere de la page precedente
        Log.d(TAG, "onCreate: Person name : " + name);
        // J'attribue la valeur recupere pour pouvoir la retransferrer
        namePerson = name;

        // Reference aux elements graphiques
        genre = findViewById((R.id.SexButton));
        age = findViewById(R.id.editAge);
        nextstep = findViewById(R.id.nextstep);
        previousstep = findViewById(R.id.previousstep);
       // nextstep.setEnabled(false); // On desactive le bouton

        // Notification lorsque l'utilisateur saisi du texte
        age.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //nextstep.setEnabled(true); // On active le bouton quand le patient a saisie son age
            }
        });

        processIntentData();
    }

    // Permet de passer à la page suivante du formulaire en transferrant les informations des pages precedentes
    public void action_next_page(View sender){
        Log.d(TAG, "action_next_page: Passage à la suite du formulaire");
        Intent intent = new Intent(this, MonCoeur.class);
        intent.putExtra("sexe",genre.getText().toString());
        intent.putExtra("age",age.getText().toString());
        intent.putExtra("personname",namePerson);
        startActivity(intent);

        //goToActivity3();
    }

    // Permet de passer à la premiere page du formulaire via le bouton start
    public void action_previous_page(View sender){
        Log.d(TAG, "action_next_page: Passage à la page précédente du formulaire");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        goToActivity1();
    }

    // Methode appele par la methode onCreate
    // elle permet le transfert des donnees renseignees
    private void processIntentData() {
        Intent intent = getIntent();
        if(intent != null) {
            Person transferredPerson = intent.getParcelableExtra("FromActivity1ToActivity2");
            Person transferredPersonPrevious = intent.getParcelableExtra("FromActivity3ToActivity2");
            if (transferredPerson != null) {
                this.person = transferredPerson;
                this.person.print();
            }
            else {
                Log.d(TAG, "No Person found after transfer from Activity1");
            }
            if (transferredPersonPrevious != null) {
                this.person = transferredPersonPrevious;
                this.person.print();
            }
            else {
                Log.d(TAG, "No Person found after transfer from Activity3");
            }
        }
        else {
            Log.d(TAG, "Error when transferring from Activity1");
        }
    }

    // Passage a l'activite suivante
    public void goToActivity3(){
        Intent activity3Intent = new Intent(this, MonCoeur.class);
        activity3Intent.putExtra("FromActivity2ToActivity3", this.person);
        startActivity(activity3Intent);
    }

    // Retour a l'activite precedente
    public void goToActivity1(){
        Intent activityIntent = new Intent(this, MainActivity.class);
        activityIntent.putExtra("FromActivity2ToActivity1", this.person);
        startActivity(activityIntent);
    }

    // Creation d'une key pour l'application
    private static final String KEY_COEUR = "coeur";
}