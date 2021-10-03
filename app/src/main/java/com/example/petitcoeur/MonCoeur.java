/**
  Projet programmation Android
  @author GUILHAUMON Benoit, MOUSSET Leana M2 GPhy
 * @version 03/10/2021
 */

/**
 * @Class MonCoeur
 * Cette classe est la troisième page du questionnaire.
 * Permet à l'utilisateur de renseigner des informations sur la condition cardiaque, les antécédants, le diabéte ou le cholesterol.
 * Le tout via des spinners.
 */

package com.example.petitcoeur;

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

import androidx.appcompat.app.AppCompatActivity;

// Activity 3
public class MonCoeur extends AppCompatActivity {

    // Declaration du TAG du projet
    public static final String TAG = MainActivity.TAG;

    // Attribution a la classe Person
    private Person person;

    // Declaration des elements graphiques
    private Spinner heartCondition, diabetic, firstDegree, cholesterol;
    private Button nextstep;
    private String namePerson, sexePerson, agePerson;
    private int selec, selec1, selec2, selec3, selec4;

    @SuppressLint({"WrongViewCast", "CutPasteId"})

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_coeur);

        // On attribue la valeur pour pouvoir afficher
        heartCondition = findViewById(R.id.heartCondition);
        diabetic = findViewById(R.id.diabetic);
        firstDegree = findViewById(R.id.fitstDegree);
        cholesterol = findViewById(R.id.cholesterol);
        nextstep = findViewById(R.id.nextstep2);
        findViewById(R.id.previousstep2);
        // Demarrage du questionnaire
        findViewById(R.id.nextstep2);
        // retour à la page precedente du questionnaire
        findViewById(R.id.previousstep2);

        // On recupere la valeur envoyée par la page précédente
        Intent intent = getIntent();
        String name = intent.getStringExtra("personname");
        String sexe = intent.getStringExtra("sexe");
        String age = intent.getStringExtra("age");

        // Je verifie que les données sont bien transferees
        // Permet d'afficher dans les Log le nom transfere de la page precedente
        Log.d(TAG, "onCreate: Person name : " + name);
        Log.d(TAG, "onCreate: Person sexe : " + sexe);
        Log.d(TAG, "onCreate: Person age : " + age);

        // J'attribue les valeurs recuperees pour pouvoir les retransferrer
        namePerson = name;
        sexePerson = sexe;
        agePerson = age;

        // Bouton desactive tant que l'utilisateur n'a complété toutes les questions
        nextstep.setEnabled(false);

        // On recupere la valeur envoyée par la page suivante
        Intent intentP = getIntent();
        String sexeP = intentP.getStringExtra("sexe");
        String ageP = intentP.getStringExtra("age");
        String nameP = intent.getStringExtra("personname");
        String spinnerHeartCondition = intent.getStringExtra("spinnerHeartCondition");
        String spinnerDiabetic = intent.getStringExtra("spinnerDiabetic");
        String spinnerFirstDegree = intent.getStringExtra("spinnerFirstDegree");
        String spinnerCholesterol = intent.getStringExtra("spinnerCholesterol");

        // Permet d'afficher dans les Log le nom transfere de la page suivante
        Log.d(TAG, "onCreate: Previous Person Informations : " + nameP + ageP + sexeP + spinnerHeartCondition + spinnerDiabetic + spinnerFirstDegree + spinnerCholesterol);

        selec = 0;
        heartCondition.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemSelected: Info position : " + heartCondition.getSelectedItemPosition());
                Log.d(TAG, "onItemSelected: Info object: " + heartCondition.getSelectedItem());
                Log.d(TAG, "onItemSelected: Info id : " + heartCondition.getSelectedItemId());

                selec1 = selec1 + 1;
            }

            @Override // Si rien est selectionne, un message apparait
            public void onNothingSelected(AdapterView<?> adapterView) {
                vibrate();
            }
        });

        diabetic.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemSelected: Info position : " + diabetic.getSelectedItemPosition());
                Log.d(TAG, "onItemSelected: Info object: " + diabetic.getSelectedItem());
                Log.d(TAG, "onItemSelected: Info id : " + diabetic.getSelectedItemId());

                selec2 = selec1 + 1;
            }

            @Override // Si rien n'est selectionne, un message apparait
            public void onNothingSelected(AdapterView<?> adapterView) {
                vibrate();
            }
        });

        firstDegree.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemSelected: Info position : " + firstDegree.getSelectedItemPosition());
                Log.d(TAG, "onItemSelected: Info object: " + firstDegree.getSelectedItem());
                Log.d(TAG, "onItemSelected: Info id : " + firstDegree.getSelectedItemId());

                selec3 = selec2 + 1;
            }

            @Override // Si rien n'est selectionne, un message apparait
            public void onNothingSelected(AdapterView<?> adapterView) {
                vibrate();
            }
        });

        cholesterol.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemSelected: Info position : " + cholesterol.getSelectedItemPosition());
                Log.d(TAG, "onItemSelected: Info object: " + cholesterol.getSelectedItem());
                Log.d(TAG, "onItemSelected: Info id : " + cholesterol.getSelectedItemId());

                selec4 = selec3 + 1;
                // On verifie si tous les champs sont remplis pour débloquer le bouton Nextstep
                Log.d(TAG, "onItemSelected: Select item " + selec4);
                if (selec4 >= 4) {
                    nextstep.setEnabled(true);
                }
            }

            @Override // Si rien n'est selectionne, un message apparait
            public void onNothingSelected(AdapterView<?> adapterView) {
                vibrate();
            }
        });

        // Essai pour debloquer le bouton nextstep que si toutes les réponses ont été sélectionnées
        /*if ((heartCondition.isActivated()) && (diabetic.isActivated()) && (firstDegree.isActivated()) && (cholesterol.isActivated())) {
            nextstep.setEnabled(true);
        }
        String nameS = null;
        if(heartCondition != null && heartCondition.getSelectedItem() !=null ) {
            nameS = (String)heartCondition.getSelectedItem();
        }
*/
        processIntentData();
    }

    // Permet de passer à la page suivante du formulaire en transferrant les informations des pages precedentes
    public void action_next_page(View sender) {
        Log.d(TAG, "action_next_page: Passage à la suite du formulaire");
        Intent intent = new Intent(this, Suivi_Cardiaque.class);
        intent.putExtra("spinnerHeartCondition", heartCondition.getSelectedItem().toString());
        intent.putExtra("spinnerDiabetic", diabetic.getSelectedItem().toString());
        intent.putExtra("spinnerFirstDegree", firstDegree.getSelectedItem().toString());
        intent.putExtra("spinnerCholesterol", cholesterol.getSelectedItem().toString());
        intent.putExtra("sexe", sexePerson);
        intent.putExtra("age", agePerson);
        intent.putExtra("personname", namePerson);
        startActivity(intent);

        //goToActivity4();
    }

    // Permet de revenir à la page précédente du formulaire
    public void action_previous_page(View sender) {
        Log.d(TAG, "action_previous_page: Passage à la page précédente du formulaire");
        Intent intent = new Intent(this, Profil.class);
        intent.putExtra("sexe", sexePerson);
        intent.putExtra("age", agePerson);
        intent.putExtra("personname", namePerson);
        startActivity(intent);

        // goToActivity2();
    }

    public void vibrate() {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long duration_ms = 1;
        if (v != null && v.hasVibrator()) {
            if (Build.VERSION.SDK_INT >= 26) {
                v.vibrate(VibrationEffect.createOneShot(duration_ms, VibrationEffect.DEFAULT_AMPLITUDE));
            }
        } else {
            assert v != null;
            v.vibrate(duration_ms);
        }
        // Pas de vibration
    }

    private void processIntentData() {
        Intent intent = getIntent();
        if (intent != null) {
// intent may store different data. To get the one matching the Person class,
// we need the key "FromActivity1ToActivity2" which was used for transfer
// No need to calls "new()" for allocating memory to transferredPerson
            Person transferredPerson = intent.getParcelableExtra("FromActivity2ToActivity3");
            Person transferredPersonPrevious = intent.getParcelableExtra("FromActivity4ToActivity3");
            if (transferredPerson != null) {
                this.person = transferredPerson;
                this.person.print();
            } else {
                Log.d(TAG, "No Person found after transfer from Activity2");
            }
            if (transferredPersonPrevious != null) {
                this.person = transferredPersonPrevious;
                this.person.print();
            } else {
                Log.d(TAG, "No Person found after transfer from Activity4");
            }
        } else {
            Log.d(TAG, "Error when transferring from Activity2");
        }
    }

    public void goToActivity4() {
        Intent activity4Intent = new Intent(this, Suivi_Cardiaque.class);
        activity4Intent.putExtra("FromActivity3ToActivity4", this.person);
        startActivity(activity4Intent);
    }

    public void goToActivity2() {
        Intent activityIntent = new Intent(this, Profil.class);
        activityIntent.putExtra("FromActivity3ToActivity2", this.person);
        startActivity(activityIntent);
    }
}
