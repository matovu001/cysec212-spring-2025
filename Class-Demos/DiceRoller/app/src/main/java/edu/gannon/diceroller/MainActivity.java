package edu.gannon.diceroller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnRoll;
    private TextView textViewRoll;
    private ImageView imageViewRoll;
    private int rollResult = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnRoll = findViewById(R.id.btn_rolldice);
        textViewRoll = findViewById(R.id.tx_dice);
        imageViewRoll = findViewById(R.id.iv_dice);

    }

    public void rollDice(View view) {

        rollResult = new Random().nextInt(6) + 1;

        textViewRoll.setText(Integer.toString(rollResult));

        switch (rollResult) {
            case 1:
                imageViewRoll.setImageResource(R.drawable.dice_1);
                break;
            case 2:
                imageViewRoll.setImageResource(R.drawable.dice_2);
                break;
            case 3:
                imageViewRoll.setImageResource(R.drawable.dice_3);
                break;
            case 4:
                imageViewRoll.setImageResource(R.drawable.dice_4);
                break;
            case 5:
                imageViewRoll.setImageResource(R.drawable.dice_5);
                break;
            case 6:
                imageViewRoll.setImageResource(R.drawable.dice_6);
                break;
            default:
                imageViewRoll.setImageResource(R.drawable.empty_dice);
        }
    }
}