package com.example.convinence;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class CategoriesDiscount extends AppCompatActivity {
    private Menu mMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_discount);
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
    public void discountClick(View view){
        Uri webpage = Uri.parse("https://www.discountschoolsupply.com/");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }
}