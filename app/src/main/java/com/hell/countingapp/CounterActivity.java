package com.hell.countingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class CounterActivity extends AppCompatActivity {

    TextInputEditText FN;
    TextInputEditText SN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counting);

        Button backBtn = (Button) findViewById(R.id.exit);

        Button plusBtn = (Button) findViewById(R.id.plusBtn);
        Button minusBtn = (Button) findViewById(R.id.minusBtn);
        Button multBtn = (Button) findViewById(R.id.multBtn);
        Button divBtn = (Button) findViewById(R.id.divBtn);

        FN = (TextInputEditText) findViewById(R.id.FNE);
        SN = (TextInputEditText) findViewById(R.id.SNE);

        TextView res = (TextView) findViewById(R.id.result);
        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(CounterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!AreEmpty())
                {
                    double[] nums = CheckForDouble();
                    if (nums.length != 2) {
                        res.setText(String.format("%.2f", nums[0] + nums[1]));}
                    else
                    {
                        res.setText("Fuck you");
                    }
                }
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!AreEmpty())
                {
                    double[] nums = CheckForDouble();
                    if (nums.length != 2) {
                        res.setText(String.format("%.2f", nums[0] - nums[1]));}
                    else
                    {
                        res.setText("Fuck you");
                    }
                }
            }
        });

        multBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!AreEmpty())
                {
                    double[] nums = CheckForDouble();

                    if (nums.length != 2) {
                        res.setText(String.format("%.2f", nums[0] * nums[1]));
                    }
                    else
                    {
                        res.setText("Fuck you");
                    }
                }
            }
        });

        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!AreEmpty())
                {
                    double[] nums = CheckForDouble();
                    if (nums.length != 3) {
                        res.setText(String.format("%.2f", nums[0] / nums[1]));
                    }
                    else
                    {
                        res.setText("Fuck you");
                    }
                }
            }
        });
    }

    public boolean AreEmpty()
    {
        if (!FN.getText().toString().trim().isEmpty()
         && !SN.getText().toString().trim().isEmpty())
        {
            return false;
        }
        return true;
    }

    public double[] CheckForDouble()
    {
        try
        {
            double a = Double.parseDouble(FN.getText().toString());
            double b = Double.parseDouble(SN.getText().toString());

            double[] nums = {a, b};
            return nums;
        } catch (NumberFormatException e)
        {
            double[] nullRes = {0.0, 0.0, 0.0};
            return nullRes;
        }
    }
}