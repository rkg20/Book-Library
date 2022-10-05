package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.booklibrary.databinding.ActivityReadBookBinding;

import es.voghdev.pdfviewpager.library.PDFViewPager;
import es.voghdev.pdfviewpager.library.RemotePDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;
import es.voghdev.pdfviewpager.library.remote.DownloadFile;

public class ReadBookActivity extends AppCompatActivity implements DownloadFile.Listener {

    ActivityReadBookBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityReadBookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();
        String url=getIntent().getStringExtra("url");
        String bookName=getIntent().getStringExtra("bookName");
        binding.bookName.setText(bookName);
        RemotePDFViewPager remotePDFViewPager=
                new RemotePDFViewPager(ReadBookActivity.this,url,this);

    }

    @Override
    public void onSuccess(String url, String destinationPath) {

        PDFPagerAdapter adapter = new PDFPagerAdapter(this,extractFileNameFromURL(url));
        binding.pdfViewPager.setAdapter(adapter);


    }
    public static String extractFileNameFromURL(String url){

        return url.substring(url.lastIndexOf('/')+1);
    }
    @Override
    public void onFailure(Exception e) {

    }

    @Override
    public void onProgressUpdate(int progress, int total) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}