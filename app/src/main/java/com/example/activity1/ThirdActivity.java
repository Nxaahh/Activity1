package com.example.activity1;

// Importaciones necesarias para manejar las interacciones de la interfaz de usuario, el ciclo de vida de la actividad, y la navegación entre actividades
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// Clase que representa la tercera actividad (ThirdActivity), hereda de AppCompatActivity
public class ThirdActivity extends AppCompatActivity {

    // Método que se ejecuta cuando la actividad se crea
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Activa el modo EdgeToEdge para que la actividad ocupe toda la pantalla
        EdgeToEdge.enable(this);

        // Establece el layout de la actividad
        setContentView(R.layout.activity_third);

        // Ajuste de los márgenes según los insets del sistema (barra de estado, barra de navegación, etc.)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Declaración de los elementos de la interfaz que mostrarán la información (TextViews)
        TextView textViewText = findViewById(R.id.textViewText);
        TextView textViewNumber = findViewById(R.id.textViewNumber);
        TextView textViewDecimal = findViewById(R.id.textViewDecimal);
        TextView textViewBoolean = findViewById(R.id.textViewBoolean);

        // Declaración del botón para regresar a la pantalla principal (MainActivity)
        Button btnHome = findViewById(R.id.btnHome);

        // Acción que ocurre al presionar el botón "Home", para volver a la actividad principal
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goHome = new Intent(ThirdActivity.this, MainActivity.class);
                startActivity(goHome);  // Inicia la actividad principal
            }
        });

        // Recibe los datos enviados desde la SecondActivity a través del Intent
        Intent intentSecondActivity = getIntent();
        String Text = intentSecondActivity.getStringExtra("Texto");
        String Number = intentSecondActivity.getStringExtra("Numero");
        String Decimal = intentSecondActivity.getStringExtra("Decimal");
        String Check = intentSecondActivity.getStringExtra("Check");

        // Asigna los datos recibidos a los TextViews para mostrarlos en la interfaz
        textViewText.setText(Text);
        textViewNumber.setText(Number);
        textViewDecimal.setText(Decimal);
        textViewBoolean.setText(Check);
    }
}
