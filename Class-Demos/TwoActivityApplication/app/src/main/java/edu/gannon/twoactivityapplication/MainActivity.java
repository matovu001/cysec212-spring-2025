package edu.gannon.twoactivityapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public static final int TEXT_REQUEST = 100;
    public static final String MESSAGE = "edu.gannon.twoactivityapplication.extra.MESSAGE";

    private EditText mEditTextMessage;
    TextView mTextViewMain;

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

        mEditTextMessage = findViewById(R.id.et_main);
        mTextViewMain = findViewById(R.id.tv_main);
    }

    public void launchSecondActivity(View view) {

        String msg = mEditTextMessage.getText().toString();

        mEditTextMessage.setText("");

        Intent startSecondActivity = new Intent(this, SecondActivity.class);
        startSecondActivity.putExtra(MESSAGE, msg);

        //startActivity(startSecondActivity);
        startActivityForResult(startSecondActivity, TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mTextViewMain.setText(reply);
            }
        }
    }
}