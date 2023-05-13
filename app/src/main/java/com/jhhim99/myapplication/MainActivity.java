package com.jhhim99.myapplication;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;


import android.view.MenuItem;


import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {
    HomeFragment homeFrament;
    ManageFragment manageFragment;
    UserFragment userFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFrament = new HomeFragment();
        manageFragment = new ManageFragment();
        userFragment = new UserFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.containers, homeFrament).commit();

        NavigationBarView navigationBarView = findViewById(R.id.bottom_navigationview);
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers, homeFrament).commit();
                        return true;
                    case R.id.fork:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers, manageFragment).commit();
                        return true;
                    case R.id.user:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers, userFragment).commit();
                        return true;
                }
                return false;
            }
        });


   }

    // 메뉴 리소스 XML의 내용을 앱바(App Bar)에 반영


}