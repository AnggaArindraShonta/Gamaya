package com.example.gamaya;

import android.widget.Toast;

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

    public void shortToast(String message){
        Toast.makeText(this, (message != null) ? message : "", Toast.LENGTH_SHORT).show();
    }

    public void longToast(String message){
        Toast.makeText(this, (message != null) ? message : "", Toast.LENGTH_LONG).show();
    }
}
