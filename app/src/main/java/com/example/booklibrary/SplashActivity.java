package com.example.booklibrary;



import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.example.booklibrary.MainActivity;
import com.example.booklibrary.R;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread =new Thread( ()->{

            try{
                Thread.sleep(1000);
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
            finally {
                Intent intent=new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });thread.start();

    }
}
