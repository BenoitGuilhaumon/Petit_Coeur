/**
 * Projet programmation Android
 * @author GUILHAUMON Benoit, MOUSSET Leana M2 GPhy
 * @version 03/10/2021
 */

/**
 * @Class Previous_Profil
 * Cette classe permet de récuperer les valeurs du questionnaire lors d'un retour en arriére à partir de la classe Mon_Coeur.
 * On va pouvoir afficher les valeurs renseignées sur l'interface Profil.xml.
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
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


// Activity 2
public class Previous_Profil extends AppCompatActivity {

    // Declaration du tag du projet
    public static final String TAG = MainActivity.TAG;

    // Attribution a la classe Person
    private Person person;

    // Declaration des elements graphiques
    private RadioButton SexMan; // Sexe de l'utilisateur
    private RadioButton SexWoman; // Sexe de l'utilisateur
    private RadioButton SexOther; // Sexe de l'utilisateur
    private EditText age; // Age de l'utilisateur
    private String sexeP;
    private String namePerson;
    private String sexePerson;
    private String agePerson;
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

        // Reference aux elements graphiques
        SexMan = findViewById((R.id.man));
        SexWoman = findViewById(R.id.woman);
        SexOther = findViewById(R.id.other);
        age = findViewById(R.id.editAge);
        nextstep = findViewById(R.id.nextstep);
        previousstep = findViewById(R.id.previousstep);

        // On recupere la valeur envoyée par la page Mon Coeur
        Intent intentP = getIntent();
        String sexe = intentP.getStringExtra("sexe");
        String ageP = intentP.getStringExtra("age");
        String nameP = intentP.getStringExtra("personname");

        // On attribue les informations pour retransfrerer
        namePerson = nameP;

        // Permet d'afficher dans les Log le nom transfere de la page suivante
        Log.d(TAG, "onCreate: Previous Person Informations : " + nameP + ageP + sexe);

        // On attribue la valeur pour pouvoir afficher
        sexePerson = sexe;
        agePerson = ageP;

        // On affiche les informations
        age.setText(agePerson);
        if (sexePerson != "Man" && sexePerson != "Woman" && sexePerson != "null"){
            SexOther.setChecked(true);
        }else{
            SexOther.setChecked(false);
        }
        if (sexePerson != "Man" && sexePerson != "Other" && sexePerson != "null"){
            SexWoman.setChecked(true);
        }else{
            SexWoman.setChecked(false);
        }
        if (sexePerson != "Other" && sexePerson != "Woman" && sexePerson != "null"){
            SexMan.setChecked(true);
        }else{
            SexMan.setChecked(false);
        }
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
                //xtstep.setEnabled(true);
            }
        });

        SexMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sexeP = "Man";
            }
        });

        SexWoman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sexeP = "Woman";
            }
        });

        SexOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sexeP = "Other";
            }
        });

        processIntentData();
    }

    // Affichage d'un message
    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    // Permet de passer à la page suivante du formulaire en transferrant les informations des pages precedentes
    public void action_next_page(View sender) {
        Log.d(TAG, "action_next_page: Passage à la suite du formulaire");
        Intent intent = new Intent(this, MonCoeur.class);
        intent.putExtra("sexe", sexeP);
        intent.putExtra("age", age.getText().toString());
        intent.putExtra("personname", namePerson);
        startActivity(intent);

        //goToActivity3();
    }

    // Permet de passer à la premiere page du formulaire via le bouton start
    public void action_previous_page(View sender) {
        Log.d(TAG, "action_next_page: Passage à la page précédente du formulaire");
        Intent intent = new Intent(this, Previous_Main_Activity.class);
        intent.putExtra("personname", namePerson);
        startActivity(intent);

        // goToActivity1();
    }

    // Methode appele par la methode onCreate, elle permet le transfert des donnees renseignees
    private void processIntentData() {
        Intent intent = getIntent();
        if (intent != null) {
            Person transferredPerson = intent.getParcelableExtra("FromActivity1ToActivity2");
            Person transferredPersonPrevious = intent.getParcelableExtra("FromActivity3ToActivity2");
            if (transferredPerson != null) {
                this.person = transferredPerson;
                this.person.print();
            } else {
                Log.d(TAG, "No Person found after transfer from Activity1");
            }
            if (transferredPersonPrevious != null) {
                this.person = transferredPersonPrevious;
                this.person.print();
            } else {
                Log.d(TAG, "No Person found after transfer from Activity3");
            }
        } else {
            Log.d(TAG, "Error when transferring from Activity1");
        }
    }

    // Passage a l'activite suivante
    public void goToActivity3() {
        Intent activity3Intent = new Intent(this, MonCoeur.class);
        activity3Intent.putExtra("FromActivity2ToActivity3", this.person);
        startActivity(activity3Intent);
        toast("Recorded response");
    }

    // Retour a l'activite precedente
    public void goToActivity1() {
        Intent activityIntent = new Intent(this, MainActivity.class);
        activityIntent.putExtra("FromActivity2ToActivity1", this.person);
        startActivity(activityIntent);
    }

}