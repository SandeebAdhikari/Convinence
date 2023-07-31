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

import com.google.android.material.card.MaterialCardView;


import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    List<Categories>  CategoryList;
    private Context context;

    public MyAdapter(Context context, List<Categories> CategoryList){
       this.CategoryList = CategoryList;
       this.context = context;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.image_cardview_category, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.categoryName.setText(CategoryList.get(position).getCategoriesName());
        holder.categoryImage.setImageResource(CategoryList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return CategoryList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView categoryImage;
        TextView categoryName;
        ConstraintLayout constraintLayout;
        MaterialCardView categoryCardView;
        public MyViewHolder( View itemView) {
            super(itemView);
            context = itemView.getContext();
            categoryCardView = itemView.findViewById(R.id.materialCardView);
            categoryImage = itemView.findViewById(R.id.view_categories);
            categoryName = itemView.findViewById(R.id.image_Text);
            constraintLayout = itemView.findViewById(R.id.oneLineItemLayout);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            final Intent intent;
            switch (getAdapterPosition()){
                case 0:
                    intent = new Intent(context, ListOfItems.class);
                    break;
                case 1:
                    intent = new Intent(context, CategoriesDevices.class);
                    break;
                case 2:
                    intent = new Intent(context, CategoriesAccessories.class);
                    break;
                case 3:
                    intent = new Intent(context, CategoriesBags.class);
                    break;
                default:
                    intent = new Intent(context, CategoriesDiscount.class);
                    break;
            }
            context.startActivity(intent);
        }
    }
}
