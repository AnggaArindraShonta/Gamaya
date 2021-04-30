package com.example.gamaya;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class BaseActivity extends AppCompatActivity {

    public void loadFragment(Fragment fragment, @IdRes int containerId){
        getSupportFragmentManager().beginTransaction()
                .add(containerId, fragment)
                .commit();
    }

    public void loadFragmentBackstack(Fragment fragment, @IdRes int containerId, String backstackName){
        getSupportFragmentManager().beginTransaction()
                .add(containerId, fragment)
                .addToBackStack(backstackName)
                .commit();
    }
}
