package com.example.petitcoeur;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MonCoeur extends AppCompatActivity {

    // Declaration du TAG du projet
    public static final String TAG = MainActivity.TAG;

    // Attribution a la classe Person
    private Person person;

    // Declaration des elements graphiques
    private Spinner spinner, spinner1, spinner2, spinner3;
    private Button nextstep; // Demarrage du questionnaire
    private Button previousstep; // Demarrage du questionnaire

    @SuppressLint("WrongViewCast")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_coeur);

        spinner = findViewById(R.id.spinner);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        nextstep = findViewById(R.id.nextstep2);
        previousstep = findViewById(R.id.previousstep2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemSelected: Info position : " + spinner.getSelectedItemPosition());
                Log.d(TAG, "onItemSelected: Info object: " + spinner.getSelectedItem());
                Log.d(TAG, "onItemSelected: Info id : " + spinner.getSelectedItemId());

            }

            @Override // Si rien est selectionne, un message apparait
            public void onNothingSelected(AdapterView<?> adapterView) {
                vibrate(60);
            }
        });

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemSelected: Info position : " + spinner1.getSelectedItemPosition());
                Log.d(TAG, "onItemSelected: Info object: " + spinner1.getSelectedItem());
                Log.d(TAG, "onItemSelected: Info id : " + spinner1.getSelectedItemId());

            }

            @Override // Si rien n'est selectionne, un message apparait
            public void onNothingSelected(AdapterView<?> adapterView) {
                vibrate(60);
            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemSelected: Info position : " + spinner2.getSelectedItemPosition());
                Log.d(TAG, "onItemSelected: Info object: " + spinner2.getSelectedItem());
                Log.d(TAG, "onItemSelected: Info id : " + spinner2.getSelectedItemId());

            }

            @Override // Si rien n'est selectionne, un message apparait
            public void onNothingSelected(AdapterView<?> adapterView) {
                vibrate(60);
            }
        });

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemSelected: Info position : " + spinner3.getSelectedItemPosition());
                Log.d(TAG, "onItemSelected: Info object: " + spinner3.getSelectedItem());
                Log.d(TAG, "onItemSelected: Info id : " + spinner3.getSelectedItemId());

            }

            @Override // Si rien n'est selectionne, un message apparait
            public void onNothingSelected(AdapterView<?> adapterView) {
                vibrate(60);
            }
        });

        processIntentData();
    }

    // Permet de passer à la page suivante du formulaire
    public void action_next_page(View sender){
        Log.d(TAG, "action_next_page: Passage à la suite du formulaire");
        Intent intent = new Intent(this, hygiene_vie.class);
        startActivity(intent);

        goToActivity4();
    }

    // Permet de revenir à la page précédente du formulaire
    public void action_previous_page(View sender){
        Log.d(TAG, "action_previous_page: Passage à la page précédente du formulaire");
        Intent intent = new Intent(this, Profil.class);
        startActivity(intent);

        goToActivity2();
    }

        public void vibrate(long duration_ms) {
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (duration_ms < 1);
                duration_ms = 1;
                if(v != null && v.hasVibrator()) {
                    if(Build.VERSION.SDK_INT >= 26) {
                        v.vibrate(VibrationEffect.createOneShot(duration_ms, VibrationEffect.DEFAULT_AMPLITUDE));
                    }
                }
                    else {
                v.vibrate(duration_ms);
            }
                    // Pas de vibration
        }

    private void processIntentData() {
        Intent intent = getIntent();
        if(intent != null) {
// intent may store different data. To get the one matching the Person class,
// we need the key "FromActivity1ToActivity2" which was used for transfer
// No need to calls "new()" for allocating memory to transferredPerson
            Person transferredPerson = intent.getParcelableExtra("FromActivity2ToActivity3");
            Person transferredPersonPrevious = intent.getParcelableExtra("FromActivity4ToActivity3");
            if (transferredPerson != null) {
                this.person = transferredPerson;
                this.person.print();
            }
            else {
                Log.d(TAG, "No Person found after transfer from Activity2");
            }
            if (transferredPersonPrevious != null) {
                this.person = transferredPersonPrevious;
                this.person.print();
            }
            else {
                Log.d(TAG, "No Person found after transfer from Activity4");
            }
        }
        else {
            Log.d(TAG, "Error when transferring from Activity2");
        }
    }

    public void goToActivity4(){
        Intent activity4Intent = new Intent(this, Suivi_Cardiaque.class);
        activity4Intent.putExtra("FromActivity3ToActivity4", this.person);
        startActivity(activity4Intent);
    }

    public void goToActivity2(){
        Intent activityIntent = new Intent(this, Profil.class);
        activityIntent.putExtra("FromActivity3ToActivity2", this.person);
        startActivity(activityIntent);
    }
}
