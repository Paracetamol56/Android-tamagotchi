/*
 * Created on Sun Jun 13 2021
 *
 * Copyright (c) 2021 - Mathéo G & Sahel H - All Right Reserved
 *
 * Licensed under the Apache License, Version 2.0
 * Available on GitHub at https://github.com/Paracetamol56/Android-tamagotchi
 */

package com.example.tamagotchi.mvc1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.tamagotchi.R;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;


public class Pnl1_View extends LinearLayout implements Observer {
    public Pnl1_Ctrl refCtrl;
    public Pnl1_Mdl refMdl;

    public Button btnGotoPnl2;
    public Button btnGotoPnl3;

    public ImageView Image;



    public Pnl1_View(Context context) {
        super(context);

        LayoutInflater inflater= ((Activity)context).getLayoutInflater();
        inflater.inflate(R.layout.layout_pnl1, this);

        btnGotoPnl2= (Button)findViewById(R.id.btnGotoPnl2);
        btnGotoPnl3= (Button)findViewById(R.id.btnGotoPnl3);

        Image=(ImageView)findViewById(R.id.MainImage);

        //Random pics
        final int random = new Random().nextInt(4);

        switch (random)
        {
            case 0 :
                Image.setImageResource(R.drawable.heureux);
                break;
            case 1 :
                Image.setImageResource(R.drawable.triste);
                break;
            case 2 :
                Image.setImageResource(R.drawable.faim);
                break;
            case 3 :
                Image.setImageResource(R.drawable.drogue);
                break;
        }


    }

    public void setRefCtrl(Pnl1_Ctrl c) {
        refCtrl= c;
        btnGotoPnl2.setOnClickListener(refCtrl);
        btnGotoPnl3.setOnClickListener(refCtrl);
    }


    @Override
    public void update(Observable o, Object arg) {

    }
}
