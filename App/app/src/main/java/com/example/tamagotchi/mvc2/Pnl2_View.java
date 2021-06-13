/*
 * Created on Sun Jun 13 2021
 *
 * Copyright (c) 2021 - Mathéo G & Sahel H - All Right Reserved
 *
 * Licensed under the Apache License, Version 2.0
 * Available on GitHub at https://github.com/Paracetamol56/Android-tamagotchi
 */

package com.example.tamagotchi.mvc2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tamagotchi.R;

import java.util.Observable;
import java.util.Observer;

public class Pnl2_View extends LinearLayout implements Observer {
    public Button btnSmoke;
    public Button btnFastFood;
    public Button btnDrugs;

    public TextView txtHeader;
    public TextView txtMessage;
    public TextView txtFaim;
    public TextView txtBonheur;

    public Pnl2_Mdl refMdl;
    public Pnl2_Ctrl refCtrl;

    public Button btnGotoPnl1;
    public Button btnGotoPnl3;

    public ImageView State;

    public Pnl2_View(Context context) {
        super(context);

        LayoutInflater inflater= ((Activity)context).getLayoutInflater();
        inflater.inflate(R.layout.layout_pnl2, this);

        btnSmoke = (Button)findViewById(R.id.btnSmoke);
        btnFastFood = (Button)findViewById(R.id.btnFastFood);
        btnDrugs = (Button)findViewById(R.id.btnDrugs);

        txtHeader = (TextView)findViewById(R.id.txtHeader);
        txtFaim = (TextView)findViewById(R.id.txtHunger);
        txtBonheur = (TextView)findViewById(R.id.txtHappiness);
        txtMessage = (TextView)findViewById(R.id.txtMessage);

        btnGotoPnl1 = (Button)findViewById(R.id.btnGotoPnl2);
        btnGotoPnl3 = (Button)findViewById(R.id.btnGotoPnl3);

        State =(ImageView)findViewById(R.id.State);
    }

    public void setRefCtrl(Pnl2_Ctrl c) {
        refCtrl= c;
        btnSmoke.setOnClickListener(refCtrl);
        btnFastFood.setOnClickListener(refCtrl);
        btnDrugs.setOnClickListener(refCtrl);

        btnGotoPnl1.setOnClickListener(refCtrl);
        btnGotoPnl3.setOnClickListener(refCtrl);
    }

    @Override
    public void update(Observable observable, Object o) {
        txtHeader.setText("Mes chaussettes sont sales");

        txtFaim.setText(Integer.toString(refMdl.getHunger()));
        txtBonheur.setText(Integer.toString(refMdl.getHappiness()));

        switch (refMdl.getMood())
        {
            case HAPPY:
                txtMessage.setText("Content");
                State.setImageResource(R.drawable.heureux);
                break;
            case SAD:
                txtMessage.setText("Triste");
                State.setImageResource(R.drawable.triste);
                break;
            case HUNGRY:
                txtMessage.setText("Trop faim");
                State.setImageResource(R.drawable.faim);
                break;
            case DEAD:
                txtMessage.setText("Dead");
                State.setImageResource(R.drawable.mort);
                btnDrugs.setEnabled(false);
                btnFastFood.setEnabled(false);
                btnSmoke.setEnabled(false);
                break;
            case OVERDOSE :
                txtMessage.setText("Tu fais une overdose");
                State.setImageResource(R.drawable.drogue);
                break;
        }
    }
}
