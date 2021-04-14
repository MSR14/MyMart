package com.example.mymart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    private ArrayList<ModelCart> cartItems;
    // take the data from firebase and store in modelcart object and pass it to adapter class.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cartItems);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        // call the constructor of CustomAdapter to send the reference and data to Adapter
        MyCartAdapter customAdapter = new MyCartAdapter(CartActivity.this, cartItems);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
    }
}