package com.jhhim99.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Overview_fragment extends Fragment {

    private TextView totalkcal, totalcarb, totalprot, totalprov, totalcarb_p, totalprot_p, totalprov_p;
    private ImageButton plusbtn;
    private View view;
    private Data data;

    private RecyclerView foodOverviewRecyclerView;
    private FoodOverviewAdapter foodOverviewAdapter;
    private List<FoodItem> foodItemList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_overview, container, false);



        // foodItemList 초기화
        foodItemList = new ArrayList<>();

        foodOverviewRecyclerView = view.findViewById(R.id.recycler_view_food_overview);

        // LayoutManager 설정 (LinearLayoutManager 또는 다른 원하는 레이아웃 매니저를 사용할 수 있습니다)
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        foodOverviewRecyclerView.setLayoutManager(layoutManager);

        // 어댑터 생성 및 설정
        foodOverviewAdapter = new FoodOverviewAdapter(foodItemList); // foodItemList는 FoodItem 객체의 목록입니다.
        foodOverviewRecyclerView.setAdapter(foodOverviewAdapter);

        plusbtn = view.findViewById(R.id.plus_button);
        totalkcal = view.findViewById(R.id.total_kcal);
        totalcarb = view.findViewById(R.id.total_carb_g);
        totalprot = view.findViewById(R.id.total_prot_g);
        totalprov = view.findViewById(R.id.total_prov_g);
        totalcarb_p = view.findViewById(R.id.total_carb_p);
        totalprot_p = view.findViewById(R.id.total_prot_p);
        totalprov_p = view.findViewById(R.id.total_prov_p);

        updateTextViews();

        plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                AddFood_fragment addFood_fragment = new AddFood_fragment();
                Search_fragment search_fragment = new Search_fragment();
                transaction.replace(R.id.fragment_main, search_fragment);
                transaction.commit();


            }
        });

        return view;
    }

    // 처음 텍스트뷰 초기화
    private void updateTextViews() {
        data = Data.getInstance();

        totalkcal.setText(String.valueOf(data.getTotal_Kal()));
        totalcarb.setText(String.valueOf(data.getTotal_carb()) + "g");
        totalprot.setText(String.valueOf(data.getTotal_prot()) + "g");
        totalprov.setText(String.valueOf(data.getTotal_fat()) + "g");

        double carbPercentage = (data.getTotal_carb() / data.getTotal_Kal()) * 100;
        double protPercentage = (data.getTotal_prot() / data.getTotal_Kal()) * 100;
        double fatPercentage = (data.getTotal_fat() / data.getTotal_Kal()) * 100;

        // 값이 없다면 0으로 표시
        totalcarb_p.setText(Double.isNaN(carbPercentage) ? "0%" : String.valueOf(carbPercentage) + "%");
        totalprot_p.setText(Double.isNaN(protPercentage) ? "0%" : String.valueOf(protPercentage) + "%");
        totalprov_p.setText(Double.isNaN(fatPercentage) ? "0%" : String.valueOf(fatPercentage) + "%");
    }
    public RecyclerView getRecyclerView() {
        return foodOverviewRecyclerView;
    }
}
