package com.example.patientmangement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Particular_Patient extends AppCompatActivity {


    Button dbutton;
    com.example.patientmangement.mDatabaseHelper db;
    String s;
    ArrayList<visit_details>  list= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particular__patient);
        dbutton = (Button) findViewById(R.id.button5);
        Intent intent = getIntent();
        s = intent.getStringExtra("Name oF patient");
        final TextView textView = (TextView) findViewById(R.id.textView6);
        textView.setText("  Patient: " + s);
    }

    public void deleteit(View view){
        db= new com.example.patientmangement.mDatabaseHelper(getApplicationContext());
        int i=db.delete(s);
        if(i>0)
        {
            Toast.makeText(getApplicationContext(), "This item deleted from database", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Particular_Patient.this, OptionsActivity.class);
            startActivity(intent);
        }
    }

    public void toAddVisit(View view){
        Intent iiii=new Intent(getApplicationContext(),addVisit.class);
        iiii.putExtra("name", s);
        startActivity(iiii);
    }
}