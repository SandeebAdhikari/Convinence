package com.example.convinence;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.lang.invoke.LambdaConversionException;
import java.util.List;

public class cartAdapter extends RecyclerView.Adapter<cartAdapter.MyViewHolder> {
    List<Cart> cartList;
    Context context;

    public cartAdapter(List<Cart> cartList, Context context) {
        this.cartList = cartList;
        this.context = context;
    }

    @NonNull
    @Override
    public cartAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_cart_item_row,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull cartAdapter.MyViewHolder holder, int position) {
        holder.cartItemName.setText(cartList.get(position).getCartItemName());
        holder.cartItemPrice.setText(cartList.get(position).getCartItemPrice());
        holder.cartItemQuantity.setText(cartList.get(position).getCartItemQuantity());
       // holder.cartItemImage.setImageResource(cartList.get(position).getCartItemImage());

    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView cartItemImage;
        TextView cartItemName;
        TextView cartItemPrice;
        TextView cartItemQuantity;
        ConstraintLayout cartItemRow;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //cartItemImage = itemView.findViewById(R.id.cart_ItemImage);
            cartItemName = itemView.findViewById(R.id.cart_itemName);
            cartItemPrice = itemView.findViewById(R.id.cart_ItemPrice);
            cartItemQuantity = itemView.findViewById(R.id.cart_Quantity2);
            cartItemRow = itemView.findViewById(R.id.cart_Row_Items);
        }
    }
}