package com.example.convinence;

public class Categories {
    private String categoriesName;
    private int image;

    public Categories(String categoriesName, int image) {
        this.categoriesName = categoriesName;
        this.image = image;
    }

    public String getCategoriesName() {
        return categoriesName;
    }

    public void setCategoriesName(String categoriesName) {
        this.categoriesName = categoriesName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

