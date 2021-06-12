package com.example.tamagotchi.mvc3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tamagotchi.R;
import com.example.tamagotchi.mvc2.Pnl2_Ctrl;
import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

import java.util.Observable;
import java.util.Observer;

public class Pnl3_View extends LinearLayout implements Observer{
    public Pnl3_Ctrl refCtrl;
    public Button btnGotoPnl2;
    public Pnl3_Mdl refMdl;

    public TextInputEditText TamagotchiName;
    public TextInputEditText PlayerName;



    @SuppressLint("WrongViewCast")
    public Pnl3_View(Context context) {
        super(context);

        LayoutInflater inflater= ((Activity)context).getLayoutInflater();
        inflater.inflate(R.layout.layout_pnl3, this);

        btnGotoPnl2= (Button)findViewById(R.id.btnGotoPnl1);

        TamagotchiName =(TextInputEditText)findViewById(R.id.inputTamagotchiName);
        PlayerName=(TextInputEditText)findViewById(R.id.inputPlayerName);



    }

    public void setRefCtrl(Pnl3_Ctrl c) {
        refCtrl= c;
        btnGotoPnl2.setOnClickListener(refCtrl);

    }

    @Override
    public void update(Observable o, Object arg) {
        if(PlayerName.getText().toString() != "" ){
            refMdl.setPlayerNameStr(PlayerName.getText().toString());
        }
        if (TamagotchiName.getText().toString()!= ""){
            refMdl.setTamagotchiNameStr((TamagotchiName.getText().toString()));
        }
    }
}
