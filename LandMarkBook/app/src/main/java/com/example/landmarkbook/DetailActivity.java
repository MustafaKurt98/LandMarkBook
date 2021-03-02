package com.example.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;



public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ImageView imageView=findViewById(R.id.imageView);
        TextView landmarkText=findViewById(R.id.lanmarkText);
        TextView countryText=findViewById(R.id.countryText);

        Intent intent=getIntent();
       String landmarkName= intent.getStringExtra("name");
       String countryName=intent.getStringExtra("country");
       landmarkText.setText(landmarkName);
       countryText.setText(countryName);
       Singleton singleton=Singleton.getInstance();
       imageView.setImageBitmap(singleton.getChosenImage());

       //imageView.setImageBitmap(selectedImage);

    }
}