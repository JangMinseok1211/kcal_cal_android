package com.jhhim99.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class AddFood_fragment extends Fragment {


    private View view;
    private Button addfoodbtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_add_food, container, false);


        addfoodbtn = (Button) view.findViewById(R.id.add_food_button);
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
        return view;
    }
}