package com.joker.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.Random;

public class DiceRoller extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dice_roller);

        diceRoller();
    }

    public void diceRoller(){
        Button btnRoll = findViewById(R.id.btnRoll);
        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int diceRollResult = rand.nextInt(6) + 1;

                TextView rollResult = findViewById(R.id.rollResult);
                rollResult.setText(Integer.toString(diceRollResult));
                ImageView diceImg = findViewById(R.id.diceImg);

                switch (diceRollResult){
                    case 1:
                        diceImg.setImageResource(R.drawable.dice1);
                        break;
                    case 2:
                        diceImg.setImageResource(R.drawable.dice2);
                        break;
                    case 3:
                        diceImg.setImageResource(R.drawable.dice3);
                        break;
                    case 4:
                        diceImg.setImageResource(R.drawable.dice4);
                        break;
                    case 5:
                        diceImg.setImageResource(R.drawable.dice5);
                        break;
                    case 6:
                        diceImg.setImageResource(R.drawable.dice6);
                        break;

                }
            }
        });
    }
}
