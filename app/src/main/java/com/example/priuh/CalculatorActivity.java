package com.example.priuh;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {
    Button button_calculate;
    EditText num1, num2;
    Spinner spinnerOperations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        button_calculate = findViewById(R.id.button_calculate);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        spinnerOperations = findViewById(R.id.spinnerOperations);

        button_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = num1.getText().toString();
                String text2 = num2.getText().toString();

                if (text1.equals("") || text2.equals("")) {
                    Toast.makeText(CalculatorActivity.this, "Los datos están vacíos", Toast.LENGTH_LONG).show();
                } else {
                    double numero1 = Double.parseDouble(text1);
                    double numero2 = Double.parseDouble(text2);
                    String operation = spinnerOperations.getSelectedItem().toString();
                    double result = 0;

                    switch (operation) {
                        case "Suma":
                            result = numero1 + numero2;
                            break;
                        case "Resta":
                            result = numero1 - numero2;
                            break;
                        case "Multiplicación":
                            result = numero1 * numero2;
                            break;
                        case "División":
                            if (numero2 != 0) {
                                result = numero1 / numero2;
                            } else {
                                Toast.makeText(CalculatorActivity.this, "División por cero no permitida", Toast.LENGTH_LONG).show();
                                return;
                            }
                            break;
                    }

                    Toast.makeText(CalculatorActivity.this, "El resultado es: " + result, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
