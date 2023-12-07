package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btn;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        editText = findViewById(R.id.edit_text);
        txt = findViewById(R.id.textView);
        btn = findViewById(R.id.submitBtn);

        // Set up a click listener for the submit button
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the entered username from the EditText
                String userName = editText.getText().toString();

                // Create an explicit intent to start the SecondActivity
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

                // Pass the username to the SecondActivity using an intent extra
                intent.putExtra("name", userName);

                // Start the SecondActivity
                startActivity(intent);
            }
        });
    }
}
