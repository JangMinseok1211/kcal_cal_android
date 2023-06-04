package com.jhhim99.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class Search_fragment extends Fragment {


    private Button search_button;
    private EditText search_food;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_search, container, false);
        search_button = (Button) view.findViewById(R.id.search_button);
        search_food = (EditText)view.findViewById(R.id.search_food);
        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("foodname",search_food.getText().toString());
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                AddFood_fragment addFood_fragment = new AddFood_fragment();
                Overview_fragment overview_fragment = new  Overview_fragment();
                Search_fragment search_fragment = new Search_fragment();

                addFood_fragment.setArguments(bundle); //appFood_fragment 로 보냄

                transaction.replace(R.id.fragment_main,addFood_fragment);
                transaction.commit();


            }
        });

        return view;
    }
}