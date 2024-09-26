package com.example.activity1;

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

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView textViewText = findViewById(R.id.textViewText);
        TextView textViewNumber = findViewById(R.id.textViewNumber);
        TextView textViewDecimal = findViewById(R.id.textViewDecimal);
        TextView textViewBoolean = findViewById(R.id.textViewBoolean);
        Button btnHome = findViewById(R.id.btnHome);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goHome = new Intent(ThirdActivity.this,MainActivity.class);
                startActivity(goHome);
            }
        });


        Intent intentSecondActivity = getIntent();
        String Text = intentSecondActivity.getStringExtra("Texto");
        String Number = intentSecondActivity.getStringExtra("Numero");
        String Decimal = intentSecondActivity.getStringExtra("Decimal");
        String Check = intentSecondActivity.getStringExtra("Check");

        textViewText.setText(Text);
        textViewNumber.setText(Number);
        textViewDecimal.setText(Decimal);
        textViewBoolean.setText(Check);

    }
}