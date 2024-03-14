package com.example.asap2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner sp;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        sp=findViewById(R.id.spinner);
        t1=findViewById(R.id.textView2);
        ArrayAdapter ad=ArrayAdapter.createFromResource(this,R.array.spin, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        sp.setAdapter(ad);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String s1=parent.getItemAtPosition(position).toString();
                if (s1.equals("Student")){
                    Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(intent);
                }
                if (s1.equals("Faculty")) {
                    Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(intent);
                }

            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "Nothing Selected", Toast.LENGTH_SHORT).show();

            }
        });




    }
}