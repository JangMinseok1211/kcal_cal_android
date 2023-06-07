package com.jhhim99.myapplication;

public class FoodItem {
    private String foodName;
    private int calorie;
    private double carb;
    private double protein;
    private double fat;

    public FoodItem(String foodName, int calorie, double carb, double protein, double fat) {
        this.foodName = foodName;
        this.calorie = calorie;
        this.carb = carb;
        this.protein = protein;
        this.fat = fat;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getCalorie() {
        return calorie;
    }

    public double getCarb() {
        return carb;
    }

    public double getProtein() {
        return protein;
    }

    public double getFat() {
        return fat;
    }


}
