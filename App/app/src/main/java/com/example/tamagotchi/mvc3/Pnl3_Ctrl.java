package com.example.tamagotchi.mvc3;

import android.view.KeyEvent;
import android.view.View;

import com.example.tamagotchi.PnlManager;
import com.example.tamagotchi.R;
import com.example.tamagotchi.mvc2.Pnl2_Mdl;

public class Pnl3_Ctrl implements View.OnClickListener,View.OnKeyListener {
    public Pnl3_Mdl refMdl;
    public Pnl3_View refView;
    public PnlManager refPnlManager;


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.inputTamagotchiName) {

        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        switch(v.getId()){
            case R.id.inputTamagotchiName:
                refMdl.setTamagotchiNameStr(refView.TamagotchiName.toString());
                refMdl.setPlayerNameStr(refView.PlayerName.toString());

                break;

        }
        return false;
    }
}
