/**
 Projet programmation Android
 @author GUILHAUMON Benoit, MOUSSET Leana M2 GPhy
  * @version 03/10/2021
 */

/**
 * @Class Previous_Main_Activity
 * Cette classe permet de récuperer les valeurs du questionnaire lors d'un retour en arriére à partir de la classe Profil.
 * On va pouvoir afficher les valeurs renseignées sur l'interface MAin_Activity.xml.
 */


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
import android.widget.Toast;

// Activity 1
public class Previous_Main_Activity extends AppCompatActivity {

    // Déclaration du TAG du projet
    public static final String TAG = "UPCoeur";

    // Déclaration des elements graphiques
    private EditText editName; // Nom de l'utilisateur
    private Button start; // Demarrage du questionnaire
    private String nameP;

    @SuppressLint({"WrongViewCast", "SetTextI18n"})

    // Appele lorsque l'application est creee
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Association a l'activite en layout
        setContentView(R.layout.activity_main);

        // Reference aux elements graphiques de  l'activité
        editName = findViewById((R.id.PersonName));
        start = findViewById(R.id.start);

        // On recupere la valeur envoyee par la page Profil
        Intent intent = getIntent();
        String name = intent.getStringExtra("personname");

        // Permet d'afficher dans les Log le nom transfere de la page suivante
        Log.d(TAG, "onCreate: Previous Person name : " + name);

        // On attribue la valeur pour pouvoir afficher
        nameP = name;

        // On affiche l'information
        editName.setText(nameP);

        // Bouton desactive tant que l'utilisateur n'a pas entre son nom
        //start.setEnabled(false);

        // Valeur du champs par défaut
        //editName.setText("Name");

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

        // On restaure la valeur du champs lors d'un retour depuis la page précédente
        //editName.setText(nameP);

        processIntentData();

    }

    // Permet de passer à la premiere page du formulaire via le bouton start
    public void action_start(View sender) {
        Log.d(TAG, "action_start: Demarrage du test");
        Intent intent = new Intent(this, Profil.class);
        intent.putExtra("personname", editName.getText().toString());// Permet de transferer la donnée de nom lors du changement de page
        startActivity(intent);
        Toast.makeText(this, "Recorded response", Toast.LENGTH_LONG).show();
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

    // Cette methode est appelee par la methode onCreate, elle permet le transfert des donnees renseignees
    private void processIntentData() {
        Intent intent = getIntent();
        if (intent != null) {
            Person transferredPersonPrevious = intent.getParcelableExtra("FromActivity2ToActivity1");
            if (transferredPersonPrevious != null) {
                // Attribution a la classe Person
                transferredPersonPrevious.print();
            } else {
                Log.d(TAG, "No Person found after transfer from Activity2");
            }
        } else {
            Log.d(TAG, "Error when transferring from Activity2");
        }
    }

    // Creation d'une key pour l'application


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