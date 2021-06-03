package com.example.nasa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import okhttp3.Request;

public class MainActivity extends AppCompatActivity {

    ImageView iv;
    ListView list;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = findViewById(R.id.image);
        list = findViewById(R.id.list);
        txtView = findViewById(R.id.txt);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = df.format(c.getTime());
        txtView.setText("Current Date: "+formattedDate);
    }

    public void displayResult(String text) {
        Log.d("mytag", text);
    }

    public void onClick(View v) {
        TextView et = findViewById(R.id.txt);
        String search_date = et.getText().toString();

        Request req = new Request(search_date);
        NasaAPITask task = new NasaAPITask(this);
        task.execute(req);
    }
}