package com.jhhim99.myapplication;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;


import android.view.MenuItem;


import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {
    //HomeFragment homeFrament;
    //ManageFragment manageFragment;
   //UserFragment userFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Overview_fragment overview_fragment = new Overview_fragment();
        //homeFrament = new HomeFragment();
        //manageFragment = new ManageFragment();
        //userFragment = new UserFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_main, overview_fragment).commit();

        NavigationBarView navigationBarView = findViewById(R.id.bottom_navigationview);
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    /*case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_main, homeFrament).commit();
                        return true;*/
                    case R.id.fork:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_main, overview_fragment).commit();
                        return true;
                    /*case R.id.user:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_main, userFragment).commit();
                        return true;*/
                }
                return false;
            }
        });


    }

    // 메뉴 리소스 XML의 내용을 앱바(App Bar)에 반영


}