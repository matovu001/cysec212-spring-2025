package edu.gannon.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText mEditTextWebsite;
    Button mButtonOpenWebsite;
    EditText mEditTextLocation;
    Button mButtonOpenLocation;
    EditText mEditTextShare;
    Button mButtonShare;
    private static final String TAG =  MainActivity.class.getSimpleName();

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

        mEditTextShare = findViewById(R.id.et_sharetext);
        mButtonShare = findViewById(R.id.btn_sharetext);
        mEditTextWebsite = findViewById(R.id.et_website);
        mButtonOpenWebsite = findViewById(R.id.btn_website);

        mEditTextLocation = findViewById(R.id.et_location);
        mButtonOpenLocation = findViewById(R.id.btn_openlocation);

    }

    public void openWebsite(View view) {
        Log.i(TAG, "Open Website button was clicked");

        String websiteUrl = mEditTextWebsite.getText().toString();
        Log.i(TAG, "Opening website: " + websiteUrl );

        Uri webpage = Uri.parse(websiteUrl);
        Intent websiteIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(websiteIntent);
    }

    public void openLocation(View view) {

        String location = mEditTextLocation.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + location);

        Intent locationIntent = new Intent(Intent.ACTION_VIEW, addressUri);
        startActivity(locationIntent);
    }

    public void shareText(View view) {

        String userText = mEditTextShare.getText().toString();
        String mimeType = "text/plain";

        ShareCompat.IntentBuilder.from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(userText)
                .startChooser();

    }
}