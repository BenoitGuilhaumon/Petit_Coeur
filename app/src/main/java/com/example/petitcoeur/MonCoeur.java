package com.example.petitcoeur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class MonCoeur extends AppCompatActivity {

    public static final String TAG = MainActivity.TAG;

    private Spinner spinner, spinner1, spinner2, spinner3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_coeur);
        spinner = findViewById(R.id.spinner);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemSelected: Info position : " + spinner.getSelectedItemPosition());
                Log.d(TAG, "onItemSelected: Info object: " + spinner.getSelectedItem());
                Log.d(TAG, "onItemSelected: Info id : " + spinner.getSelectedItemId());
            }

            @Override // Si rien n'est selectionne, un message apparait
            public void onNothingSelected(AdapterView<?> adapterView) {
                // METTRE UNE VIBRATION QUAND RIEN N EST SELECTIONNE
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
                // METTRE UNE VIBRATION QUAND RIEN N EST SELECTIONNE
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
                // METTRE UNE VIBRATION QUAND RIEN N EST SELECTIONNE
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
                // METTRE UNE VIBRATION QUAND RIEN N EST SELECTIONNE
            }
        });
    }
}