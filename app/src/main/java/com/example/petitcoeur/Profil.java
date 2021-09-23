package com.example.petitcoeur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Profil extends AppCompatActivity {

    public static final String TAG = MainActivity.TAG;
    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        Log.d(TAG, "onCreate: ");
        // On recupere la valeur envoyée par la page précédente
        Intent intent = getIntent();
        String name = intent.getStringExtra("personname");
        Log.d(TAG, "onCreate: Person name : " + name);

        processIntentData();
    }

    // Permet de passer à la page suivante du formulaire
    public void action_next_page(View sender){
        Log.d(TAG, "action_next_page: Passage à la suite du formulaire");
        Intent intent = new Intent(this, MonCoeur.class);
        startActivity(intent);

        goToActivity3();
    }

    // Permet de passer à la premiere page du formulaire via le bouton start
    public void action_previous_page(View sender){
        Log.d(TAG, "action_next_page: Passage à la page précédente du formulaire");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        goToActivity1();
    }

    // This method (whose name is abritrary) is called by onCreate().
    private void processIntentData() {
        Intent intent = getIntent();
        if(intent != null) {
// intent may store different data. To get the one matching the Person class,
// we need the key "FromActivity1ToActivity2" which was used for transfer
// No need to calls "new()" for allocating memory to transferredPerson
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

    public void goToActivity3(){
        Intent activity3Intent = new Intent(this, MonCoeur.class);
        activity3Intent.putExtra("FromActivity2ToActivity3", this.person);
        startActivity(activity3Intent);
    }

    public void goToActivity1(){
        Intent activityIntent = new Intent(this, MainActivity.class);
        activityIntent.putExtra("FromActivity2ToActivity1", this.person);
        startActivity(activityIntent);
    }

    public void action_finish(View v){
        finish(); //Permet de revenir à la page initiale
    }
}