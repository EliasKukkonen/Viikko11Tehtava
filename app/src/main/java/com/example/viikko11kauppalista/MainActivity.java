package com.example.viikko11kauppalista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private productStorage storage;
    private RecyclerView recyclerView;

    private ProductListAdapter adapter;

    private ImageView imageCalendar;

    private ImageView imageABC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageCalendar = findViewById(R.id.imgCalendar);
        imageABC = findViewById(R.id.imgABC);
        imageCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(storage.getProducts(), (product1, product2) -> {
                    int id1 = product1.getId();
                    int id2 = product2.getId();
                    return Integer.compare(id1, id2);
                });
                adapter.notifyDataSetChanged();
            }
        });

        imageABC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(storage.getProducts(), (product1, product2) -> product1.getOstos().compareTo(product2.getOstos()));
                adapter.notifyDataSetChanged();
            }
        });





        storage = productStorage.getInstance();


        recyclerView = findViewById(R.id.rvProductList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ProductListAdapter(storage.getProducts(), getApplicationContext());
        recyclerView.setAdapter(adapter);


    }

    @Override
    protected  void onResume() {
        super.onResume();

            adapter.setProducts(storage.getProducts());
            adapter.notifyDataSetChanged();
        }





    public void switchToAddToShopList(View view){
        Intent intent = new Intent(this, AddToShop.class);
        startActivity(intent);
    }




}