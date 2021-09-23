package com.example.petitcoeur;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    public static final String TAG = "UPCoeur";
    private EditText editName;
    private Person person;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName = findViewById((R.id.name));

        // On restaure suite à un OnCreate
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

    // This method (whose name is abritrary) is called by onCreate().
    private void processIntentData() {
        Intent intent = getIntent();
        if(intent != null) {
// intent may store different data. To get the one matching the Person class,
// we need the key "FromActivity1ToActivity2" which was used for transfer
// No need to calls "new()" for allocating memory to transferredPerson
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

    public void goToActivity2(){
        Intent activity2Intent = new Intent(this, Profil.class);
        activity2Intent.putExtra("FromActivity1ToActivity2", this.person);
        startActivity(activity2Intent);
    }

}