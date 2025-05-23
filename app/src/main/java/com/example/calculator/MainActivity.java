package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        resultView = findViewById(R.id.resultView);

        btnAdd.setOnClickListener(view -> calculate('+', view));
        btnSubtract.setOnClickListener(view -> calculate('-', view));
        btnMultiply.setOnClickListener(view -> calculate('*', view));
        btnDivide.setOnClickListener(view -> calculate('/', view));
    }

    private void calculate(char operator, View view){
        String input1 = number1.getText().toString();
        String input2 = number2.getText().toString();
        if (input1.isEmpty() || input2.isEmpty()) {
            resultView.setText("Please enter both numbers.");
            return;
        }

        double num1 = Double.parseDouble(input1);
        double num2 = Double.parseDouble(input2);
        double result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    resultView.setText("Cannot divide by zero.");
                    return;
                }
                result = num1 / num2;
                break;
        }

        resultView.setText("Result: " + result);
    }
}