package com.jhhim99.myapplication;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodOverviewAdapter extends RecyclerView.Adapter<FoodOverviewAdapter.ViewHolder> {

    private List<FoodItem> foodItemList = new ArrayList<>();
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
        holder.bind(foodItem,this);
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
        ImageButton delete_btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            delete_btn = itemView.findViewById(R.id.btn_delete_item_overview);
            nameTextView = itemView.findViewById(R.id.tv_item_overview_name);
            kcalTextView = itemView.findViewById(R.id.tv_item_overview_kcal);
            carbsTextView = itemView.findViewById(R.id.tv_item_overview_carbs);
            proteinsTextView = itemView.findViewById(R.id.tv_item_overview_proteins);
            fatsTextView = itemView.findViewById(R.id.tv_item_overview_fats);
        }

        public void bind(FoodItem foodItem,FoodOverviewAdapter adapter) {

            nameTextView.setText(foodItem.getFoodName());
            kcalTextView.setText(String.valueOf(foodItem.getCalorie()) + " kcal");
            carbsTextView.setText(String.valueOf(foodItem.getCarb()) + " g");
            proteinsTextView.setText(String.valueOf(foodItem.getProtein()) + " g");
            fatsTextView.setText(String.valueOf(foodItem.getFat()) + " g");

            delete_btn.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {

                    int position = getAdapterPosition();
                    adapter.removeFoodItem(position);

                    MainActivity mainActivity = (MainActivity) v.getContext();
                    if (mainActivity != null) {
                        Overview_fragment overviewFragment = mainActivity.getOverviewFragment();
                        if (overviewFragment != null) {
                            overviewFragment.updateTextViews();
                        }
                    }
                }
            });
        }
    }

    public void addFoodItem(FoodItem foodItem) {
        Log.e("",foodItem.getFoodName());
        foodItemList.add(foodItem);

        notifyItemInserted(foodItemList.size()-1);
        notifyDataSetChanged();
    }
    public void removeFoodItem(int position) {
        FoodItem removedFoodItem = foodItemList.get(position);
        foodItemList.remove(position);
        Overview_fragment ov = new Overview_fragment();

        // 데이터 인스턴스에서 삭제된 음식의 값을 빼주도록 수정
        Data data = Data.getInstance();
        data.setTotal_Kal(data.getTotal_Kal() - removedFoodItem.getCalorie());
        data.setTotal_carb(Math.round( (data.getTotal_carb() - removedFoodItem.getCarb())*10)/10.0 );
        data.setTotal_prot(Math.round( (data.getTotal_prot() - removedFoodItem.getProtein())*10)/10.0);
        data.setTotal_fat(Math.round( (data.getTotal_fat() - removedFoodItem.getFat())*10)/10.0);

        notifyItemRemoved(position);
        notifyDataSetChanged();


    }


}
