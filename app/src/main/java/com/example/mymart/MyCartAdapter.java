package com.example.mymart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;


public class MyCartAdapter extends RecyclerView.Adapter<MyCartAdapter.MyCartHolder> {
     private Context context;
     private ArrayList<ModelCart> cartItems;
    public MyCartAdapter(Context context,ArrayList<ModelCart> cartItems){
        this.context=context;
        this.cartItems=cartItems;
    }

    @NonNull
    @Override
    public MyCartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_cartitem, parent, false);
        return new MyCartHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyCartHolder holder, int position) {
        ModelCart modelCart=cartItems.get(position);
        String  actualPrice, quantity, title, uid, productId,unitCost;
        uid=modelCart.getUid();
        productId=modelCart.getProductId();
        title=modelCart.getTitle();
        quantity=modelCart.getQuantity();
        actualPrice=modelCart.getActualPrice();
        unitCost=modelCart.getUnitCost();
        holder.quantity.setText("[''+quantity+'']");
        holder.itemTitle.setText(title);
        holder.itemPrice.setText(actualPrice);
        holder.eachItemPrice.setText(unitCost);
        holder.itemRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    class MyCartHolder extends RecyclerView.ViewHolder{
         private TextView itemTitle,itemPrice,eachItemPrice,quantity,itemRemove;

        public MyCartHolder(@NonNull View itemView) {
            super(itemView);
            itemTitle=itemView.findViewById(R.id.itemTitle);
            itemPrice=itemView.findViewById(R.id.itemPrice);
            eachItemPrice=itemView.findViewById(R.id.eachItemPrice);
            quantity=itemView.findViewById(R.id.quantity);
            itemRemove=itemView.findViewById(R.id.itemRemove);

        }
    }
}
