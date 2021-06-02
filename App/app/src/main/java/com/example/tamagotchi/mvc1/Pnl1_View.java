package com.example.tamagotchi.mvc1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.tamagotchi.R;

public class Pnl1_View extends LinearLayout {
    public Pnl1_Ctrl refCtrl;

    public Button btnGotoPnl2;

    public Pnl1_View(Context context) {
        super(context);

        LayoutInflater inflater= ((Activity)context).getLayoutInflater();
        inflater.inflate(R.layout.layout_pnl1, this);

        btnGotoPnl2= (Button)findViewById(R.id.btnGotoPnl2);
    }

    public void setRefCtrl(Pnl1_Ctrl c) {
        refCtrl= c;
        btnGotoPnl2.setOnClickListener(refCtrl);
    }


}
