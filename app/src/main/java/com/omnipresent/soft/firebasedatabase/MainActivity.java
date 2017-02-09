package com.omnipresent.soft.firebasedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    TextView MyMessage;
    Button ReadButton, WriteButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyMessage = (TextView) findViewById(R.id.message);
        ReadButton = (Button) findViewById(R.id.btn_read);
        WriteButton = (Button) findViewById(R.id.btn_write);

        ReadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyMessage.setText("I am reading from firebase....");
            }
        });

        WriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msgtxt = MyMessage.getText().toString();
                MyMessage.setText("I am writing '"+msgtxt+"' to firebase..");
                // Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("message");
                myRef.setValue(msgtxt);
            }
        });
    }
}
