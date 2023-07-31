package com.example.convinence;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class itemCategories extends AppCompatActivity {

    List<Categories> CategoryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_items);

        fillCategoryList();
        RecyclerView recyclerView = findViewById(R.id.recyclerView1);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter<MyAdapter.MyViewHolder> mAdapter = new MyAdapter(itemCategories.this, CategoryList);
        recyclerView.setAdapter(mAdapter);
    }

    private void fillCategoryList() {
        Categories c1= new Categories("Books",R.drawable.bookimage);
        Categories c2= new Categories("Devices",R.drawable.devices2);
        Categories c3= new Categories("Accessories",R.drawable.accesories2);
        Categories c4= new Categories("Bags",R.drawable.bag1);
        Categories c5= new Categories("Discount Website",R.drawable.discount_image);
        CategoryList.addAll(Arrays.asList(new Categories[] {c1,c2,c3,c4,c5}));
    }
}