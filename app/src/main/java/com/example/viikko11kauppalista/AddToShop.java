package com.example.viikko11kauppalista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddToShop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_shop);
    }

    public void addProduct(View view){
        EditText product = findViewById(R.id.editTextLisaaOstos);
        String sProduct = product.getText().toString();
        EditText memory = findViewById(R.id.editTextLisaaMuistiin);
        String muisti = memory.getText().toString();



        productStorage.getInstance().addProductToList(new Product(sProduct, muisti));


    }


}