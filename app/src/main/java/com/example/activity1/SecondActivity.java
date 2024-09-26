package com.example.activity1;

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

public class SecondActivity extends AppCompatActivity {
    private String Checkk = "False";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText editTextText = findViewById(R.id.editTextText);
        EditText editTextNumber = findViewById(R.id.editTextNumber);
        EditText editTextNumberDecimal = findViewById(R.id.editTextNumberDecimal);

        Button btnSend = findViewById(R.id.btnSend);
        Button btnBack = findViewById(R.id.btnBack);
        Switch switch1 = findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Checkk = "True";
            } else {
                Checkk = "False";
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextText.getText().toString().equals("")){
                    Toast toastName = new Toast(SecondActivity.this);
                    toastName.setText("Text can´t be empty");
                    toastName.show();
                } else if (editTextNumber.getText().toString().equals("")){
                    Toast toastName = new Toast(SecondActivity.this);
                    toastName.setText("Number can´t be empty");
                    toastName.show();

                }else if (editTextNumberDecimal.getText().toString().equals("")) {
                    Toast toastName = new Toast(SecondActivity.this);
                    toastName.setText("Decimal Number can´t be empty");
                    toastName.show();
                }
                else{
                    Intent terceraPantalla = new Intent(SecondActivity.this, ThirdActivity.class);

                    terceraPantalla.putExtra("Texto", editTextText.getText().toString());
                    terceraPantalla.putExtra("Numero", editTextNumber.getText().toString());
                    terceraPantalla.putExtra("Decimal", editTextNumberDecimal.getText().toString());
                    terceraPantalla.putExtra("Check",Checkk);
                    startActivity(terceraPantalla);
                }



            }
        });


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent primeraPantalla = new Intent(SecondActivity.this,MainActivity.class);
                startActivity(primeraPantalla);
            }
        });

    }

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