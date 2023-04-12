package com.example.viikko11kauppalista;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    TextView product, memory;

    ImageView removeImage, editImage;

    EditText editName;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        product = itemView.findViewById(R.id.txtOstos);
        memory = itemView.findViewById(R.id.txtMuisti);

        removeImage = itemView.findViewById(R.id.imgRemove);
        editImage = itemView.findViewById(R.id.imgEdit);
        editName = itemView.findViewById(R.id.editTexttMuisti);

    }
}
