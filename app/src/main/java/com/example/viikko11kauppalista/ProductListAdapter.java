package com.example.viikko11kauppalista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductListAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    private Context context;
    private ArrayList<Product> products = new ArrayList<>();

    public ProductListAdapter(ArrayList<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductViewHolder(LayoutInflater.from(context).inflate(R.layout.product_view, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.product.setText(products.get(position).getOstos());
        holder.memory.setText(products.get(position).getMuistiinpanot());
        holder.editName.setText(products.get(position).getMuistiinpanot());

        holder.removeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeProduct2(products.get(holder.getAdapterPosition()));
            }
        });


        holder.editImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();

                if (holder.editName.getVisibility() == View.VISIBLE) {
                    Product product = productStorage.getInstance().getProductById(pos);
                    product.setMuistiinpanot(holder.editName.getText().toString());
                    holder.editName.setVisibility(View.GONE);
                    notifyDataSetChanged();
                } else {
                    holder.editName.setVisibility(View.VISIBLE);
                }
            }
        });


        holder.editImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                if (holder.editName.getVisibility() == view.VISIBLE){
                    Product product = productStorage.getInstance().getProductById(pos);
                    product.setMuistiinpanot(holder.editName.getText().toString());
                    holder.editName.setVisibility(View.GONE);
                    notifyDataSetChanged();
                } else {
                    holder.editName.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    public void removeProduct2(Product product){
        int position = products.indexOf(product);
        if (position != -1){
            products.remove(position);
            notifyItemRemoved(position);
        }
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setProducts(ArrayList<Product> products) {
    }

}
