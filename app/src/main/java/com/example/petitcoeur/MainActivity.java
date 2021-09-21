package com.example.petitcoeur;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void action_start(Bundle savedInstanceState) {
        Button button_start = null;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_start = (Button) findViewById(R.id.start);

        button_start.setOnClickListener(new View.OnClickListener() {

            public void onClick(View button11) {

                Intent intent1 = new Intent(MainActivity.this, je_suis.class);

                startActivity(intent1);
            }

        });
    }

}