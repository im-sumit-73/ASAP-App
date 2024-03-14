package com.example.asap2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView t2;
    Button b3;
    RadioGroup rg;
    RadioButton rd1,rd2,rd3,rd4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t2=findViewById(R.id.textView);
        rg=findViewById(R.id.radioGroup);
        rd1=findViewById(R.id.radioButton);
        rd2=findViewById(R.id.radioButton2);
        rd3=findViewById(R.id.radioButton4);
        rd4=findViewById(R.id.radioButton5);
        b3=findViewById(R.id.button5);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (rd1.isChecked())
                {
                    Intent intent=new Intent(MainActivity2.this,MainActivity5.class);
                    startActivity(intent);
                }
                if (rd2.isChecked())
                {
                    Intent intent=new Intent(MainActivity2.this,MainActivity5.class);
                    startActivity(intent);
                }
                if (rd3.isChecked())
                {
                    Intent intent=new Intent(MainActivity2.this,MainActivity5.class);
                    startActivity(intent);
                }
                if (rd4.isChecked())
                {
                    Intent intent=new Intent(MainActivity2.this,MainActivity5.class);
                    startActivity(intent);
                }

            }
        });
    }
}