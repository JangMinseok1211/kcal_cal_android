package com.jhhim99.myapplication;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodOverviewAdapter extends RecyclerView.Adapter<FoodOverviewAdapter.ViewHolder> {

    private List<FoodItem> foodItemList;
    private LayoutInflater inflater;

    public FoodOverviewAdapter(List<FoodItem> foodItemList) {
        this.foodItemList = foodItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }

        View view = inflater.inflate(R.layout.item_food_overview, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FoodItem foodItem = foodItemList.get(position);
        holder.bind(foodItem);
    }

    @Override
    public int getItemCount() {
        return foodItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView;
        TextView kcalTextView;
        TextView carbsTextView;
        TextView proteinsTextView;
        TextView fatsTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.tv_item_overview_name);
            kcalTextView = itemView.findViewById(R.id.tv_item_overview_kcal);
            carbsTextView = itemView.findViewById(R.id.tv_item_overview_carbs);
            proteinsTextView = itemView.findViewById(R.id.tv_item_overview_proteins);
            fatsTextView = itemView.findViewById(R.id.tv_item_overview_fats);
        }

        public void bind(FoodItem foodItem) {
            nameTextView.setText(foodItem.getFoodName());
            kcalTextView.setText(String.valueOf(foodItem.getCalorie()) + " kcal");
            carbsTextView.setText(String.valueOf(foodItem.getCarb()) + " g");
            proteinsTextView.setText(String.valueOf(foodItem.getProtein()) + " g");
            fatsTextView.setText(String.valueOf(foodItem.getFat()) + " g");
        }
    }

    public void addFoodItem(FoodItem foodItem) {
        foodItemList.add(foodItem);
        notifyItemInserted(foodItemList.size() - 1);
    }

}
