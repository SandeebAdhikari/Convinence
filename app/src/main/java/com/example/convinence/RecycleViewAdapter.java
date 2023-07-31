package com.example.convinence;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    List<Items> itemsList;
    private Context context;
    public static final String Name = "com.example.convinence.name";
    public static final String Price = "com.example.convinence.price";
    public static final String Image = "com.example.convinence.image";


    public RecycleViewAdapter(List<Items> itemsList, Context context) {
        this.itemsList = itemsList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.recyclerview_itemlist_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.itemName.setText(itemsList.get(position).getName());
        holder.itemPrice.setText(String.valueOf(itemsList.get(position).getPrice()));
        Glide.with(this.context).load(itemsList.get(position).getItemsImage()).into(holder.itemImage);

    }
    @Override
    public int getItemCount() {
        return itemsList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView itemImage;
        TextView itemName;
        TextView itemPrice;
        ConstraintLayout constraintLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
            itemImage = itemView.findViewById(R.id.ItemImage);
            itemName = itemView.findViewById(R.id.itemName);
            itemPrice = itemView.findViewById(R.id.itemPrice);
            constraintLayout= itemView.findViewById(R.id.cart_Row_Items);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), DetailActivity.class);

            intent.putExtra("Name",itemsList.get(getAdapterPosition()).getName());
            intent.putExtra("Price",String.valueOf(itemsList.get(getAdapterPosition()).getPrice()));
            intent.putExtra("Image", itemsList.get(getAdapterPosition()).getItemsImage());
            view.getContext().startActivity(intent);
        }
    }
}
