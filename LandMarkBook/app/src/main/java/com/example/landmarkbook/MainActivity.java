package com.example.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //static Bitmap selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView =findViewById(R.id.listView);
        final ArrayList<String> landMarkNames =new ArrayList<>();
        landMarkNames.add("Pisa");
        landMarkNames.add("Eiffel");
        landMarkNames.add("Kız Kulesi");
        landMarkNames.add("Colesseo");
        landMarkNames.add("London Bridge");

        final ArrayList<String> countryNames=new ArrayList<>();
        countryNames.add("Italy");
        countryNames.add("France");
        countryNames.add("Turkey");
        countryNames.add("Italy");
        countryNames.add("United Kingdom");

        Bitmap pisa=BitmapFactory.decodeResource(getResources(),R.drawable.pisa);
        Bitmap eiffel=BitmapFactory.decodeResource(getResources(),R.drawable.eiffel);
        Bitmap kizKulesi=BitmapFactory.decodeResource(getResources(),R.drawable.kizkulesi);
        Bitmap colosseo=BitmapFactory.decodeResource(getResources(),R.drawable.colosseo);
        Bitmap londonBridge=BitmapFactory.decodeResource(getResources(),R.drawable.londonb);

        final ArrayList<Bitmap> landmarkImages=new ArrayList<>();
        landmarkImages.add(pisa);
        landmarkImages.add(eiffel);
        landmarkImages.add(kizKulesi);
        landmarkImages.add(colosseo);
        landmarkImages.add(londonBridge);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //System.out.println(landMarkNames.get(i));
                //System.out.println(countryNames.get(i));
                Intent intent=new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra("name",landMarkNames.get(i));
                intent.putExtra("country",countryNames.get(i));
                //selectedImage=landmarkImages.get(i);
                Singleton singleton=Singleton.getInstance();
                singleton.setChosenImage(landmarkImages.get(i));

                startActivity(intent);
            }
        });


        ArrayAdapter arrayAdapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,landMarkNames);
        listView.setAdapter(arrayAdapter);
    }
}