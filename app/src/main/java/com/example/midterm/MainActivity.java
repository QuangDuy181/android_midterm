package com.example.midterm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private
    RecyclerView rcv;
    ItemAdapter itemAdapter;
    String titles[],ratings[],prices[],descriptions[],trailers[];
    int mvImages[] = {R.drawable.image_1,R.drawable.image_2,R.drawable.image_3,R.drawable.image_4,
            R.drawable.image_5,R.drawable.image_6,R.drawable.image_7,R.drawable.image_8,R.drawable.image_9,R.drawable.image_10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titles = getResources().getStringArray(R.array.movie_name);
        ratings = getResources().getStringArray(R.array.movie_rating);
        prices = getResources().getStringArray(R.array.movie_price);
        descriptions = getResources().getStringArray(R.array.movie_description);
        trailers = getResources().getStringArray(R.array.movie_url);

        rcv = findViewById(R.id.rcv);
        itemAdapter = new ItemAdapter(this,titles,ratings,prices,descriptions,trailers,mvImages);
        rcv.setAdapter(itemAdapter);
        rcv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_actionview,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        return super.onOptionsItemSelected(item);
    }
}