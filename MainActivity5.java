package com.example.asap2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.api.services.sheets.v4.model.ValueRange;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity5 extends AppCompatActivity{
    TextView t3,t4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        t3=findViewById(R.id.textView7);
        t4=findViewById(R.id.textView8);
        readDataFromGoogleSheet();


    }

    private void readDataFromGoogleSheet() {
        String spreadsheetId = "1CQ3ODCY2v75wJgqo7ZBeFeNkkyF6Puoh56ZzyruEz_c";
        String range = "Sheet1!A:B";
        String apiKey = "AIzaSyC5YyTJhYCc8S2X_tz3BCOa9vss7lnNOkk";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://sheets.googleapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SheetsService sheetsService = retrofit.create(SheetsService.class);

        Call<ValueRange> call = sheetsService.getValues(spreadsheetId, range, apiKey);
        call.enqueue(new Callback<ValueRange>() {
            @Override
            public void onResponse(@NonNull Call<ValueRange> call, @NonNull Response<ValueRange> response) {
                //try {
                System.out.println(response.toString());
                ValueRange values = response.body();
                List<List<Object>> rows = values.getValues();
                System.out.println(rows.get(1));
                String s1="Pilot_1 ";
                String s2="Pilot_2";
                t3.setText(s1+" is "+rows.get(1).get(1).toString());
                t4.setText(s2+" is "+rows.get(2).get(1).toString());

            }

            @Override
            public void onFailure(@NonNull Call<ValueRange> call, @NonNull Throwable t) {
//                Toast.makeText(MainActivity4.this, "Unable to fetch data", Toast.LENGTH_SHORT).show();
                // Handle error
            }
        });

    }

}