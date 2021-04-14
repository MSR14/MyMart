package com.example.mymart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductsActivity extends AppCompatActivity {
    ArrayList productNames = new ArrayList<>(Arrays.asList("Coconut Oil", "Coffee", "Onion", "Perk"));
    ArrayList productDescription=new ArrayList<>(Arrays.asList("co","cof","oni","perk"));
    ArrayList productImages = new ArrayList<>(Arrays.asList(R.drawable.coconut, R.drawable.coffee_brand, R.drawable.onion_vegetable, R.drawable.perk_choco));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        // call the constructor of CustomAdapter to send the reference and data to Adapter
        MyProductAdapter customAdapter = new MyProductAdapter(ProductsActivity.this, productNames,productImages,productDescription);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
    }
}