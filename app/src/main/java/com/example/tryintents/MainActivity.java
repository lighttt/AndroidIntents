package com.example.tryintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mNameEntry;
    private Button mDoSomethingCoolButton;
    private Button mGoToImplicit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDoSomethingCoolButton = findViewById(R.id.b_do_something_cool);
        mGoToImplicit = findViewById(R.id.b_gotoImplicit);
        mNameEntry =  findViewById(R.id.et_text_entry);

        mDoSomethingCoolButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textEntered = mNameEntry.getText().toString();
                Context context = MainActivity.this;
                Class destinationActivity = ChildActivity.class;
                Intent startChildActivityIntent = new Intent(context, destinationActivity);
                startChildActivityIntent.putExtra(Intent.EXTRA_TEXT, textEntered);
                startActivity(startChildActivityIntent);
            }
        });

        mGoToImplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = MainActivity.this;
                Class destinationActivity = ImplicitActivity.class;
                Intent startChildActivityIntent = new Intent(context, destinationActivity);
                startActivity(startChildActivityIntent);
            }
        });
    }
}
