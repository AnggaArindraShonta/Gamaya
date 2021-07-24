package com.example.gamaya.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.gamaya.R;
import com.github.barteksc.pdfviewer.PDFView;

public class RumahActivity extends AppCompatActivity {

    public PDFView pdfView;
    public float zoomValue=1;
    ImageButton btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rumah);

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RumahActivity.this, MenuMateriActivity.class);
                startActivity(intent);
            }
        });

        pdfView = (PDFView)findViewById(R.id.pdfView);
        pdfView.fromAsset("rumah.pdf").defaultPage(-1)
                .spacing(10)
                .load();
    }

    public void nextPage(View view){
        pdfView.jumpTo(pdfView.getCurrentPage()+1,true);
    }
    public void previousPage(View view){
        pdfView.jumpTo(pdfView.getCurrentPage()-1,true);
    }

    public void zoomIn(View view){
        ++zoomValue;
        pdfView.zoomTo(zoomValue);
        pdfView.loadPages();
    }

    public void zoomOut(View view){
        if (zoomValue!=1){
            --zoomValue;
            pdfView.zoomTo(zoomValue);
            pdfView.loadPages();
        }
    }
}