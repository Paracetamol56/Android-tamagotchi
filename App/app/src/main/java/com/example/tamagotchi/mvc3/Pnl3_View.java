package com.example.tamagotchi.mvc3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tamagotchi.R;

import java.util.Observable;
import java.util.Observer;

public class Pnl3_View extends LinearLayout implements Observer {
    public Button btnPlus;
    public Button btnMoins;
    public Button btnRaz;
    public TextView txtEntier;

    public Pnl3_Mdl refMdl;
    public Pnl3_Ctrl refCtrl;

    public Button btnGotoPnl1;

    public Pnl3_View(Context context) {
        super(context);

        LayoutInflater inflater= ((Activity)context).getLayoutInflater();
        inflater.inflate(R.layout.layout_pnl3, this);

        btnPlus = findViewById(R.id.btnPlus);
        btnMoins = findViewById(R.id.btnMoins);
        btnRaz = findViewById(R.id.btnRaz);
        txtEntier = findViewById(R.id.txtEntier);

        btnGotoPnl1= (Button)findViewById(R.id.btnGotoPnl1);
    }

    public void setRefCtrl(Pnl3_Ctrl c) {
        refCtrl= c;
        btnPlus.setOnClickListener(refCtrl);
        btnMoins.setOnClickListener(refCtrl);
        btnRaz.setOnClickListener(refCtrl);
        btnGotoPnl1.setOnClickListener(refCtrl);
    }

    @Override
    public void update(Observable observable, Object o) {
        txtEntier.setText(Integer.toString(refMdl.getNbVaccins()));

        if (refMdl.nbVaccinsMax()) {
            btnPlus.setEnabled(true);
        }
        else {
            btnPlus.setEnabled(false);
        }
        if (refMdl.nbVaccinsMin()) {
            btnMoins.setEnabled(true);
            btnRaz.setEnabled(true);
        }
        else {
            btnMoins.setEnabled(false);
            btnRaz.setEnabled(false);
        }
    }
}
