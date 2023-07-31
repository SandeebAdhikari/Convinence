package com.example.convinence;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class DetailActivity extends AppCompatActivity {
    private Menu mMenu;
    private ImageView itemImage1;
    private TextView itemName1;
    private TextView itemPrice1;
    private TextView itemQuantity;
    private TextView TotalPrice;
    private RadioGroup deliveryOptions;
    private String items;
    private String name;
    private String price;
    private int image;
    private Spinner spinner;
    private int itemTotalPrice;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_detail);

         Intent intent = getIntent();
         name = intent.getStringExtra("Name");
         price = intent.getStringExtra("Price");
          image = intent.getIntExtra("Image",0);

         itemName1 = findViewById(R.id.itemName1);
         itemPrice1 = findViewById(R.id.itemPrice1);
         itemImage1 = findViewById(R.id.itemImage1);
         itemQuantity = findViewById(R.id.text_Qty);
         deliveryOptions = findViewById(R.id.radioGroup);
         TotalPrice = findViewById(R.id.TotalPrice);
         itemName1.setText(name);
         itemPrice1.setText(price);
         //itemImage1.setImageResource(image);

         int position = 0;

         spinner = findViewById(R.id.quantity_Spinner);
         ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.itemQuantity, android.R.layout.simple_spinner_dropdown_item);
         adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         spinner.setAdapter(adapter);
         spinner.setSelection(position-1);

         spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                  items = (String) parent.getItemAtPosition(position);
                Toast.makeText(DetailActivity.this,"Number of ITEM: " + items, Toast.LENGTH_LONG).show();
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(DetailActivity.this," SELECT ITEM ", Toast.LENGTH_LONG).show();
            }
        });
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
            Bundle bundle = new Bundle();
            bundle.putString("NAME",name);
            bundle.putString("NO_OF_ITEM", items);
            bundle.putInt("CART_ITEM_PRICE", itemTotalPrice);
            bundle.putInt("IMAGE", image);
            startActivity(intent5);
            startActivity(intent5);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void addToCartClick(View view){
        int noOfItems = Integer.parseInt(items);
        int itemPrice = Integer.parseInt(price);
        int Price = 0;
        int checkID = deliveryOptions.getCheckedRadioButtonId();
        if (checkID ==R.id.radioButton_Curbside){
            Price = itemPrice;
        }else if(checkID == R.id.radioButton_Delivery){
            Price =  itemPrice * 5;
        }
        itemTotalPrice = Price * noOfItems;

        TotalPrice.setText("Total Price: "+ itemTotalPrice);

        Toast.makeText(DetailActivity.this,"TotalPrice" + itemTotalPrice, Toast.LENGTH_LONG).show();
    }

}