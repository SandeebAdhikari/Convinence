package com.example.convinence;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoriesDevices extends AppCompatActivity {
    List<Items> itemsList = new ArrayList<Items>();
    private Menu mMenu;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_items);

        fillItemsList();
        RecyclerView recyclerView = findViewById(R.id.recyclerView1);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> mAdapter = new RecycleViewAdapter(itemsList, CategoriesDevices.this);
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_Book){
            Intent intent = new Intent(this, ListOfItems.class);
            startActivity(intent);
            return true;
        }
        else if (item.getItemId() == R.id.action_Accessories){
            Intent intent1 = new Intent(this, CategoriesAccessories.class);
            startActivity(intent1);
            return true;
        }
        else if (item.getItemId() == R.id.action_Bags){
            Intent intent2 = new Intent(this, CategoriesBags.class);
            startActivity(intent2);
            return true;
        }
        else if (item.getItemId() == R.id.action_Devices){
            Intent intent3 = new Intent(this, CategoriesDevices.class);
            startActivity(intent3);
            return true;
        }
        else if (item.getItemId() == R.id.action_Discount){
            Intent intent4 = new Intent(this, CategoriesDiscount.class);
            startActivity(intent4);
            return true;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        mMenu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_one){
            Intent intent = new Intent(this, ListOfItems.class);
            startActivity(intent);
            return true;
        }
        else if (item.getItemId() == R.id.action_two){
            Intent intent1 = new Intent(this, CategoriesAccessories.class);
            startActivity(intent1);
            return true;
        }
        else if (item.getItemId() == R.id.action_three){
            Intent intent2 = new Intent(this, CategoriesBags.class);
            startActivity(intent2);
            return true;
        }
        else if (item.getItemId() == R.id.action_four){
            Intent intent3 = new Intent(this, CategoriesDevices.class);
            startActivity(intent3);
            return true;
        }
        else if (item.getItemId() == R.id.action_five){
            Intent intent4 = new Intent(this, CategoriesDiscount.class);
            startActivity(intent4);
            return true;
        }
        else if (item.getItemId() == R.id.action_cart){
            Intent intent5 = new Intent(this, cartActivity.class);
            startActivity(intent5);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void fillItemsList() {
        Items i0 = new Items(1, "Monitor", "$34.99",R.drawable.monitor);
        Items i1 = new Items(2, "Keyboard", "$44.99",R.drawable.keyboard);
        Items i2 = new Items(3, "Headset", "$49.99",R.drawable.headset);
        Items i3 = new Items(4, "CPU", "$34.99",R.drawable.cpu);
        Items i4 = new Items(5, "Printer", "$64.99",R.drawable.printer);
        Items i5 = new Items(6, "Projector", "$29.99",R.drawable.projector);
        Items i6 = new Items(7, "Scanner", "$38.99",R.drawable.scanner);
        Items i7 = new Items(8, "Mouse", "$22.99",R.drawable.mouse);
        Items i8 = new Items(9, "Web Camera", "$31.99",R.drawable.webcamera);
        Items i9 = new Items(10, "Calculator", "$69.99",R.drawable.calculator);
        itemsList.addAll(Arrays.asList(new Items[] {i0,i1,i2,i3,i4,i5,i6,i7,i8,i9}));
    }
}