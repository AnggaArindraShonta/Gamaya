package com.example.gamaya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.gamaya.databinding.ActivityPetunjukBinding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class PetunjukActivity extends AppCompatActivity {

    private ActivityPetunjukBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPetunjukBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnBack.setOnClickListener(v -> {
            new MaterialAlertDialogBuilder(this)
                    .setTitle("Keluar Dari Tebak Gambar")
                    .setMessage("Anda yakin ingin mengakhiri tebak gambar?")
                    .setPositiveButton("Keluar", (dialog, which) -> onBackPressed())
                    .setNegativeButton("Lanjut Tebak Gambar", (dialog, which) -> dialog.dismiss())
                    .create()
                    .show();
        });
    }
}