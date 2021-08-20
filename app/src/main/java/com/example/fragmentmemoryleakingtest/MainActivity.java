package com.example.fragmentmemoryleakingtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new BlankFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(android.R.id.content, fragment)
                        .addToBackStack(null)
                        .commitAllowingStateLoss();
                fragmentList.add(fragment);
            }
        });
    }
}