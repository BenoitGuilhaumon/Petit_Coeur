package com.example.petitcoeur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
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
    }
