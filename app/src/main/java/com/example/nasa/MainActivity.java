package com.example.nasa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Picasso p;

    ImageView iv;
    TextView txtView, title, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p  = new Picasso.Builder(getApplicationContext()).build();

        iv = findViewById(R.id.picture);
        txtView = findViewById(R.id.txt);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = df.format(c.getTime());
        txtView.setText("Current Date: "+formattedDate);
    }

    public void displayResult(Response response) {
        p.load(response.hdurl).into(iv);
        title.setText(response.title);
        description.setText(response.explanation);
    }

    public void onClick(View v) {
        TextView et = findViewById(R.id.txt);
        String search_date = et.getText().toString();

        Request req = new Request(search_date);
        NasaAPITask task = new NasaAPITask(this);
        task.execute(req);
    }
}