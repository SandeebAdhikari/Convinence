package com.example.convinence;

public class Cart {
    String cartItemName;
    String cartItemQuantity;
    int cartItemPrice;
    //int cartItemImage;

    public Cart(String cartItemName, String cartItemQuantity, int cartItemPrice) {
        this.cartItemName = cartItemName;
        this.cartItemQuantity = cartItemQuantity;
        this.cartItemPrice = cartItemPrice;
      //  this.cartItemImage = cartItemImage;
    }

    public String getCartItemName() {
        return cartItemName;
    }

    public void setCartItemName(String cartItemName) {
        this.cartItemName = cartItemName;
    }

    public String getCartItemQuantity() {
        return cartItemQuantity;
    }

    public void setCartItemQuantity(String cartItemQuantity) {
        this.cartItemQuantity = cartItemQuantity;
    }

    public int getCartItemPrice() {
        return cartItemPrice;
    }

    public void setCartItemPrice(int cartItemPrice) {
        this.cartItemPrice = cartItemPrice;
    }
    /*
    public int getCartItemImage() {
        return cartItemImage;
    }

    public void setCartItemImage(int cartItemImage) {
        this.cartItemImage = cartItemImage;
    } */
}