package com.example.gamaya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class BaseActivity extends AppCompatActivity {

    public void loadFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .add(fragment, fragment.getTag())
                .commit();
    }

    public void loadFragmentBackstack(Fragment fragment, String backstackName){
        getSupportFragmentManager().beginTransaction()
                .add(fragment, fragment.getTag())
                .addToBackStack(backstackName)
                .commit();
    }
}
