package com.example.factorial;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText firstNumber, secondNumber;
    private TextView resultView;
    private Button btnAdd, btnSub, btnMul, btnDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumber = findViewById(R.id.num1);
        secondNumber = findViewById(R.id.num2);
        resultView = findViewById(R.id.result);

        btnAdd = findViewById(R.id.add);
        btnSub = findViewById(R.id.sub);
        btnMul = findViewById(R.id.mul);
        btnDiv = findViewById(R.id.div);

        btnAdd.setOnClickListener(v -> calculate('+'));
        btnSub.setOnClickListener(v -> calculate('-'));
        btnMul.setOnClickListener(v -> calculate('*'));
        btnDiv.setOnClickListener(v -> calculate('/'));
    }

    private void calculate(char operator) {

        String val1 = firstNumber.getText().toString().trim();
        String val2 = secondNumber.getText().toString().trim();

        if (val1.isEmpty() || val2.isEmpty()) {
            resultView.setText("Enter both numbers");
            return;
        }

        double n1 = Double.parseDouble(val1);
        double n2 = Double.parseDouble(val2);
        double output = 0;

        switch (operator) {
            case '+':
                output = n1 + n2;
                break;
            case '-':
                output = n1 - n2;
                break;
            case '*':
                output = n1 * n2;
                break;
            case '/':
                if (n2 == 0) {
                    resultView.setText("Cannot divide by zero");
                    return;
                }
                output = n1 / n2;
                break;
        }

        resultView.setText("Result: " + output);
    }
}