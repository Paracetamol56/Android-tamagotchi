package com.example.tamagotchi.mvc2;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tamagotchi.R;

import java.util.Observable;
import java.util.Observer;

public class Pnl2_View extends LinearLayout implements Observer {
    public Button btnCaresse;
    public Button btnJouet;
    public Button btnNourrir;

    public TextView txtHeader;
    public TextView txtMessage;
    public TextView txtFaim;
    public TextView txtBonheur;

    public Pnl2_Mdl refMdl;
    public Pnl2_Ctrl refCtrl;

    public Button btnGotoPnl1;
    public Button btnGotoPnl3;

    public Pnl2_View(Context context) {
        super(context);

        LayoutInflater inflater= ((Activity)context).getLayoutInflater();
        inflater.inflate(R.layout.layout_pnl2, this);

        btnCaresse = (Button)findViewById(R.id.btnCaresse);
        btnJouet = (Button)findViewById(R.id.btnJouet);
        btnNourrir = (Button)findViewById(R.id.btnNourrir);

        txtHeader = (TextView)findViewById(R.id.txtHeader);
        txtFaim = (TextView)findViewById(R.id.txtHunger);
        txtBonheur = (TextView)findViewById(R.id.txtHappiness);
        txtMessage = (TextView)findViewById(R.id.txtMessage);

        btnGotoPnl1 = (Button)findViewById(R.id.btnGotoPnl1);
        btnGotoPnl3 = (Button)findViewById(R.id.btnGotoPnl3);
    }

    public void setRefCtrl(Pnl2_Ctrl c) {
        refCtrl= c;
        btnCaresse.setOnClickListener(refCtrl);
        btnJouet.setOnClickListener(refCtrl);
        btnNourrir.setOnClickListener(refCtrl);

        btnGotoPnl1.setOnClickListener(refCtrl);
        btnGotoPnl3.setOnClickListener(refCtrl);
    }

    @Override
    public void update(Observable observable, Object o) {
        txtHeader.setText("Mes chaussettes sont sales");

        Log.i("yo", findViewById(R.id.txtHunger).toString());
        Log.i("yo", findViewById(R.id.txtHunger).toString());

        //txtFaim.setText(Integer.toString(refMdl.getHunger()));
        //txtBonheur.setText(Integer.toString(refMdl.getHappiness()));

        switch (refMdl.getMood())
        {
            case HAPPY:
                txtMessage.setText("Content");
            case SAD:
                txtMessage.setText("Triste");
            case HUNGRY:
                txtMessage.setText("Trop faim");
            case DEAD:
                txtMessage.setText("Dead");
        }
    }
}
