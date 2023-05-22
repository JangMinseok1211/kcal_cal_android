package com.jhhim99.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class Overview_fragment extends Fragment {


    private ImageButton plusbtn;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_overview, container, false);

        plusbtn = (ImageButton) view.findViewById(R.id.plus_button);
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