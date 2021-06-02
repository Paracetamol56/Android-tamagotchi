package com.example.tamagotchi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PnlManager manager= PnlManager.getInstance(this);
        manager.setPnl(1);
    }
}