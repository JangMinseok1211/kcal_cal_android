package com.jhhim99.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class AddFood_fragment extends Fragment {
    private Data data;

    private String foodname;
    private View view;
    private Button addfoodbtn,backbtn;
    private TextView foodname_tv, carb_g_tv ,prot_g_tv,prov_g_tv,kal_tv;
    private int ttal;
    private double tpro;
    private double tcar;
    private double tfat;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_add_food, container, false);

        backbtn = (Button) view.findViewById(R.id.back_btn);
        addfoodbtn = (Button) view.findViewById(R.id.add_food_button);
        foodname_tv =  (TextView) view.findViewById(R.id.total_kcal);

        carb_g_tv  = (TextView) view.findViewById(R.id.carb_g);
        prot_g_tv  = (TextView) view.findViewById(R.id.prot_g);
        prov_g_tv  = (TextView) view.findViewById(R.id.prov_g);
        kal_tv = (TextView) view.findViewById(R.id.kcal);


        if (getArguments() != null)
        {
            foodname = getArguments().getString("foodname"); // overview_fragment 에서 받아온 값 넣기
            searchFoodData(foodname);

            updateTextViews();

        }



        addfoodbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                AddFood_fragment addFood_fragment = new AddFood_fragment();
                Overview_fragment overview_fragment = new  Overview_fragment();
                Search_fragment search_fragment = new Search_fragment();
                transaction.replace(R.id.fragment_main,overview_fragment);
                transaction.commit();


            }
        });
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                AddFood_fragment addFood_fragment = new AddFood_fragment();
                Overview_fragment overview_fragment = new  Overview_fragment();
                Search_fragment search_fragment = new Search_fragment();
                transaction.replace(R.id.fragment_main,search_fragment);
                transaction.commit();


            }
        });
        return view;
    }

    private void searchFoodData(String foodName) {
        // JSON 파일에서 검색하여 정보 추출
        String json = loadJsonFromAsset(requireContext(), "food.json");

        try {
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject foodData = jsonArray.getJSONObject(i);

                String name = foodData.getString("이름");
                if (name.equals(foodName)) {
                    ttal = foodData.getInt("칼로리");
                    tcar = foodData.getDouble("탄수화물");
                    tpro = foodData.getDouble("단백질");
                    tfat = foodData.getDouble("지방");
                    break;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String loadJsonFromAsset(Context context, String fileName) {
        String json = null;
        try {
            InputStream inputStream = context.getAssets().open("jsons/" + fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
    private void updateTextViews() {
        foodname_tv.setText(foodname);
        carb_g_tv.setText(String.format("%.2f", tcar));
        prot_g_tv.setText(String.format("%.2f", tpro));
        prov_g_tv.setText(String.format("%.2f", tfat));
        kal_tv.setText(String.valueOf(ttal));
    }

}