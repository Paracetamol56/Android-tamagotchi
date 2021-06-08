package com.example.tamagotchi.mvc3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.tamagotchi.R;
import com.example.tamagotchi.mvc2.Pnl2_Ctrl;

public class Pnl3_View extends LinearLayout {
    public Pnl3_Ctrl refCtrl;
    public Button btnGotoPnl2;

    private EditText txtTamagotchiName;
    private EditText txtPlayerName;

    public Pnl3_View(Context context) {
        super(context);

        LayoutInflater inflater= ((Activity)context).getLayoutInflater();
        inflater.inflate(R.layout.layout_pnl3, this);

        btnGotoPnl2= (Button)findViewById(R.id.btnGotoPnl1);

        txtTamagotchiName = (EditText)findViewById(R.id.inputTamagotchiName);
        txtTamagotchiName = (EditText)findViewById(R.id.inputPlayerName);
    }

    public void setRefCtrl(Pnl3_Ctrl c) {
        refCtrl= c;
        btnGotoPnl2.setOnClickListener(refCtrl);
        txtTamagotchiName.setOnClickListener(refCtrl);
        txtPlayerName.setOnClickListener(refCtrl);
    }
}
