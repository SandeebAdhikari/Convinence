package com.example.convinence;

public class Items {
    private int id;
    private String name;
    private String price;
    private int itemsImage;

    public Items(int id, String name, String price, int itemsImage) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.itemsImage = itemsImage;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", itemsImage=" + itemsImage +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getItemsImage() {
        return itemsImage;
    }

    public void setItemsImage(int itemsImage) {
        this.itemsImage = itemsImage;
    }
}
