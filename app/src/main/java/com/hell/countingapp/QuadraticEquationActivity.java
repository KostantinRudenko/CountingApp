package com.hell.countingapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Map;


public class QuadraticEquationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quadratic_equation);

        TextInputEditText ATxt = (TextInputEditText) findViewById(R.id.ATF);
        TextInputEditText BTxt = (TextInputEditText) findViewById(R.id.BTF);
        TextInputEditText CTxt = (TextInputEditText) findViewById(R.id.CTF);

        TextView resText = (TextView) findViewById(R.id.results);

        Button backBtn = (Button) findViewById(R.id.exit);
        Button countBtn = (Button) findViewById(R.id.countBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent
                (QuadraticEquationActivity.this, MainActivity.class);

                startActivity(intent);
            }
        });
        countBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if    (!ATxt.getText().toString().trim().isEmpty()
                    && !BTxt.getText().toString().trim().isEmpty()
                    && !CTxt.getText().toString().trim().isEmpty()) {
                    try {
                        int a = Integer.parseInt(ATxt.getText().toString());
                        int b = Integer.parseInt(BTxt.getText().toString());
                        int c = Integer.parseInt(CTxt.getText().toString());

                        double sqrtD = Math.sqrt(Math.pow(b, 2) - 4 * a * c);
                        double x1 = (-b + sqrtD) / (2 * a);
                        double x2 = (-b - sqrtD) / (2 * a);

                        if (!Double.isNaN(x1) && !Double.isNaN(x2)) {
                            resText.setText(String.format("%.2f; %.2f", x1, x2));
                        } else {
                            resText.setText("Fuck you");
                        }
                    } catch (NumberFormatException e) {
                        resText.setText("Fuck you");
                    }
                }
                else
                {
                    resText.setText("Some field is empty");
                }
            }
        });
    }
}