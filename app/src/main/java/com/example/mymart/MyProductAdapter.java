package com.example.mymart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MyProductAdapter extends RecyclerView.Adapter<MyProductAdapter.MyProductHolder> {
    @NonNull
    ArrayList productNames;
    ArrayList productImages;
    ArrayList productDescription;
    Context context;
    public MyProductAdapter(Context context, ArrayList productNames, ArrayList productImages, ArrayList productDescription) {
        this.context = context;
        this.productNames = productNames;
        this.productImages = productImages;
        this.productDescription =productDescription;
    }
    @NotNull
    @Override
    public MyProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.myrow, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyProductHolder vh = new MyProductHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyProductHolder holder, int position) {
        // set the data in items
        holder.name.setText(productNames.get(position).toString());
        holder.description.setText(productDescription.get(position).toString());
        holder.image.setImageResource((Integer) productImages.get(position));

    }

    @Override
    public int getItemCount() {
        return productNames.size();
    }

    public static class MyProductHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView description;
        ImageView image;
        public MyProductHolder(@NonNull View itemView) {
            super(itemView);
            // get the reference of item view's
            name = itemView.findViewById(R.id.name);
            description=itemView.findViewById(R.id.description);
            image = itemView.findViewById(R.id.image);

            }

        }
    }
