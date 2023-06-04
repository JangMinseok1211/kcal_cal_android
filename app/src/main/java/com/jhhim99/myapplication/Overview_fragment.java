package com.jhhim99.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


public class Overview_fragment extends Fragment {

    private TextView totalkcal, totalcarb,totalprot,totalprov,totalcarb_p,totalprot_p,totalprov_p;
    private ImageButton plusbtn;
    private View view;
    private Data data;

    public int total_kcal = 0;
    public int total_carb = 0;
    public int total_prot = 0;
    public int total_fat = 0;

    public double total_carb_p=0;
    public double total_prot_p=0;
    public double total_prov_p=0;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        view = inflater.inflate(R.layout.fragment_overview, container, false);

        plusbtn = (ImageButton) view.findViewById(R.id.plus_button);

        totalkcal = (TextView) view.findViewById(R.id.total_kcal);
        totalcarb = (TextView) view.findViewById(R.id.total_carb_g);
        totalprot = (TextView) view.findViewById(R.id.total_prot_g);
        totalprov = (TextView) view.findViewById(R.id.total_prov_g);

        totalcarb_p = (TextView) view.findViewById(R.id.total_carb_p);
        totalprot_p = (TextView) view.findViewById(R.id.total_prot_p);
        totalprov_p = (TextView) view.findViewById(R.id.total_prov_p);




        if(total_kcal >= 0) {
            totalkcal.setText(String.valueOf(total_kcal));

            totalcarb.setText(String.valueOf(total_carb) + "g");
            totalprot.setText(String.valueOf(total_prot) + "g");
            totalprov.setText(String.valueOf(total_fat) + "g");

            totalcarb_p.setText(String.valueOf(total_carb_p) + "%");
            totalprot_p.setText(String.valueOf(total_prot_p) + "%");
            totalprov_p.setText(String.valueOf(total_prov_p) + "%");
        }
        plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                AddFood_fragment addFood_fragment = new AddFood_fragment();
                Search_fragment search_fragment = new Search_fragment();
                transaction.replace(R.id.fragment_main,search_fragment);
                transaction.commit();


        }
    });

        return view;

    }
}