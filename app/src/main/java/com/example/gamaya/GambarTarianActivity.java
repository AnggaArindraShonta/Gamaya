package com.example.gamaya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.github.barteksc.pdfviewer.PDFView;

public class GambarTarianActivity extends AppCompatActivity {

    public PDFView pdfView;
    public float zoomValue=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gambar_tarian);

        pdfView = (PDFView)findViewById(R.id.pdfView);
        pdfView.fromAsset("tarian.pdf").defaultPage(-1)
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