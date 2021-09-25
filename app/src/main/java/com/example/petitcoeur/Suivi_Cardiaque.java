package com.example.petitcoeur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;


public class Suivi_Cardiaque extends AppCompatActivity {

    public static final String TAG = MainActivity.TAG;

    private Switch switch1;
    private EditText editInputTemp;
    private Person person;
    private String contentDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suivi_cardiaque);

        Switch switch1 = findViewById(R.id.switch1);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { //PROMBLEME AVEC LE SWITCH
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.d(TAG, "onCheckedChanged: Etat du switch : " + b);
                Log.d(TAG, "onCheckedChanged: Etat du composant graphique : " + switch1.isChecked());
            }
        });

        processIntentData();
    }

    // Permet de passer à la page suivante du formulaire
    public void action_next_page(View sender){
        Log.d(TAG, "action_next_page: Passage à la suite du formulaire");
        Intent intent = new Intent(this, hygiene_vie.class);
        startActivity(intent);

        goToActivity5();
    }

    // Permet de revenir à la page précédente du formulaire
    public void action_previous_page(View sender){
        Log.d(TAG, "action_previous_page: Passage à la page précédente du formulaire");
        Intent intent = new Intent(this, MonCoeur.class);
        startActivity(intent);

        goToActivity3();
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

    public void goToActivity5(){
        Intent activity5Intent = new Intent(this, hygiene_vie.class);
        activity5Intent.putExtra("FromActivity4ToActivity5", this.person);
        startActivity(activity5Intent);
    }

    public void goToActivity3(){
        Intent activityIntent = new Intent(this, MonCoeur.class);
        activityIntent.putExtra("FromActivity4ToActivity3", this.person);
        startActivity(activityIntent);
    }
}