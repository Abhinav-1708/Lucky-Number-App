package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    TextView welcomeTxt, luckyNumberTxt;
    Button shareBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Initialize UI elements
        welcomeTxt = findViewById(R.id.textView2);
        luckyNumberTxt = findViewById(R.id.textView3);
        shareBtn = findViewById(R.id.shareButton);

        // Get data from the previous activity
        Intent i = getIntent();
        String userName = i.getStringExtra("name");

        // Generate and display a random number
        int rand = generateRandomNumber();
        luckyNumberTxt.setText("" + rand);

        // Set up a click listener for the share button
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the shareData method to share information
                shareData(userName, rand);
            }
        });
    }

    // Method to generate a random number
    public int generateRandomNumber() {
        Random random = new Random();
        int UPPER_LIMIT = 1000;
        return random.nextInt(UPPER_LIMIT);
    }

    // Method to share data using an implicit intent
    public void shareData(String username, int rand) {
        // Create an implicit intent for sharing
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, username + " got lucky today");
        i.putExtra(Intent.EXTRA_TEXT, "His lucky number is " + rand);

        // Start an activity to choose a platform for sharing
        startActivity(Intent.createChooser(i, "Choose a platform"));
    }
}
