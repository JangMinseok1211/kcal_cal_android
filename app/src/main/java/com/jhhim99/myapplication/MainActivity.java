package com.jhhim99.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText search_food;
    TextView total_kcal;

    private View nav;
    private Overview_fragment overviewFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView overviewRecyclerView = getOverviewRecyclerView();
        // overviewRecyclerView를 사용할 수 있음
        
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        overviewFragment = new Overview_fragment(); // 수정된 부분
        transaction.replace(R.id.fragment_main, overviewFragment);
        transaction.commit();

        getSupportFragmentManager().executePendingTransactions();

    }

    public RecyclerView getOverviewRecyclerView() {
        if (overviewFragment != null) {
            return overviewFragment.getRecyclerView();
        } else {
            return null;
        }
    }

    public void switchToOverviewFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        overviewFragment = new Overview_fragment(); // 수정된 부분
        transaction.replace(R.id.fragment_main, overviewFragment);
        transaction.commit();
    }
}
