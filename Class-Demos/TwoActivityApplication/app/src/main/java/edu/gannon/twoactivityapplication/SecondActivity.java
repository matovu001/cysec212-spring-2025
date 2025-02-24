package edu.gannon.twoactivityapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    private TextView mTextViewSecond;
    private EditText mEditTextReply;
    public static final String EXTRA_REPLY = "edu.gannon.twoactivityapplication.extra.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mTextViewSecond = findViewById(R.id.tv_second);
        mEditTextReply = findViewById(R.id.et_reply);

        Intent secondIntent = getIntent();
        String receivedMessage = secondIntent.getStringExtra(MainActivity.MESSAGE);

        mTextViewSecond.setText(receivedMessage);
    }

    public void sendReply(View view) {

        String reply = mEditTextReply.getText().toString();

        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);

        finish();
    }
}