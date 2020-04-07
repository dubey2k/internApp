package com.internship.internproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class RateScreen extends AppCompatActivity {

    private RatingBar rating;
    private TextView Heading;
    private Button Done;
    int MIN = 0, MAX = 0;
    int range = 0;
    float rated = 0.0f;

    boolean ratingChanged = false;

    private ratingModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_screen);

        rating = findViewById(R.id.ratingBar);
        Heading = findViewById(R.id.rangehead);
        Done = findViewById(R.id.rateDone);

        MIN = getIntent().getIntExtra("minimum", 0);
        MAX = getIntent().getIntExtra("maximum", 0);

        Heading.setText("Range < " + MIN + " - " + MAX + " >");

        range = MAX - MIN;

        rating.setNumStars(range);
        rating.setStepSize(0.1f);
        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                ratingChanged = true;
            }
        });

        Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ratingChanged) {
                    rated = MIN + rating.getRating();
                    DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
                    String date = df.format(Calendar.getInstance().getTime());
                    model = new ratingModel(MIN, MAX, rated, date);

                    MainActivity.historylist.add(model);
                    Toast.makeText(getApplicationContext(), rated + " Rated !!", Toast.LENGTH_SHORT).show();
                    finish();
                } else
                    Toast.makeText(RateScreen.this, "Please Rate!!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
