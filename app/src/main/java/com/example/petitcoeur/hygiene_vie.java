package com.example.petitcoeur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class hygiene_vie extends AppCompatActivity {

    public static final String TAG = MainActivity.TAG;
    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hygiene_vie);

        Log.d(TAG, "onCreate: ");
        // On recupere la valeur envoyée par la page précédente
        Intent intent = getIntent();
        String name = intent.getStringExtra("coeur");
        Log.d(TAG, "onCreate: Person name : " + name);

        processIntentData();
    }

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
    public void goToActivity4(){
        Intent activityIntent = new Intent(this, Suivi_Cardiaque.class);
        activityIntent.putExtra("FromActivity5ToActivity4", this.person);
        startActivity(activityIntent);
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





