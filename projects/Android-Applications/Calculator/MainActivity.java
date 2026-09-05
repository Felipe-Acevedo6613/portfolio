package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView ecran;
    private double premierNombre = Double.NaN;
    private double deuxiemeNombre;
    private String operateur = "";
    private boolean estNouvelleOperation = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ecran = findViewById(R.id.ecran);

        Button bouton0 = findViewById(R.id.bouton0);
        Button bouton1 = findViewById(R.id.bouton1);
        Button bouton2 = findViewById(R.id.bouton2);
        Button bouton3 = findViewById(R.id.bouton3);
        Button bouton4 = findViewById(R.id.bouton4);
        Button bouton5 = findViewById(R.id.bouton5);
        Button bouton6 = findViewById(R.id.bouton6);
        Button bouton7 = findViewById(R.id.bouton7);
        Button bouton8 = findViewById(R.id.bouton8);
        Button bouton9 = findViewById(R.id.bouton9);
        Button boutonEffacer = findViewById(R.id.boutonEffacer);
        Button boutonEgal = findViewById(R.id.boutonEgal);
        Button boutonPlus = findViewById(R.id.boutonPlus);
        Button boutonMoins = findViewById(R.id.boutonMoins);
        Button boutonMultiplier = findViewById(R.id.boutonMultiplier);
        Button boutonDivise = findViewById(R.id.boutonDiviser);

        View.OnClickListener listenerNumeros = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button bouton = (Button) view;
                if (estNouvelleOperation) {
                    ecran.setText(bouton.getText());
                    estNouvelleOperation = false;
                } else {
                    ecran.setText(ecran.getText().toString() + bouton.getText());
                }
            }
        };

        bouton0.setOnClickListener(listenerNumeros);
        bouton1.setOnClickListener(listenerNumeros);
        bouton2.setOnClickListener(listenerNumeros);
        bouton3.setOnClickListener(listenerNumeros);
        bouton4.setOnClickListener(listenerNumeros);
        bouton5.setOnClickListener(listenerNumeros);
        bouton6.setOnClickListener(listenerNumeros);
        bouton7.setOnClickListener(listenerNumeros);
        bouton8.setOnClickListener(listenerNumeros);
        bouton9.setOnClickListener(listenerNumeros);

        View.OnClickListener listenerOperateur = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button bouton = (Button) view;
                if (!Double.isNaN(premierNombre)) {
                    calculer();
                } else {
                    premierNombre = Double.parseDouble(ecran.getText().toString());
                }
                operateur = bouton.getText().toString();
                estNouvelleOperation = true;
            }
        };

        boutonPlus.setOnClickListener(listenerOperateur);
        boutonMoins.setOnClickListener(listenerOperateur);
        boutonMultiplier.setOnClickListener(listenerOperateur);
        boutonDivise.setOnClickListener(listenerOperateur);

        boutonEgal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculer();
                operateur = "";
                estNouvelleOperation = true;
            }
        });

        boutonEffacer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                premierNombre = Double.NaN;
                deuxiemeNombre = 0;
                ecran.setText("");
                estNouvelleOperation = true;
            }
        });
    }

    private void calculer() {
        if (!Double.isNaN(premierNombre)) {
            deuxiemeNombre = Double.parseDouble(ecran.getText().toString());

            switch (operateur) {
                case "+":
                    premierNombre = premierNombre + deuxiemeNombre;
                    break;
                case "-":
                    premierNombre = premierNombre - deuxiemeNombre;
                    break;
                case "x":
                    premierNombre = premierNombre * deuxiemeNombre;
                    break;
                case "/":
                    if (deuxiemeNombre != 0) {
                        premierNombre = premierNombre / deuxiemeNombre;
                    } else {
                        ecran.setText("E");
                        return;
                    }
                    break;
            }
            ecran.setText(String.valueOf(premierNombre));
        }
    }
}
