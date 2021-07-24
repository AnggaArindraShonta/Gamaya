package com.example.gamaya.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.gamaya.databinding.ActivityPetunjukBinding;
import com.example.gamaya.databinding.ActivityProfileBinding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class ProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnBack.setOnClickListener(v -> onBackPressed());
    }
}