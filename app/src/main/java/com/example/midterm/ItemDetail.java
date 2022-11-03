package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ItemDetail extends AppCompatActivity {

    ImageView detailImageView;
    TextView detailTitle,detailPrice,detailRate,detailDescription,detailTrailer;

    String dataTitle,dataPrice,dataRate,dataDescription,dataTrailer;
    int dataImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        detailImageView = findViewById(R.id.mv_image_detail);
        detailTitle = findViewById(R.id.movie_name_detail);
        detailPrice = findViewById(R.id.movie_price_detail);
        detailRate = findViewById(R.id.movie_rate_detail);
        detailDescription = findViewById(R.id.movie_description_detail);


        getData();
        setData();
    }

    private void getData(){
        if (getIntent().hasExtra("title") && getIntent().hasExtra("rate") && getIntent().hasExtra("price")
                && getIntent().hasExtra("description") && getIntent().hasExtra("image") && getIntent().hasExtra("trailer")){
            dataTitle = getIntent().getStringExtra("title");
            dataRate = getIntent().getStringExtra("rate");
            dataPrice = getIntent().getStringExtra("price");
            dataDescription = getIntent().getStringExtra("description");
            dataImage = getIntent().getIntExtra("image",1);
            dataTrailer = getIntent().getStringExtra("trailer");
        }
        else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        detailTitle.setText(dataTitle);
        detailRate.setText(dataRate);
        detailPrice.setText(dataPrice);
        detailDescription.setText(dataDescription);
        detailImageView.setImageResource(dataImage);
    }

    public void seeTrailer(View view) {
        Intent intent = new Intent(this, MoiveTrailer.class);
        intent.putExtra("trailerURL",dataTrailer);
        startActivity(intent);
    }
}