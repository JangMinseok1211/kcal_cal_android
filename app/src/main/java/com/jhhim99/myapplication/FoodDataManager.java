package com.jhhim99.myapplication;

import java.util.ArrayList;

public class FoodDataManager {

    private static FoodDataManager instance;
    private ArrayList<FoodItem> foodItemList;

    private FoodDataManager() {
        foodItemList = new ArrayList<>();
    }

    public static FoodDataManager getInstance() {
        if (instance == null) {
            instance = new FoodDataManager();
        }
        return instance;
    }

    public ArrayList<FoodItem> getFoodItemList() {
        return foodItemList;
    }

    public void addFoodItem(FoodItem foodItem) {
        foodItemList.add(foodItem);
    }

}
