package com.internship.internproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner min, max;
    private Button rate, history;
    int MIN = 0, MAX = 0;

    public static ArrayList<ratingModel> historylist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        List<Integer> range = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, range);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        min.setAdapter(arrayAdapter);
        max.setAdapter(arrayAdapter);

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (min.getSelectedItem().toString() == null)
                    Toast.makeText(MainActivity.this, "Empty minimum range", Toast.LENGTH_SHORT).show();
                else if (max.getSelectedItem().toString() == null)
                    Toast.makeText(MainActivity.this, "Empty maximum range", Toast.LENGTH_SHORT).show();
                else {
                    MIN = Integer.parseInt(min.getSelectedItem().toString());
                    MAX = Integer.parseInt(max.getSelectedItem().toString());
                    if (MIN < MAX) {
                        Intent intent = new Intent(MainActivity.this, RateScreen.class);
                        intent.putExtra("minimum", MIN);
                        intent.putExtra("maximum", MAX);
                        startActivity(intent);
                    } else
                        Toast.makeText(MainActivity.this, "Range values are invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (historylist.size()==0) {
                    Toast.makeText(getApplicationContext(), "No History yet!!", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(MainActivity.this, History.class));
                }
            }
        });
    }

    public void init() {
        min = findViewById(R.id.spinner);
        max = findViewById(R.id.spinner2);
        rate = findViewById(R.id.rate);
        history = findViewById(R.id.history);
    }
}
