package com.example.petitcoeur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;



public class Suivi_Cardiaque extends AppCompatActivity {

    public static final String TAG = MainActivity.TAG;

    private Switch switch1;
    private EditText editInputTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suivi_cardiaque);

        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            Log.d(TAG, "onKey: touche : switch yes");
            if (switch1.isChecked())
                conversion();
            return false;
        }

    }
}