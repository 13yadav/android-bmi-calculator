package com.joker.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        final EditText heightInput = findViewById(R.id.heightInput);
        final EditText weightInput = findViewById(R.id.weightInput);
        Button btnCalc = findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double height = Double.parseDouble(heightInput.getText().toString());
                double weight = Double.parseDouble(weightInput.getText().toString());
                double bmi = weight / (height*height);
                DecimalFormat df = new DecimalFormat("#.#");
                double bmiTrim = Double.parseDouble(df.format(bmi));
                TextView bmiResult = findViewById(R.id.bmiResult);
                bmiResult.setText(Double.toString(bmiTrim));

                String bmi_Cat;
                if (bmi < 15)
                    bmi_Cat = "Very severely underweight";
                else if (bmi < 16)
                    bmi_Cat = "Severely underweight";
                else if (bmi < 18.5)
                    bmi_Cat = "Underweight";
                else if (bmi < 25)
                    bmi_Cat = "Normal";
                else if (bmi < 30)
                    bmi_Cat = "Overweight";
                else if (bmi < 35)
                    bmi_Cat = "Obese Class 1 -Moderately Obese";
                else if (bmi < 40)
                    bmi_Cat = "Obese Class 2 -Severely Obese";
                else
                    bmi_Cat = "Obese Class 3 -Very Severely Obese";

                TextView bmiCat = findViewById(R.id.bmiCat);
                bmiCat.setText(bmi_Cat);
            }
        });
    }

    public void dcRoller(View view){
        Intent intent = new Intent(this, DiceRoller.class);
        startActivity(intent);
    }
}
