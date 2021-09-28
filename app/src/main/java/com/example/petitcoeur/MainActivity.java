package com.example.petitcoeur;

import androidx.annotation.NonNull;
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

public class MainActivity extends AppCompatActivity {

    // Déclaration du TAG du projet
    public static final String TAG = "UPCoeur";

    // Attribution a la classe Person
    private Person person;

    // Déclaration des elements graphiques
    private EditText editName; // Nom que l'utilisateur a saisi
    private Button start; // Demarrage du questionnaire

    @SuppressLint("WrongViewCast")

    // Appele lorsque l'application est creee
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Association a l'activite en layout
        setContentView(R.layout.activity_main);

        // Reference aux elements graphiques
        editName = findViewById((R.id.PersonName));
        start = findViewById(R.id.start);
        start.setEnabled(true); // Bouton desactive tant que l'utilisateur n'a pas entre son nom

        // Notification lorsque l'utilisateur saisi du texte
        editName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                start.setEnabled(true);
            }
        });



        // Restauration suite à un OnCreate
        if(savedInstanceState != null && savedInstanceState.containsKey("personname")){
            String personname = savedInstanceState.getString("personname");
            editName.setText(personname);
        }

        processIntentData();

    }



    // Permet de passer à la premiere page du formulaire via le bouton start
    public void action_start(View sender){
        Log.d(TAG, "action_start: Demarrage du test");
        Intent intent = new Intent(this, Profil.class);
        intent.putExtra("personname",editName.getText().toString());// Permet de transferer la donnée de nom lors du changement de page
        startActivity(intent);

        goToActivity2();
    }

    @Override // C'est android qui appel cette fonction de sauvegarde
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("personname", editName.getText().toString()); // On sauvegarde le nom du pokémon
    }

    @Override // C'est android qui appel cette fonction de restauration
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("personname")) {// On verifie qu'il y ait bien un resultat
            String personname = savedInstanceState.getString("personname");
            editName.setText(personname);
        }
    }

    // Cette methode est appelee par la methode onCreate
    // elle permet le transfert des donnees renseignees
    private void processIntentData() {
        Intent intent = getIntent();
        if(intent != null) {
            Person transferredPersonPrevious = intent.getParcelableExtra("FromActivity3ToActivity2");
            if (transferredPersonPrevious != null) {
                this.person = transferredPersonPrevious;
                this.person.print();
            }
            else {
                Log.d(TAG, "No Person found after transfer from Activity2");
            }
        }
        else {
            Log.d(TAG, "Error when transferring from Activity2");
        }
    }

    // Passage de l'activite en cours a la suivante
    public void goToActivity2(){
        Intent activity2Intent = new Intent(this, Profil.class);
        activity2Intent.putExtra("FromActivity1ToActivity2", this.person);
        startActivity(activity2Intent);
    }

    // Creation d'une key pour l'application
    private static final String KEY_COEUR = "coeur";


    // CYCLE DE VIE DE L'APPLICATION

    // L'interface graphique devient visible
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: onStart");
    }

    // L'application devient operationnelle
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: onResume");
    }

    // L'activite n'est plus au premier plan
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: onPause");
    }

    // Une nouvelle activite est demarree
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: onStop");
}

    // le systeme arrete l'activite
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: onDestroy");
    }

    // L'application est redemarree
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: onRestart");
    }

}