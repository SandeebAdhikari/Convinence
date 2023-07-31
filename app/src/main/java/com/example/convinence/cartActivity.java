package com.example.convinence;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class cartActivity extends AppCompatActivity {
    List<Cart> cartList;
    private Menu mMenu;
    private TextView taxView;
    private TextView cartSubTotalView;
    private TextView cartTotalView;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private int tax  ;
    private int subTotal;
    private int cartTotal;
    private String name;
    private String noOfItems;
    private int cartItemPrice;
    //private int image;
    private int n;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("NAME");
        noOfItems = bundle.getString("NO_OF_ITEM");
        cartItemPrice = bundle.getInt("CART_ITEM_PRICE",0);
        //image = bundle.getInt("IMAGE",0);

        cartList = new ArrayList<Cart>();
        Cart cartItem = new Cart(name, noOfItems, cartItemPrice);
        cartList.add(cartItem);
        mAdapter = new cartAdapter(cartList, this);
        recyclerView.setAdapter(mAdapter);

        totalCalculation();

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
        return super.onOptionsItemSelected(item);
    }

    private void totalCalculation(){
        for(int i = 0; i< n ; i++){
          Cart cart =cartList.get(i);
          subTotal += cart.getCartItemPrice();
        }
        tax = subTotal * (7/100);
        cartTotal = subTotal + tax;

        taxView = findViewById(R.id.taxView);
        cartSubTotalView = findViewById(R.id.cartSubTotalView);
        cartTotalView = findViewById(R.id.cartTotalView);

        taxView.setText("with TAX: " + tax);
        cartSubTotalView.setText("Sub Total: " + subTotal);
        cartTotalView.setText("Total: " + cartTotal);
    }
}