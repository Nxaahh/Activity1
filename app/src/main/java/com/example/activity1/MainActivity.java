package com.example.activity1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // Método que se ejecuta al crear la actividad

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

      //Declaracion del objeto Button
        Button btnNext = findViewById(R.id.btnNext);

        // Define la acción a realizar cuando el botón es presionado
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crea un Intent para cambiar de actividad a SecondActivity
                Intent intentSecondActivity = new Intent(MainActivity.this,SecondActivity.class);
                // Inicia la nueva actividad usando el Intent
                startActivity(intentSecondActivity);
            }
        });
    }
    // Método que se ejecuta cuando la actividad entra en el estado "onStart", justo antes de que sea visible para el usuario
    @Override
    protected void onStart(){


        super.onStart();
        Log.i("Ciclo de Vida","Ha entrado en el metodo onStart");
    }
    // Método que se ejecuta cuando la actividad entra en el estado "onResume", justo antes de que el usuario pueda interactuar con ella
    @Override
    protected  void onResume(){
        super.onResume();
        Log.i("Ciclo de Vida","Ha entrado en el metodo onResume");

    }

    // Método que se ejecuta cuando la actividad está a punto de ser pausada, normalmente cuando otra actividad toma el foco
    @Override
    protected void onPause(){
        super.onPause();

        Log.i("Ciclo de Vida","Ha entrado en el metodo onPause");

    }

    // Método que se ejecuta cuando la actividad ya no es visible para el usuario
    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Ciclo de Vida","Ha entrado en el metodo onStop");

    }

    // Método que se ejecuta cuando la actividad está a punto de ser destruida, ya sea porque el usuario la ha cerrado o el sistema la está finalizando para liberar recursos
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Ciclo de Vida","Ha entrado en el metodo onDestroy");

    }
}