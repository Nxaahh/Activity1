package com.example.activity1;

// Importaciones necesarias para manejar componentes de la interfaz de usuario, ciclo de vida de la actividad, intenciones entre actividades, y compatibilidad con insets del sistema
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// Clase que representa la segunda actividad (SecondActivity) y hereda de AppCompatActivity
public class SecondActivity extends AppCompatActivity {
    // Variable que se usará para almacenar el estado del Switch
    private String Checkk = "False";

    // Método que se ejecuta cuando la actividad se crea
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Activa el modo EdgeToEdge para que la actividad ocupe toda la pantalla
        EdgeToEdge.enable(this);

        // Establece el layout de la actividad
        setContentView(R.layout.activity_second);

        // Ajuste de los márgenes según los insets del sistema (barra de estado, barra de navegación, etc.)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Declaración y referencia de los elementos EditText para la captura de texto, números y decimales
        EditText editTextText = findViewById(R.id.editTextText);
        EditText editTextNumber = findViewById(R.id.editTextNumber);
        EditText editTextNumberDecimal = findViewById(R.id.editTextNumberDecimal);

        // Declaración de botones para enviar los datos o volver a la pantalla anterior
        Button btnSend = findViewById(R.id.btnSend);
        Button btnBack = findViewById(R.id.btnBack);

        // Declaración del Switch y su listener para cambiar el valor de la variable Checkk según el estado del Switch
        Switch switch1 = findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Checkk = "True";  // Si el switch está activado, la variable Checkk se establece como "True"
            } else {
                Checkk = "False"; // Si el switch está desactivado, la variable Checkk se establece como "False"
            }
        });

        // Acción que ocurre al presionar el botón "Send"
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validación de los campos de texto, mostrando un mensaje Toast si algún campo está vacío
                if (editTextText.getText().toString().equals("")){
                    Toast toastName = new Toast(SecondActivity.this);
                    toastName.setText("Text can´t be empty");
                    toastName.show();
                } else if (editTextNumber.getText().toString().equals("")){
                    Toast toastName = new Toast(SecondActivity.this);
                    toastName.setText("Number can´t be empty");
                    toastName.show();
                } else if (editTextNumberDecimal.getText().toString().equals("")) {
                    Toast toastName = new Toast(SecondActivity.this);
                    toastName.setText("Decimal Number can´t be empty");
                    toastName.show();
                }
                // Si todos los campos están completos, se envían los datos a la tercera actividad (ThirdActivity)
                else {
                    Intent terceraPantalla = new Intent(SecondActivity.this, ThirdActivity.class);

                    // Se añaden los datos de los campos de texto y el estado del switch al Intent
                    terceraPantalla.putExtra("Texto", editTextText.getText().toString());
                    terceraPantalla.putExtra("Numero", editTextNumber.getText().toString());
                    terceraPantalla.putExtra("Decimal", editTextNumberDecimal.getText().toString());
                    terceraPantalla.putExtra("Check", Checkk);

                    // Se inicia la tercera actividad con los datos enviados
                    startActivity(terceraPantalla);
                }
            }
        });

        // Acción que ocurre al presionar el botón "Back", para volver a la primera actividad (MainActivity)
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent primeraPantalla = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(primeraPantalla);  // Se inicia la primera actividad
            }
        });
    }

    // Métodos del ciclo de vida de la actividad para hacer un seguimiento de los diferentes estados
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Ciclo de Vida", "Ha entrado en el metodo onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Ciclo de Vida", "Ha entrado en el metodo onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de Vida", "Ha entrado en el metodo onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ciclo de Vida", "Ha entrado en el metodo onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo de Vida", "Ha entrado en el metodo onDestroy");
    }
}
